package com.gw.services;


import java.util.List;
import java.util.Map;

import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;
import com.gw.model.WeixinArticle;


public interface WeixinArticleSer extends BaseSer<WeixinArticle> {
	List<WeixinArticle> lastArticle(int num);

	public Map<String,Object>  getByJgridType(JqgridPage jqgridPage,String type);
	  public Map<String,Object>  findByPage(Jqpage jqpage,String...strings );

}
