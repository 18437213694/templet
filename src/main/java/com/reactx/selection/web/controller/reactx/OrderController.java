package com.reactx.selection.web.controller.reactx;

import com.reactx.selection.models.base.BaseController;
import com.reactx.selection.models.base.Result;
import com.reactx.selection.models.data.index.ImsSeller;
import com.reactx.selection.models.data.response.OrderResponse;
import com.reactx.selection.service.reactx.ImsSellerService;
import com.reactx.selection.service.reactx.ImsTaobaoOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
@Api(value = "order", description = "订单相关")
public class OrderController extends BaseController {

    @Autowired
    private ImsTaobaoOrderService taobaoOrderService;
    @Autowired
    private ImsSellerService sellerService;


    @GetMapping("/getGroupOrders")
    @ApiOperation(value = "获取群订单", httpMethod = "GET", produces = "application/json;charset=UTF-8")
    @ApiImplicitParams({@ApiImplicitParam(name = "startTime", value = "开始时间(yyyy-MM-dd)", paramType = "query", required = false),
            @ApiImplicitParam(name = "endTime", value = "结束时间(yyyy-MM-dd)", paramType = "query", required = false),
            @ApiImplicitParam(name = "pageSize", value = "分页大小", paramType = "query", required = false),
            @ApiImplicitParam(name = "pageNo", value = "当前页", paramType = "query", required = false),
            @ApiImplicitParam(name = "nick", value = "用户昵称", paramType = "query", required = false),
            @ApiImplicitParam(name = "status", value = "订单状态", paramType = "query", required = false),
            @ApiImplicitParam(name = "source", value = "订单来源", paramType = "query", required = false),
            @ApiImplicitParam(name = "orderNum", value = "订单号", paramType = "query", required = false),
            @ApiImplicitParam(name = "userName", value = "群里所以成员微信id，多个逗号隔开", paramType = "query", required = false)
    })
    public Result<Object> getGroupOrder(String startTime,String endTime,String status,String source,
                                        String orderNum,String userName,Integer pageSize,Integer pageNo,String nick) {
        List<String> ids = new ArrayList<>();
        Map<String,Double> map = new HashMap<>();//设置约返
        if(StringUtils.isNotBlank(nick) && StringUtils.isNotBlank(userName)){
            return response("用户昵称和群微信id只能取一个");
        }else if(StringUtils.isNotBlank(nick)){
            ids=sellerService.findIdsByUserBick(nick);
        }else {
            List<String> wcId = new ArrayList<>();
            String[] split = userName.split(",");
            for(String s:split){
                wcId.add(s);
            }
            for(String id:wcId){
                ImsSeller seller = sellerService.findByWechatid(id);
                if(seller !=null){
                    ids.add(seller.getId().toString());
                }
            }
        }
        if(ids.size()>0){
            for (String id:ids){
                ImsSeller seller = sellerService.findById(id);
                map.put(id,sellerService.queryCommRatio(seller==null?2:seller.getSellerlevel()));
            }
        }
        if(source != null){
            if(source.contains("淘宝")){
                source = "1";
            }else if(source.contains("拼多多")){
                source = "2";
            }else if(source.contains("京东")){
                source = "3";
            }
        }
        Map<String,Object> result = taobaoOrderService.getOrderListByGroup(ids, map, startTime, endTime, status, source, orderNum, pageSize, pageNo);
        return response(result);
    }


    @GetMapping("/getUserOrders")
    @ApiOperation(value = "获取单个用户订单", httpMethod = "GET", produces = "application/json;charset=UTF-8")
    @ApiImplicitParams({@ApiImplicitParam(name = "startTime", value = "开始时间(yyyy-MM-dd)", paramType = "query", required = false),
            @ApiImplicitParam(name = "endTime", value = "结束时间(yyyy-MM-dd)", paramType = "query", required = false),
            @ApiImplicitParam(name = "pageSize", value = "分页大小", paramType = "query", required = false),
            @ApiImplicitParam(name = "pageNo", value = "当前页", paramType = "query", required = false),
            @ApiImplicitParam(name = "status", value = "订单状态", paramType = "query", required = false),
            @ApiImplicitParam(name = "source", value = "订单来源", paramType = "query", required = false),
            @ApiImplicitParam(name = "orderNum", value = "订单号", paramType = "query", required = false),
            @ApiImplicitParam(name = "userName", value = "用户微信id", paramType = "query", required = true)
    })
    public Result<Object> getUserOrders(String startTime,String endTime,String status,String source,
                                        String orderNum,String userName,Integer pageSize,Integer pageNo) {
        ImsSeller seller = sellerService.findByWechatid(userName);
        if(seller == null)
            return responseMsg("用户未绑定，请先去绑定");
        if(source != null){
            if(source.contains("淘宝")){
                source = "1";
            }else if(source.contains("拼多多")){
                source = "2";
            }else if(source.contains("京东")){
                source = "3";
            }
        }
        Double comm = sellerService.queryCommRatio(seller.getSellerlevel());
        Map<String,Object> result = taobaoOrderService.getOrderListByUser(seller.getId(), comm, startTime, endTime, status,
                                                                            source, orderNum,pageSize,pageNo);
        return response(result);
    }



}
