package com.reactx.selection.web.controller.reactx;

import com.reactx.selection.models.base.BaseController;
import com.reactx.selection.models.base.Result;
import com.reactx.selection.models.data.jingdong.GoodsClassType;
import com.reactx.selection.models.data.jingdong.SysIndexClassify;
import com.reactx.selection.models.data.jingdong.query.JdGoodsQuery;
import com.reactx.selection.models.data.jingdong.response.JdGoods;
import com.reactx.selection.service.reactx.JdService;
import com.reactx.selection.service.reactx.SysIndexClassifyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jdGoods")
@Api(value = "jdGoods", description = "京东商品")
public class JdGoodsController extends BaseController {

	@Autowired
	private JdService jdService;
	@Autowired
	private SysIndexClassifyService classService;
	

	@GetMapping("/getPage")
	@ApiOperation(value = "获取分页-https://jos.jd.com/api/detail.htm?apiName=jingdong.union.search.queryCouponGoods&id=2593", httpMethod = "GET", produces = "application/json;charset=UTF-8", response = JdGoods.class)
	@ApiImplicitParams({@ApiImplicitParam(name = "pageNo", value = "当前页", paramType = "query", required = false),
			@ApiImplicitParam(name = "pageSize", value = "分页大小", paramType = "query", required = false),
			@ApiImplicitParam(name = "keyword", value = "商品关键词", paramType = "query", required = false),
			@ApiImplicitParam(name = "pricefrom", value = "商品价格下限", paramType = "query", required = false),
			@ApiImplicitParam(name = "priceto", value = "商品价格上限", paramType = "query", required = false),
			@ApiImplicitParam(name = "cid3", value = "三级类目id", paramType = "query", required = false) })
	public Result<Object> getPage(JdGoodsQuery query) {
		List<SysIndexClassify> sysIndexClassifyList = classService.findAll(GoodsClassType.JING_DONG.name());
		sysIndexClassifyList.forEach(x -> {
			if(x.getName().equals(query.getKeyword())){
				query.setKeyword(x.getValue());
			}
		});
		if ("精选".equals(query.getKeyword())){
			query.setKeyword("0");
		}
		return response(jdService.findPage(query));
	}

}
