package com.reactx.selection.web.controller.reactx;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.plugins.Page;
import com.reactx.selection.models.base.BaseController;
import com.reactx.selection.models.base.Result;
import com.reactx.selection.models.data.index.ImsSeller;
import com.reactx.selection.models.data.local.KeguanShop;
import com.reactx.selection.service.reactx.ImsSellerService;
import com.reactx.selection.service.reactx.ImsTaobaoOrderService;
import com.reactx.selection.service.reactx.impl.KeguanShopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/discount")
@Api(value = "discount", description = "线下优惠相关")
public class LocalDiscountController extends BaseController {

        @Autowired
        private KeguanShopService keguanShopService;

        @GetMapping("/getAllCity")
        @ApiOperation(value = "获取所有市", httpMethod = "GET", produces = "application/json;charset=UTF-8")
        public Result<Object> getUserOrders() {
            return response(keguanShopService.getAllCity());
        }


    @GetMapping("/getLocalShop")
    @ApiOperation(value = "分页获取所有门店信息", httpMethod = "GET", produces = "application/json;charset=UTF-8")
    @ApiImplicitParams({@ApiImplicitParam(name = "cityName", value = "市名称", paramType = "query", required = false),
            @ApiImplicitParam(name = "shopName", value = "门店名称", paramType = "query", required = false),
            @ApiImplicitParam(name = "pageSize", value = "每页展示数量", paramType = "query", required = false),
            @ApiImplicitParam(name = "pageNo", value = "当前页", paramType = "query", required = false),
            @ApiImplicitParam(name = "wechatid", value = "微信id", paramType = "query", required = false)})
    public Result<Object> getLocalShop(String cityName,String shopName,Integer pageSize,Integer pageNo,String wechatid) {
        //url解码
        if(StringUtils.isNotBlank(cityName) && cityName.contains("%")){
            try {
                cityName = java.net.URLDecoder.decode(cityName, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                cityName=cityName;
            }
        }
        if(StringUtils.isNotBlank(shopName) && shopName.contains("%")){
            try {
                shopName = java.net.URLDecoder.decode(shopName, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                shopName=shopName;
            }
        }
        List<KeguanShop> page = keguanShopService.findPage(cityName,shopName,pageSize,pageNo,wechatid);
        return response(page);
    }



}
