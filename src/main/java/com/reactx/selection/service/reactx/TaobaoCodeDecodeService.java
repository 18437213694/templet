package com.reactx.selection.service.reactx;

import com.baomidou.mybatisplus.plugins.Page;
import com.reactx.selection.models.base.Result;
import com.reactx.selection.models.data.request.CreateClickUrlRequest;
import com.reactx.selection.models.data.taobao.query.PageQuery;
import com.reactx.selection.models.data.taobao.response.MapData;

public interface TaobaoCodeDecodeService {

	Result<Page<MapData>> getData(PageQuery query);

	String createClickUrl(CreateClickUrlRequest request);

}
