package com.gw.model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the collect_coupons table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="collect_coupons"
 */

public abstract class BaseCollectCoupons  implements Serializable {

	public static String REF = "CollectCoupons";
	public static String PROP_USERS_ID = "UsersId";
	public static String PROP_STATE = "State";
	public static String PROP_COUPONS_ID = "CouponsId";
	public static String PROP_ID = "Id";


	// constructors
	public BaseCollectCoupons () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCollectCoupons (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer usersId;
	private java.lang.Integer couponsId;
	private java.lang.Integer state;



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
	 * Return the value associated with the column: couponsId
	 */
	public java.lang.Integer getCouponsId () {
		return couponsId;
	}

	/**
	 * Set the value related to the column: couponsId
	 * @param couponsId the couponsId value
	 */
	public void setCouponsId (java.lang.Integer couponsId) {
		this.couponsId = couponsId;
	}



	/**
	 * Return the value associated with the column: state
	 */
	public java.lang.Integer getState () {
		return state;
	}

	/**
	 * Set the value related to the column: state
	 * @param state the state value
	 */
	public void setState (java.lang.Integer state) {
		this.state = state;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.gw.model.CollectCoupons)) return false;
		else {
			com.gw.model.CollectCoupons collectCoupons = (com.gw.model.CollectCoupons) obj;
			if (null == this.getId() || null == collectCoupons.getId()) return false;
			else return (this.getId().equals(collectCoupons.getId()));
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