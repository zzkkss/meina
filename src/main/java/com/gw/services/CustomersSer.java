package com.gw.services;

import com.gw.model.Customers;





public interface CustomersSer extends BaseSer<Customers> {

	Customers getByUserId(Integer id);



}
