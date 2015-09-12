package com.gw.services;

import net.sf.json.JSONObject;

import com.gw.model.BbsUser;
import com.gw.model.Images;




public interface BbsUserSer extends BaseSer<BbsUser> {


	BbsUser findByUserId(int id);



}
