package com.gw.model;

import com.gw.model.base.BaseWeixinUser;



public class WeixinUser extends BaseWeixinUser {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public WeixinUser () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public WeixinUser (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public WeixinUser (
		java.lang.Integer id,
		java.lang.String openid) {

		super (
			id,
			openid);
	}

/*[CONSTRUCTOR MARKER END]*/


}