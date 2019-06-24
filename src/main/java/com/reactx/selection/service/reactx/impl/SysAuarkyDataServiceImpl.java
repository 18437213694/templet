package com.reactx.selection.service.reactx.impl;

import com.reactx.selection.mappers.SysAuarkyDataMapper;
import com.reactx.selection.models.base.BaseServiceImpl;
import com.reactx.selection.models.data.pinduoduo.SysAutarkyData;
import com.reactx.selection.service.reactx.SysAuarkyDataService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SysAuarkyDataServiceImpl extends BaseServiceImpl<SysAuarkyDataMapper, SysAutarkyData>
        implements SysAuarkyDataService {
    @Override
    public List<SysAutarkyData> findPage(Integer pageNo, Integer pageSize, String keyword, String sortType) {
        return baseMapper.findPage(pageNo,pageSize,keyword,sortType);
    }

    @Override
    public Long getCount(Integer pageNo, Integer pageSize, String keyword) {
        return baseMapper.getCount(pageNo,pageSize,keyword);
    }

    //    @Override
//    public void insertOrder(WFXOrder order) {
//        Wrapper<WFXOrder> wrapper = new EntityWrapper<>();
//        wrapper.eq("order_id",order.getOrder_id());
//        WFXOrder order1 = selectOne(wrapper);
//        if (order1!=null) return;
//        insert(order);
//    }
}
