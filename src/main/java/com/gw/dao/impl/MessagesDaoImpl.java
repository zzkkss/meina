package com.gw.dao.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.gw.dao.ImagesDao;
import com.gw.dao.MessagesDao;
import com.gw.model.Images;
import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;
import com.gw.model.Messages;

@Repository("messagesDao")
public class MessagesDaoImpl extends BaseDaoImpl<Messages> implements MessagesDao {




}
