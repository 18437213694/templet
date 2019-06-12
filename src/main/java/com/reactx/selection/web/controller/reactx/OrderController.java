package com.reactx.selection.web.controller.reactx;

import com.reactx.selection.models.base.BaseController;
import com.reactx.selection.models.base.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@Api(value = "order", description = "订单相关")
public class OrderController extends BaseController {


    @PostMapping("/getGroupOrders")
    @ApiOperation(value = "获取群订单", httpMethod = "POST", produces = "application/json;charset=UTF-8")
    @ApiImplicitParams({@ApiImplicitParam(name = "startTime", value = "开始时间", paramType = "query", required = false),
            @ApiImplicitParam(name = "endTime", value = "结束时间", paramType = "query", required = false),
            @ApiImplicitParam(name = "status", value = "订单状态", paramType = "query", required = false),
            @ApiImplicitParam(name = "source", value = "订单来源", paramType = "query", required = false),
            @ApiImplicitParam(name = "orderNum", value = "订单号", paramType = "query", required = false)
    })
    public Result<Object> getGroupOrder() {

        return response();
    }


    @GetMapping("/getUserOrders")
    @ApiOperation(value = "获取单个用户订单", httpMethod = "GET", produces = "application/json;charset=UTF-8")
    @ApiImplicitParams({@ApiImplicitParam(name = "startTime", value = "开始时间", paramType = "query", required = false),
            @ApiImplicitParam(name = "endTime", value = "结束时间", paramType = "query", required = false),
            @ApiImplicitParam(name = "status", value = "订单状态", paramType = "query", required = false),
            @ApiImplicitParam(name = "source", value = "订单来源", paramType = "query", required = false),
            @ApiImplicitParam(name = "orderNum", value = "订单号", paramType = "query", required = false),
            @ApiImplicitParam(name = "unionId", value = "用户unionId", paramType = "query", required = true)
    })
    public Result<Object> getUserOrders() {

        return response();
    }



}
