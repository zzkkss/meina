package com.gw.model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the collect_shops table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="collect_shops"
 */

public abstract class BaseCollectShops  implements Serializable {

	public static String REF = "CollectShops";
	public static String PROP_USERS_ID = "UsersId";
	public static String PROP_SHOPS_ID = "ShopsId";
	public static String PROP_ID = "Id";


	// constructors
	public BaseCollectShops () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCollectShops (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer usersId;
	private java.lang.Integer shopsId;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="Id"
     */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: usersId
	 */
	public java.lang.Integer getUsersId () {
		return usersId;
	}

	/**
	 * Set the value related to the column: usersId
	 * @param usersId the usersId value
	 */
	public void setUsersId (java.lang.Integer usersId) {
		this.usersId = usersId;
	}



	/**
	 * Return the value associated with the column: shopsId
	 */
	public java.lang.Integer getShopsId () {
		return shopsId;
	}

	/**
	 * Set the value related to the column: shopsId
	 * @param shopsId the shopsId value
	 */
	public void setShopsId (java.lang.Integer shopsId) {
		this.shopsId = shopsId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.gw.model.CollectShops)) return false;
		else {
			com.gw.model.CollectShops collectShops = (com.gw.model.CollectShops) obj;
			if (null == this.getId() || null == collectShops.getId()) return false;
			else return (this.getId().equals(collectShops.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}