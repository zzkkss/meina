package com.gw.dao;

import java.util.List;
import java.util.Map;

import com.gw.model.BbsUser;
import com.gw.model.Images;
import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;


public interface BbsUserDao extends BaseDao< BbsUser> {

	BbsUser findByUserId(int id);
}
