package com.reactx.selection.service.reactx.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.reactx.selection.mappers.KeguanShopMapper;
import com.reactx.selection.models.base.BaseServiceImpl;
import com.reactx.selection.models.data.index.ImsSeller;
import com.reactx.selection.models.data.local.KeguanActivity;
import com.reactx.selection.models.data.local.KeguanShop;
import com.reactx.selection.models.data.local.KeguanWxcardinfo;
import com.reactx.selection.service.reactx.ImsSellerService;
import com.reactx.selection.service.reactx.KeguanWxcardinfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class KeguanShopServiceImpl extends BaseServiceImpl<KeguanShopMapper, KeguanShop> implements KeguanShopService {

	@Autowired
	private KeguanWxcardinfoService cardinfoService;
	@Autowired
	private ImsSellerService sellerService;

	@Override
	public Set<String> getAllCity() {
		List<String> result = new ArrayList<>();
		List<String> ids = new ArrayList<>();
		List<Map<String, String>> allCity = baseMapper.getAllCity();
		for(Map<String, String> map:allCity){
			String cityName = map.get("CityName");
			if(StringUtils.isNotBlank(cityName) && cityName.equals("市辖区")){
				ids.add(map.get("id"));
			}else {
				result.add(cityName);
			}
		}
		if(ids.size() >0){
			List<String> citys = baseMapper.getAllCityByProvince(ids);
			result.addAll(citys);
		}
		Set<String> resultSet = new HashSet(result);
		return resultSet;
	}

	@Override
	public List<KeguanShop> findPage(String cityName,String shopName,Integer pageSize,Integer pageNo,String wechatid) {
		List<KeguanShop> list = this.baseMapper.findPage(cityName,shopName,pageSize,pageNo);
		for (KeguanShop shop : list) {
			String userId = null;
			if(StringUtils.isNotBlank(wechatid)){
				ImsSeller seller = sellerService.findByWechatid(wechatid);
				if(seller != null){
					userId = seller.getId().toString();
				}
			}
			List<KeguanWxcardinfo> cards = cardinfoService.findList(userId, shop.getId(), shop.getMerchantId().toString());
			shop.setCards(cards);
			shop.setCardNum(cards.size());
		}
		return list;
	}

	@Override
	public KeguanShop findById(Long shopId) {
		KeguanShop shop = /*selectById(shopId)*/baseMapper.findById(shopId);
		/*List<KeguanActivity> shopActives = activityService.getShopActives(shop.getMerchantId(), shop.getWxID(), 8, shopId + "");
		if (shopActives.size()>0){
			shop.setActivity(shopActives.get(0));
		}*/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(shop.getOpeningTime() == null){
			try {
				String s = "2019-03-12 08:00:00";
				shop.setOpeningTime(sdf.parse(s));
			}catch (Exception e){
				return null;
			}
		}
		if(shop.getClosingTime() == null){
			try {
				String s = "2019-03-12 21:00:00";
				shop.setClosingTime(sdf.parse(s));
			}catch (Exception e){
				return null;
			}
		}
		shop.setActivity(new KeguanActivity());
		shop.getActivity().setIntroduct(shop.getDiscountInfo());
		return shop;
	}

	@Override
	public List<KeguanShop> getHotClassList(Integer status) {
		Wrapper<KeguanShop> wrapper = new EntityWrapper<>();
		if (status==null){

		} else if(status==0){
			wrapper.eq("(status & 1)",0);
		}else {
			wrapper.eq("(status & "+status+")",status);
		}
		return selectList(wrapper);
	}
}
