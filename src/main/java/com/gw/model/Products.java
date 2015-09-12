package com.gw.model;

import com.gw.model.base.BaseProducts;



public class Products extends BaseProducts {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Products () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Products (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Products (
		java.lang.Integer id,
		java.lang.Integer evaluate) {

		super (
			id,
			evaluate);
	}

/*[CONSTRUCTOR MARKER END]*/


}