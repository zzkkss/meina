package com.gw.dao;

import java.util.List;
import java.util.Map;

import com.gw.model.WeixinUser;
import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;


public interface WeixinUserDao extends BaseDao<WeixinUser> {
List<WeixinUser> lastUser(int num);
Map<String,Object>  getByPage(Jqpage jqpage,String...strings );
Map<String,Object>  getByJgridType(JqgridPage jqgridPage,String type);
List<WeixinUser> getByUnionid(String unionid);
}
