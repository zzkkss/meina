package com.gw.services;

import java.util.Map;

import com.gw.model.CollectCoupons;
import com.gw.model.CollectShops;
import com.gw.model.Images;
import com.gw.model.Jqpage;




public interface CollectCouponsSer extends BaseSer<CollectCoupons> {

	CollectCoupons findByUserIdAndCouponId(CollectCoupons collectCoupons);

	Map<String, Object> findByJqpageAndUserId(Jqpage jqpage, int id);



}
