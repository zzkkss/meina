package com.gw.services.impl;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gw.dao.BaseDao;
import com.gw.dao.TerminalsXingzheDao;
import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;
import com.gw.model.TerminalsXingzhe;
import com.gw.services.TerminalsXingzheSer;
@Service("terminalsXingzheSer")
@Transactional 
public class TerminalsXingzheSerImpl extends BaseSerImpl<TerminalsXingzhe> implements TerminalsXingzheSer{
	  /** 
     * 注入DAO 
     */  
    @Resource(name = "terminalsXingzheDao")  
    public void setDao(BaseDao<TerminalsXingzhe> dao) {  
        super.setDao(dao);  
    }
    @Autowired
private TerminalsXingzheDao terminalsXingzheDao;
	public Map<String, Object> findByPage(Jqpage jqpage, String... strings) {
		// TODO Auto-generated method stub
		return terminalsXingzheDao.getByPage(jqpage, strings);
	}
	public Map<String, Object> getByJgridType(JqgridPage jqgridPage, String type) {
		// TODO Auto-generated method stub
		return terminalsXingzheDao.getByJgridType(jqgridPage, type);
	}
	public List<TerminalsXingzhe> getByTname(String tn) {
		// TODO Auto-generated method stub
		return terminalsXingzheDao.getByTname(tn);
	}
  
}
