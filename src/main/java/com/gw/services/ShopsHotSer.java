package com.gw.services;

import java.util.List;

import com.gw.model.Images;
import com.gw.model.ShopsHot;




public interface ShopsHotSer extends BaseSer<ShopsHot> {

	List<ShopsHot> getByCityCode(int cityCode);

	ShopsHot getByShopsId(int id);




}
