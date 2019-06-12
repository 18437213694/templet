package com.reactx.selection.web.controller.reactx;

import com.reactx.selection.models.base.BaseController;
import com.reactx.selection.models.base.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@Api(value = "user", description = "用户相关")
public class UserController extends BaseController {


    @PostMapping("/getindex")
    @ApiOperation(value = "获取用户基础信息", httpMethod = "POST", produces = "application/json;charset=UTF-8")
    @ApiImplicitParam(name = "wcId", value = "微信id", paramType = "query", required = true)
    public Result<Object> getindex(String wcId) {

        return response();
    }

    @PostMapping("/getGroup")
    @ApiOperation(value = "获取群基础信息", httpMethod = "POST", produces = "application/json;charset=UTF-8")
    public Result<Object> getGroup(@RequestBody List<String> wcId) {

        return response();
    }






}
