package com.gw.model;

import com.gw.model.base.BaseBbsUser;



public class BbsUser extends BaseBbsUser {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public BbsUser () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public BbsUser (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public BbsUser (
		java.lang.Integer id,
		java.lang.String username,
		java.lang.String password,
		boolean sex) {

		super (
			id,
			username,
			password,
			sex);
	}

/*[CONSTRUCTOR MARKER END]*/


}