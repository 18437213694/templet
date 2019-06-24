package com.reactx.selection.service.reactx;

import com.reactx.selection.models.base.BaseService;
import com.reactx.selection.models.data.index.ImsSeller;
import com.reactx.selection.models.data.index.SysUserGrade;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface ImsSellerService extends BaseService<ImsSeller> {

	ImsSeller findByWechatid(String wechatid);

	ImsSeller findById(String id);

	SysUserGrade getLevelByUser(Long level);

	/**
	 * 已结算收益
	 * @param userId
	 * @return
	 */
	BigDecimal getalreadySettleIncome(Long userId);

	/**
	 * 待结算收益
	 * @param userId
	 * @return
	 */
	BigDecimal getnoSettleIncome(Long userId);

	/**
	 * 获取付款信息(包括退款)
	 * @param userId
	 * @return
	 */
	Map<String,Object> getPayInforma(Long userId);

	/**
	 * 用户等级对应的分佣比例
	 * @param level
	 * @return
	 */
	Double queryCommRatio(Long level);

	String findNickById(Long id);

	List<String> findIdsByUserBick(String nick);
}
