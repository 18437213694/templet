package com.reactx.selection.mappers;

import com.reactx.selection.models.base.BaseMapper;
import com.reactx.selection.models.data.local.KeguanWxcardinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface KeguanWxcardinfoMapper extends BaseMapper<KeguanWxcardinfo> {

    List<KeguanWxcardinfo> findPage(@Param("shopId") Long shopId,@Param("merchantid") String merchantid);
}
