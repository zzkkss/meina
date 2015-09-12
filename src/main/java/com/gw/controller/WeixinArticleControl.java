package com.gw.controller;

import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.record.formula.functions.Logest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gw.model.Jqpage;
import com.gw.model.WeixinArticle;
import com.gw.services.WeixinUserSer;
import com.gw.services.WeixinArticleSer;

@Controller
public class WeixinArticleControl {
@Autowired
private WeixinArticleSer weixinArticleSer;
private Logger logger=LoggerFactory.getLogger(WeixinArticleControl.class);
	  
	  @RequestMapping ("lastArticles") 
	  @ResponseBody
	public List<WeixinArticle> lastArticles() {
		// TODO Auto-generated method stub
		  
		return weixinArticleSer.lastArticle(1);
	}  
	  
}
