package com.reactx.selection.mappers;

import com.reactx.selection.models.base.BaseMapper;
import com.reactx.selection.models.data.local.KeguanWxusercard;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface KeguanWxusercardMapper extends BaseMapper<KeguanWxusercard> {

	@Select("SELECT * FROM keguan_wxusercard WHERE CardId = #{cardId} AND outerId = #{sellerId} AND Status = 'CONSUMED'")
	List<KeguanWxusercard> findBySellerIdAndCardId(@Param("sellerId") String sellerId, @Param("cardId") String cardId);
}
