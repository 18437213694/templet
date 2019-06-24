package com.reactx.selection.service.reactx.impl;

import com.reactx.selection.mappers.KeguanWxcardinfoMapper;
import com.reactx.selection.models.base.BaseServiceImpl;
import com.reactx.selection.models.base.util.DateUtil;
import com.reactx.selection.models.base.util.LongUtil;
import com.reactx.selection.models.data.local.KeguanShop;
import com.reactx.selection.models.data.local.KeguanWxcardinfo;
import com.reactx.selection.models.data.local.KeguanWxusercard;
import com.reactx.selection.service.reactx.KeguanShopService;
import com.reactx.selection.service.reactx.KeguanWxcardinfoService;
import com.reactx.selection.service.reactx.KeguanWxusercardService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class KeguanWxcardinfoServiceImpl extends BaseServiceImpl<KeguanWxcardinfoMapper, KeguanWxcardinfo>
        implements KeguanWxcardinfoService {

//    @Autowired
//    private ViewUserCardService userCardService;
//
    @Autowired
    private KeguanShopService shopService;
//    @Autowired
//    private KeguanMerchantWeixinService merchantWeixinService;
//    @Autowired
//    private KeguanDistrictService districtService;
    @Autowired
    private KeguanWxusercardService keguanWxusercardService;
//
//    @Autowired
//    private KeguanSubmerchantService keguanSubmerchantService;

    @Override
    public List<KeguanWxcardinfo> findList(String sellerId,Long shopId,String merchantid) {
        Date date = new Date();
        String s = DateUtil.format(date,"yyyy-MM-dd");
        List<KeguanWxcardinfo> list = this.baseMapper.findPage(shopId,merchantid);
        for (KeguanWxcardinfo wxcardinfo : list) {
            KeguanWxusercard card = null;
            KeguanShop shop = null;
            String shopName = null;
            if (StringUtils.isNotBlank(sellerId)) {
                List<KeguanWxusercard> cardList = keguanWxusercardService.findBySellerIdAndCardId(sellerId, wxcardinfo.getCardId());
                if (cardList.size() > 0) {
                    card = cardList.get(0);
                }
            }
            if (LongUtil.isNotBlank(shopId)) {
                KeguanShop keguanShop = shopService.findById(shopId);
                 shopName = keguanShop.getShopName();
                wxcardinfo.setShopName(shopName);
            }

            wxcardinfo.setWxUserCard(card);
        }

        return list;
    }

}
