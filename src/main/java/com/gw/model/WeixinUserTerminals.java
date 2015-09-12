package com.gw.model;

import com.gw.model.base.BaseWeixinUserTerminals;



public class WeixinUserTerminals extends BaseWeixinUserTerminals {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public WeixinUserTerminals () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public WeixinUserTerminals (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public WeixinUserTerminals (
		java.lang.Integer id,
		java.lang.String nickName) {

		super (
			id,
			nickName);
	}

/*[CONSTRUCTOR MARKER END]*/


}