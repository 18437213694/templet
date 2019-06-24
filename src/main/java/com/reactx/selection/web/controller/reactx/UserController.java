package com.reactx.selection.web.controller.reactx;

import com.reactx.selection.configs.redis.RedisRepository;
import com.reactx.selection.models.base.BaseController;
import com.reactx.selection.models.base.Result;
import com.reactx.selection.models.base.SysStatic;
import com.reactx.selection.models.data.index.ImsSeller;
import com.reactx.selection.models.data.response.GroupDataResponse;
import com.reactx.selection.models.data.response.OrderResponse;
import com.reactx.selection.models.data.response.UserInfoResponse;
import com.reactx.selection.service.reactx.ImsSellerService;
import com.reactx.selection.service.reactx.ImsTaobaoOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Api(value = "user", description = "用户相关")
public class UserController extends BaseController {

    @Autowired
    private ImsSellerService sellerService;
    @Autowired
    private RedisRepository redisRepository;
    @Autowired
    private ImsTaobaoOrderService taobaoOrderService;


    @GetMapping("/getindex")
    @ApiOperation(value = "获取用户基础信息", httpMethod = "GET", produces = "application/json;charset=UTF-8")
    @ApiImplicitParam(name = "wcId", value = "微信id", paramType = "query", required = true)
    public Result<Object> getindex(String wcId) {
        ImsSeller seller = sellerService.findByWechatid(wcId);
        if(seller == null)
            return responseMsg("用户未绑定，请先去绑定");
        UserInfoResponse response = new UserInfoResponse();
        response.setCreateTime(seller.getCreateTime());
        DecimalFormat decimalFormat = new DecimalFormat("####.00");
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        response.setLevel(sellerService.getLevelByUser(seller.getSellerlevel()).getName());
        response.setNoSettleMoney(sellerService.getnoSettleIncome(seller.getId())==null?"0":decimalFormat.format(sellerService.getnoSettleIncome(seller.getId())));
        response.setTeamSum(redisRepository.length(SysStatic.TEAM_DIRECTLY_UNDER_KEY_ID_ + seller.getId())+redisRepository.length(SysStatic.TEAM_RECOMMEND_KEY_ID_ + seller.getId()));
        Map<String, Object> map = sellerService.getPayInforma(seller.getId());
        response.setPayMoney(map.get("payMoney").toString().equals("0")?"0":decimalFormat.format(getBigDecimal(map.get("payMoney"))));
        response.setPayNum(Long.parseLong(String.valueOf(map.get("payNum"))));
        response.setRefundMoney(map.get("refundMoney").toString().equals("0")?"0":decimalFormat.format(getBigDecimal(map.get("refundMoney"))));
        response.setRefundNum(Long.parseLong(String.valueOf(map.get("refundNum"))));
        response.setSettledMoney(sellerService.getalreadySettleIncome(seller.getId())==null?"0":decimalFormat.format(sellerService.getalreadySettleIncome(seller.getId())));
        response.setRequestName(sellerService.findNickById(seller.getParentid())==null?"":sellerService.findNickById(seller.getParentid()));
        response.setOrderSum(taobaoOrderService.getOrderSum(seller.getId()));

        //订单记录
        Double comm = sellerService.queryCommRatio(seller.getSellerlevel());
        response.setOrders(taobaoOrderService.getOrderByUser(seller.getId(),comm));
        return response(response);
    }

