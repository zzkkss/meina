package com.gw.services.impl;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gw.dao.BaseDao;
import com.gw.dao.WeixinArticleDao;
import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;
import com.gw.model.WeixinArticle;
import com.gw.services.WeixinArticleSer;
@Service("weixinArticleSer")
@Transactional 
public class WeixinArticleSerImpl extends BaseSerImpl<WeixinArticle> implements WeixinArticleSer{
	  /** 
     * 注入DAO 
     */  
    @Resource(name = "weixinArticleDao")  
    public void setDao(BaseDao<WeixinArticle> dao) {  
        super.setDao(dao);  
    }
    @Autowired
private WeixinArticleDao weixinArticleDao;
	public Map<String, Object> findByPage(Jqpage jqpage, String... strings) {
		// TODO Auto-generated method stub
		return weixinArticleDao.getByPage(jqpage, strings);
	}
	public Map<String, Object> getByJgridType(JqgridPage jqgridPage, String type) {
		// TODO Auto-generated method stub
		return weixinArticleDao.getByJgridType(jqgridPage, type);
	}
	public List<WeixinArticle> lastArticle(int num) {
		// TODO Auto-generated method stub
		return 	weixinArticleDao.lastArticle(num);
		}  
  
}
