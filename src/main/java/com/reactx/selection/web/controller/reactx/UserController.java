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
@RequestMapping("/user")
@Api(value = "user", description = "用户相关")
public class UserController extends BaseController {


    @PostMapping("/getindex")
    @ApiOperation(value = "获取用户基础信息", httpMethod = "POST", produces = "application/json;charset=UTF-8")
    @ApiImplicitParam(name = "wcId", value = "微信id", paramType = "query", required = true)
    public Result<Object> getGroupOrder(String wcId) {

        return response();
    }


    @GetMapping("/getReply")
    @ApiOperation(value = "获取快速回复", httpMethod = "GET", produces = "application/json;charset=UTF-8")
    @ApiImplicitParams({@ApiImplicitParam(name = "startTime", value = "开始时间", paramType = "query", required = false),
            @ApiImplicitParam(name = "group", value = "分组id", paramType = "query", required = false),
            @ApiImplicitParam(name = "subGroup", value = "二级分组id", paramType = "query", required = false),
            @ApiImplicitParam(name = "wcId", value = "用户微信id", paramType = "query", required = true)
    })
    public Result<Object> getUserOrders() {

        return response();
    }



}
