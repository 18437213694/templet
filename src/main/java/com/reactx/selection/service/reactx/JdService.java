package com.reactx.selection.service.reactx;

import com.baomidou.mybatisplus.plugins.Page;
import com.reactx.selection.models.data.jingdong.query.JdGoodsQuery;
import com.reactx.selection.models.data.jingdong.response.JdGoods;

public interface JdService {

	Page<JdGoods> findPage(JdGoodsQuery query);

}
