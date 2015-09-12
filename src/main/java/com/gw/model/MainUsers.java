package com.gw.model;

import com.gw.model.base.BaseMainUsers;



public class MainUsers extends BaseMainUsers {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public MainUsers () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public MainUsers (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public MainUsers (
		java.lang.Integer id,
		java.lang.String username) {

		super (
			id,
			username);
	}

/*[CONSTRUCTOR MARKER END]*/


}