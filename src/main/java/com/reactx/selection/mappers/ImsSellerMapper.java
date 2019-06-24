package com.reactx.selection.mappers;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.reactx.selection.models.data.index.ImsSeller;
import com.reactx.selection.models.data.index.SysUserGrade;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.util.List;

public interface ImsSellerMapper extends BaseMapper<ImsSeller> {

	@Select("SELECT id,parentid,sellerlevel,create_time createTime FROM ims_seller WHERE wechatid = #{wechatid}")
	List<ImsSeller> findByWechatid(@Param("wechatid") String wechatid);

	@Select("SELECT id,parentid,sellerlevel,create_time createTime FROM ims_seller WHERE id = #{id}")
	ImsSeller findById(@Param("id") String id);

	@Select("SELECT merchname FROM ims_seller WHERE id = #{id}")
	String findNickById(@Param("id") Long id);

	@Select("SELECT * FROM sys_user_grade WHERE id = #{level}")
	SysUserGrade getLevelByUser(@Param("level") Long level);

	@Select("SELECT SUM(credit2) AS TotalMoney FROM ims_detailexpense v LEFT JOIN ims_taobao_order o ON v.logno = o.ordersn LEFT JOIN ims_taobao_purchase_order o1 ON v.logno = o1.ordersn LEFT JOIN keguan_orders o2 ON v.logno = o2.ordernum WHERE v.sellerid = #{userId} AND ((v.type IN (1,2,3,4,5) AND o.orderstatus != 0 AND o.issettle = 3) OR (v.type = 6 AND o1.orderstatus != 0 AND o1.issettle = 3) OR (v.type in (10,11,12) AND o2.status=1))") // OR (v.type = 7)
	BigDecimal getalreadySettleIncome(@Param("userId") Long userId);

	@Select("SELECT SUM(credit2) AS TotalMoney FROM ims_detailestimate v LEFT JOIN ims_taobao_order o ON v.logno = o.ordersn LEFT JOIN ims_taobao_purchase_order o1 ON v.logno = o1.ordersn WHERE v.sellerid = #{userId} AND ((v.type IN (1,2,3,4,5) AND o.orderstatus != 0 AND o.issettle != 3) OR (v.type = 6 AND o1.orderstatus != 0 AND o1.issettle != 3))")
	BigDecimal getnoSettleIncome(@Param("userId") Long userId);

	@Select("SELECT sum(price) FROM ims_taobao_order WHERE sellerid= #{userId}")
	BigDecimal getPayMoney(@Param("userId") Long userId); //付款金额

	@Select("SELECT count(1) FROM ims_taobao_order WHERE sellerid= #{userId}")
	BigDecimal getPayNum(@Param("userId") Long userId);//付款比数

	@Select("SELECT sum(price) FROM ims_taobao_order WHERE sellerid= #{userId} AND orderstatus = 0")
	BigDecimal getRefundMoney(@Param("userId") Long userId); //退款金额

	@Select("SELECT count(1) FROM ims_taobao_order WHERE sellerid= #{userId} AND orderstatus = 0")
	BigDecimal getRefundNum(@Param("userId") Long userId); //退款金额

	@Select("SELECT SetValueA from ims_settingearnings where SetName=#{id} AND setType = '流量分佣比例设置'")
	@ResultType(BigDecimal.class)
	BigDecimal queryCommRatio(String name);

	@Select("select id FROM ims_seller where merchname like #{nick}")
	List<String> findIdsByUserBick(@Param("nick") String nick);
}
