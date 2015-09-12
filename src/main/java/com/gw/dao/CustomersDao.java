package com.gw.dao;

import java.util.List;
import java.util.Map;

import com.gw.model.Customers;
import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;


public interface CustomersDao extends BaseDao< Customers> {

	Customers getbyUserId(Integer id);
}
