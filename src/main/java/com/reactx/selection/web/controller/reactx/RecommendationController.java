package com.reactx.selection.web.controller.reactx;

import com.alibaba.fastjson.JSONObject;
import com.reactx.selection.models.base.BaseController;
import com.reactx.selection.models.base.Result;
import com.reactx.selection.models.data.response.HaoDanKuResponse;
import com.reactx.selection.models.data.response.SpecialThemeResponse;
import com.reactx.selection.service.reactx.HDKService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.util.Collections;

@RestController
@RequestMapping("/recommendation")
@Api(value = "recommendation", description = "商品推荐")
public class RecommendationController extends BaseController {

    @Autowired
    HDKService hdkService;

    @GetMapping("/getHotSale")
    @ApiOperation(value = "获取淘宝24小时热销榜", httpMethod = "GET", produces = "application/json;charset=UTF-8")
    @ApiImplicitParams({@ApiImplicitParam(name = "back", value = "每页返回条数（请在1,2,10,20,50,100,120,200,500,1000中选择一个数值返回）", paramType = "query", required = true),
            @ApiImplicitParam(name = "minId", value = "分页，用于实现类似分页抓取效果，来源于上次获取后的数据的min_id值，默认开始请求值为1", paramType = "query", required = true),
            @ApiImplicitParam(name = "cid", value = "0全部，1女装，2男装，3内衣，4美妆，5配饰，6鞋品，7箱包，8儿童，9母婴，10居家，11美食，12数码，13家电，14其他，15车品，16文体，17宠物（支持多类目筛选，如1,2获取类目为女装、男装的商品，逗号仅限英文逗号）", paramType = "query", required = true)
    })
    public Result<Object> getHotSale(String cid,Integer back,Integer minId) {
        String url = "http://v2.api.haodanku.com/itemlist/apikey/quanshiyi/nav/2/cid/"+cid+"/back/"+back+"/min_id/"+minId;
        String resultString = sendGet(url);
        HaoDanKuResponse haoDanKuResponse = null;
        try {
           haoDanKuResponse = JSONObject.parseObject(resultString, HaoDanKuResponse.class);
        }catch (Exception e){
            return responseMsg("网络加载出错,请稍后再试!");
        }

        return response(haoDanKuResponse);
    }


    @GetMapping("/supSpecialTheme")
    @ApiOperation(value = "活动推荐", httpMethod = "GET", produces = "application/json;charset=UTF-8")
    public Result<Object> supSpecialTheme() {
        String url = "http://v2.api.haodanku.com/get_subject/apikey/quanshiyi";
        String s = sendGet(url);

        SpecialThemeResponse specialThemeResponse = null;
        try {
            specialThemeResponse = JSONObject.parseObject(s, SpecialThemeResponse.class);
        } catch (Exception e) {
            return responseMsg("网络加载出错,请稍后再试!");
        }

        if ("1".equals(specialThemeResponse.getCode())) {
            return response(specialThemeResponse);
        } else {
            specialThemeResponse.setData(Collections.emptyList());
            return response(specialThemeResponse);
        }

    }

    @GetMapping("/specialTheme")
    @ApiOperation(value = "活动推荐商品页", httpMethod = "GET", produces = "application/json;charset=UTF-8")
    @ApiImplicitParams(@ApiImplicitParam(name = "id", value = "专题id", paramType = "query", required = true))
    public Result<Object> specialTheme(Integer id) {
        String url = "http://v2.api.haodanku.com/get_subject_item/apikey/quanshiyi/id/" + id;
        String s = sendGet(url);

        HaoDanKuResponse haoDanKuResponse = null;
        try {
            haoDanKuResponse = JSONObject.parseObject(s, HaoDanKuResponse.class);
        } catch (Exception e) {
            return responseMsg("网络加载出错,请稍后再试!");
        }
        response(haoDanKuResponse);
        if ("1".equals(haoDanKuResponse.getCode())) {
            return response(haoDanKuResponse);
        } else {
            haoDanKuResponse.setData(Collections.emptyList());
            return response(haoDanKuResponse);
        }
    }

    private String sendGet(String url) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String resultString = "";
        CloseableHttpResponse response = null;
        try {
            // 创建uri
            URIBuilder builder = new URIBuilder(url);
            URI uri = builder.build();
            // 创建http GET请求
            HttpGet httpGet = new HttpGet(uri);
            // 执行请求
            response = httpclient.execute(httpGet);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                resultString = EntityUtils.toString(response.getEntity(), "UTF-8");

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resultString;
    }

}
