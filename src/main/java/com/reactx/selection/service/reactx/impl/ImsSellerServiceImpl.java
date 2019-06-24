package com.reactx.selection.service.reactx.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.reactx.selection.mappers.ImsSellerMapper;
import com.reactx.selection.models.base.BaseServiceImpl;
import com.reactx.selection.models.data.index.ImsSeller;
import com.reactx.selection.models.data.index.SysUserGrade;
import com.reactx.selection.service.reactx.ImsSellerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ImsSellerServiceImpl extends BaseServiceImpl<ImsSellerMapper, ImsSeller> implements ImsSellerService {


	public static final Logger logger = LoggerFactory.getLogger(ImsSellerServiceImpl.class);


	@Override
	public ImsSeller findByWechatid(String wechatid) {
		List<ImsSeller> seller =  baseMapper.findByWechatid(wechatid);
		return seller.size()==0?null:seller.get(0);
	}

	@Override
	public ImsSeller findById(String id) {
		return baseMapper.findById(id);
	}

	@Override
	public SysUserGrade getLevelByUser(Long level) {
		return baseMapper.getLevelByUser(level);
	}

	@Override
	public BigDecimal getalreadySettleIncome(Long userId) {
		return baseMapper.getalreadySettleIncome(userId);
	}

	@Override
	public BigDecimal getnoSettleIncome(Long userId) {
		return baseMapper.getnoSettleIncome(userId);
	}

	@Override
	public Map<String, Object> getPayInforma(Long userId) {
		Map<String,Object> map = new HashMap<>();
		map.put("payNum",baseMapper.getPayNum(userId)==null?BigDecimal.ZERO:baseMapper.getPayNum(userId));
		map.put("payMoney",baseMapper.getPayMoney(userId)==null?BigDecimal.ZERO:baseMapper.getPayMoney(userId));
		map.put("refundMoney",baseMapper.getRefundMoney(userId)==null?BigDecimal.ZERO:baseMapper.getRefundMoney(userId));
		map.put("refundNum",baseMapper.getRefundNum(userId)==null?BigDecimal.ZERO:baseMapper.getRefundNum(userId));
		return map;
	}

	@Override
	public String findNickById(Long id) {
		return baseMapper.findNickById(id);
	}

	@Override
	public Double queryCommRatio(Long level) {
		try {
			Map<Long, String> map = getMap();
			BigDecimal bigDecimal = baseMapper.queryCommRatio(map.get(level));
			BigDecimal b1 = new BigDecimal(0.0089); // 0.89/100
			return bigDecimal.multiply(b1).doubleValue();
		}catch (Exception e){
			logger.error("获取用户等级比例出错:"+e.getMessage());
		}
		return 0.0;
	}

	@Override
	public List<String> findIdsByUserBick(String nick) {
		return baseMapper.findIdsByUserBick("%"+nick+"%");
	}

	private Map<Long,String> getMap(){
		Map<Long,String> map = new HashMap<>();
		map.put(1L,"VIP");
		map.put(2L,"SVIP");
		map.put(3L,"店主");
		map.put(4L,"代理商");
		map.put(5L,"合伙人");
		map.put(6L,"市代");
		map.put(7L,"省代");
		map.put(8L,"省代");
		return map;
	}
}
