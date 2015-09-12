package com.gw.services;

import java.util.Map;

import com.gw.model.CollectShops;
import com.gw.model.Images;
import com.gw.model.Jqpage;




public interface CollectShopsSer extends BaseSer<CollectShops> {

	CollectShops findByUserIdAndShopsId(CollectShops collectShops);

	Map<String, Object> findByJqpageAndUserId(Jqpage jqpage, int id);



}