    @GetMapping("/getGroup")
    @ApiOperation(value = "获取群基础信息", httpMethod = "GET", produces = "application/json;charset=UTF-8")
    @ApiImplicitParam(name = "userName", value = "群里所以成员微信id，多个逗号隔开", paramType = "query", required = true)
    public Result<Object> getGroup(String userName) {
        if(StringUtils.isBlank(userName)){
            return response("传入正确的微信id");
        }
        List<String> wcId = new ArrayList<>();
//        wcId.add("wxid_epl7fnfdvxm822");
//        wcId.add("wxid_dezhf5calapt21");
        String[] split = userName.split(",");
        for(String s:split){
            wcId.add(s);
        }
        GroupDataResponse response = new GroupDataResponse();
        BigDecimal groupSumTransaMoney = BigDecimal.ZERO;
        BigDecimal groupNoSettleMoney = BigDecimal.ZERO;
        BigDecimal groupSettleMoney= BigDecimal.ZERO;
        Long groupPayNum = 0L;
        BigDecimal groupPayMoney= BigDecimal.ZERO;
        Long groupRefundNum = 0L;
        BigDecimal groupRefundMoney= BigDecimal.ZERO;
        Long groupOrderSum = 0L;
        List<OrderResponse> orders = new ArrayList<>();
        for(String wcid:wcId){
            ImsSeller seller = sellerService.findByWechatid(wcid);
            if(seller==null){
                break;
            }
            groupNoSettleMoney=groupNoSettleMoney.add(sellerService.getnoSettleIncome(seller.getId()) == null?BigDecimal.ZERO:sellerService.getnoSettleIncome(seller.getId()));
            Map<String, Object> map = sellerService.getPayInforma(seller.getId());
            groupPayMoney=groupPayMoney.add(getBigDecimal(map.get("payMoney")));
            groupPayNum += Long.parseLong(String.valueOf(map.get("payNum")));
            groupRefundMoney=groupRefundMoney.add(getBigDecimal(map.get("refundMoney")));
            groupRefundNum+=Long.parseLong(String.valueOf(map.get("refundNum")));
            groupOrderSum+=taobaoOrderService.getOrderSum(seller.getId());
            groupSettleMoney=groupSettleMoney.add(sellerService.getalreadySettleIncome(seller.getId())==null?BigDecimal.ZERO:sellerService.getalreadySettleIncome(seller.getId()));
            groupSumTransaMoney=groupSumTransaMoney.add(taobaoOrderService.getPrice(seller.getId())==null?BigDecimal.ZERO:taobaoOrderService.getPrice(seller.getId()));

            Double comm = sellerService.queryCommRatio(seller.getSellerlevel());
            orders = taobaoOrderService.getOrderByUser(seller.getId(), comm);
        }
        DecimalFormat decimalFormat = new DecimalFormat("####.00");
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        response.setCreateTime(new Date());
        response.setGroupNoSettleMoney(groupNoSettleMoney.compareTo(BigDecimal.ZERO) == 0?"0":decimalFormat.format(groupNoSettleMoney));
        response.setGroupOrderSum(groupOrderSum);
        response.setGroupPayMoney(groupPayMoney.compareTo(BigDecimal.ZERO) == 0?"0":decimalFormat.format(groupPayMoney));
        response.setGroupPayNum(groupPayNum);
        response.setGroupRefundMoney(groupRefundMoney.compareTo(BigDecimal.ZERO) == 0?"0":decimalFormat.format(groupRefundMoney));
        response.setGroupRefundNum(groupRefundNum);
        response.setGroupSettleMoney(groupSettleMoney.compareTo(BigDecimal.ZERO) == 0?"0":decimalFormat.format(groupSettleMoney));
        response.setGroupSumTransaMoney(groupSumTransaMoney.compareTo(BigDecimal.ZERO) == 0?"0":decimalFormat.format(groupSumTransaMoney));
        response.setGroupOrders(orders);
        return response(response);
    }

    public static BigDecimal getBigDecimal( Object value ) {
        BigDecimal ret = null;
        if( value != null ) {
            if( value instanceof BigDecimal ) {
                ret = (BigDecimal) value;
            } else if( value instanceof String ) {
                ret = new BigDecimal( (String) value );
            } else if( value instanceof BigInteger) {
                ret = new BigDecimal( (BigInteger) value );
            } else if( value instanceof Number ) {
                ret = new BigDecimal( ((Number)value).doubleValue() );
            } else {
                throw new ClassCastException("Not possible to coerce ["+value+"] from class "+value.getClass()+" into a BigDecimal.");
            }
        }
        return ret;
    }



}
