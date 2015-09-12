package com.gw.services.impl;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gw.dao.BaseDao;
import com.gw.dao.TerminalsDao;
import com.gw.model.Terminals;
import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;
import com.gw.services.TerminalsSer;
@Service("terminalsSer")
@Transactional 
public class TerminalsSerImpl extends BaseSerImpl<Terminals> implements TerminalsSer{
	  /** 
     * 注入DAO 
     */  
    @Resource(name = "terminalsDao")  
    public void setDao(BaseDao<Terminals> dao) {  
        super.setDao(dao);  
    }
    @Autowired
private TerminalsDao terminalsDao;
	public Map<String, Object> findByPage(Jqpage jqpage, String... strings) {
		// TODO Auto-generated method stub
		return terminalsDao.getByPage(jqpage, strings);
	}
	public Map<String, Object> getByJgridType(JqgridPage jqgridPage, String type) {
		// TODO Auto-generated method stub
		return terminalsDao.getByJgridType(jqgridPage, type);
	}
	public List<Terminals> getByTname(String tn) {
		// TODO Auto-generated method stub
		return terminalsDao.getByTname(tn);
	}
  
}
