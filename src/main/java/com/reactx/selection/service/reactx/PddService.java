package com.reactx.selection.service.reactx;

import com.baomidou.mybatisplus.plugins.Page;
import com.reactx.selection.models.data.pinduoduo.query.PddGoodsQuery;
import com.reactx.selection.models.data.pinduoduo.response.Goods;

public interface PddService {

	Page<Goods> findPage(PddGoodsQuery query);

}
