package com.reactx.selection.web.controller.reactx;

import com.alibaba.fastjson.JSON;
import com.reactx.selection.models.base.BaseController;
import com.reactx.selection.models.base.Result;
import com.reactx.selection.models.base.util.IntegerUtil;
import com.reactx.selection.models.data.pinduoduo.query.PddGoodsQuery;
import com.reactx.selection.models.data.pinduoduo.response.Goods;
import com.reactx.selection.service.reactx.KeywordService;
import com.reactx.selection.service.reactx.PddService;
import com.reactx.selection.service.reactx.SysAuarkyDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/pdd")
@Api(value = "goods", description = "拼多多商品")
public class PddGoodsController extends BaseController {

	@Autowired
	private KeywordService keywordService;
	@Autowired
	private PddService pddService;
	@Autowired
	private SysAuarkyDataService sysAuarkyDataService;

	@GetMapping("/findPage")
	@ApiOperation(value = "分页搜索", httpMethod = "GET", produces = "application/json;charset=UTF-8", response = Goods.class)
	@ApiImplicitParams({@ApiImplicitParam(name = "pageNo", value = "当前页", paramType = "query", required = false),
			@ApiImplicitParam(name = "pageSize", value = "分页大小", paramType = "query", required = false),
			@ApiImplicitParam(name = "goodsId", value = "商品id（传入此参数，关键字、类目id等失效）", paramType = "query", required = false),
			@ApiImplicitParam(name = "keyword", value = "关键字", paramType = "query", required = false),
			@ApiImplicitParam(name = "sortType", value = "排序方式:0-综合排序;1-按佣金比率升序;2-按佣金比例降序;3-按价格升序;4-按价格降序;5-按销量升序;6-按销量降序;7-优惠券金额排序升序;8-优惠券金额排序降序;9-券后价升序排序;10-券后价降序排序;11-按照加入多多进宝时间升序;12-按照加入多多进宝时间降序;13-按佣金金额升序排序;14-按佣金金额降序排序;15-店铺描述评分升序;16-店铺描述评分降序;17-店铺物流评分升序;18-店铺物流评分降序;19-店铺服务评分升序;20-店铺服务评分降序;27-描述评分击败同类店铺百分比升序，28-描述评分击败同类店铺百分比降序，29-物流评分击败同类店铺百分比升序，30-物流评分击败同类店铺百分比降序，31-服务评分击败同类店铺百分比升序，32-服务评分击败同类店铺百分比降序", paramType = "query", required = false),
			@ApiImplicitParam(name = "catId", value = "类目id", paramType = "query", required = false),
			@ApiImplicitParam(name = "merchantType", value = "店铺类型", paramType = "query", required = false)})
	public Result<Object> findPage(PddGoodsQuery query) {
		if (StringUtils.isNotBlank(query.getKeyword()))
			keywordService.augment(query.getKeyword().trim());
		Integer pageSize = query.getPageSize();
		if(IntegerUtil.isNotBlank(pageSize) && (pageSize < 10 || pageSize >100)){
			return responseMsg("201","每页的分页范围在10-100条");
		}
		return response(pddService.findPage(query));
	}


	@GetMapping("/findPageByAuarky")
	@ApiOperation(value = "分页搜索自营商品", httpMethod = "GET", produces = "application/json;charset=UTF-8", response = Goods.class)
	@ApiImplicitParams({@ApiImplicitParam(name = "pageNo", value = "当前页", paramType = "query", required = false),
			@ApiImplicitParam(name = "pageSize", value = "分页大小", paramType = "query", required = false),
			@ApiImplicitParam(name = "keyword", value = "关键字", paramType = "query", required = false),
			@ApiImplicitParam(name = "sortType", value = "排序方式:0-综合排序;1-销量升序;2-销量降序;3-按价格升序;4-按价格降序", paramType = "query", required = true)})
	public Result<Object> findPageByAuarky(Integer pageNo,Integer pageSize,String keyword,String sortType) {
		Map<String,Object> map = new HashMap<>();
		map.put("total",sysAuarkyDataService.getCount(pageNo, pageSize,keyword));
		map.put("goods",sysAuarkyDataService.findPage(pageNo,pageSize,keyword,sortType));
		return response(map);
	}
//	@GetMapping("/getGoodsDetails")
//	@ApiOperation(value = "获得商品详情", httpMethod = "GET", produces = "application/json;charset=UTF-8", response = GoodsDetails.class)
//	@ApiImplicitParams(@ApiImplicitParam(name = "id", value = "商品id", paramType = "query", required = false))
//	public String getGoodsDetails(Long id) {
//		if (LongUtil.isBlank(id))
//			return JSON.toJSONString(responseMsg("id不能为空"));
//		return pddService.getGoodsDetails(id);
//	}

}