package com.gw.services.impl;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gw.dao.BaseDao;
import com.gw.dao.WeixinUserTerminalsDao;
import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;
import com.gw.model.Terminals;
import com.gw.model.TerminalsXingzhe;
import com.gw.model.WeixinUserTerminals;
import com.gw.services.WeixinUserTerminalsSer;
@Service("weixinUserTerminalsSer")
@Transactional 
public class WeixinUserTerminalsSerImpl extends BaseSerImpl<WeixinUserTerminals> implements WeixinUserTerminalsSer{
	  /** 
     * 注入DAO 
     */  
    @Resource(name = "weixinUserTerminalsDao")  
    public void setDao(BaseDao<WeixinUserTerminals> dao) {  
        super.setDao(dao);  
    }
    @Autowired
private WeixinUserTerminalsDao hquserTerminalsDao;
	public Map<String, Object> findByPage(Jqpage jqpage, String... strings) {
		// TODO Auto-generated method stub
		return hquserTerminalsDao.getByPage(jqpage, strings);
	}
	public Map<String, Object> getByJgridType(JqgridPage jqgridPage, String type) {
		// TODO Auto-generated method stub
		return hquserTerminalsDao.getByJgridType(jqgridPage, type);
	}
	public List<WeixinUserTerminals> getLastBindByTerminalsTname(Terminals terminals) {
		// TODO Auto-generated method stub
		return hquserTerminalsDao.getLastBindByTerminalsTname(terminals);
	}
	public List<WeixinUserTerminals> getLastBindByTerminalsTname(TerminalsXingzhe terminalsXingzhe) {
		// TODO Auto-generated method stub
		return hquserTerminalsDao.getLastBindByTerminalsTname(terminalsXingzhe);
	}
	public List<WeixinUserTerminals> findByOpenId(String openid) {
		// TODO Auto-generated method stub
		return hquserTerminalsDao.findByOpenId(openid);
	}
	public WeixinUserTerminals findByOpenIdAndTname(String openid, String tname) {
		// TODO Auto-generated method stub
		return hquserTerminalsDao.findByOpenIdAndTname(openid,tname);
	}
  
}
