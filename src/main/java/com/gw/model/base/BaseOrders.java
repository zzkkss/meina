package com.gw.model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the orders table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="orders"
 */

public abstract class BaseOrders  implements Serializable {

	public static String REF = "Orders";
	public static String PROP_ORDER_TIME = "OrderTime";
	public static String PROP_USERS_ID = "UsersId";
	public static String PROP_STATE = "State";
	public static String PROP_PHONE = "Phone";
	public static String PROP_SHOPS_ID = "ShopsId";
	public static String PROP_MARK = "Mark";
	public static String PROP_PRODUCT_ID = "ProductId";
	public static String PROP_BUILD_TIME = "BuildTime";
	public static String PROP_ID = "Id";


	// constructors
	public BaseOrders () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOrders (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date buildTime;
	private java.lang.String mark;
	private java.util.Date orderTime;
	private java.lang.String phone;
	private java.lang.Integer productId;
	private java.lang.Integer shopsId;
	private java.lang.Integer state;
	private java.lang.Integer usersId;



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
	 * Return the value associated with the column: buildTime
	 */
	public java.util.Date getBuildTime () {
		return buildTime;
	}

	/**
	 * Set the value related to the column: buildTime
	 * @param buildTime the buildTime value
	 */
	public void setBuildTime (java.util.Date buildTime) {
		this.buildTime = buildTime;
	}



	/**
	 * Return the value associated with the column: mark
	 */
	public java.lang.String getMark () {
		return mark;
	}

	/**
	 * Set the value related to the column: mark
	 * @param mark the mark value
	 */
	public void setMark (java.lang.String mark) {
		this.mark = mark;
	}



	/**
	 * Return the value associated with the column: orderTime
	 */
	public java.util.Date getOrderTime () {
		return orderTime;
	}

	/**
	 * Set the value related to the column: orderTime
	 * @param orderTime the orderTime value
	 */
	public void setOrderTime (java.util.Date orderTime) {
		this.orderTime = orderTime;
	}



	/**
	 * Return the value associated with the column: phone
	 */
	public java.lang.String getPhone () {
		return phone;
	}

	/**
	 * Set the value related to the column: phone
	 * @param phone the phone value
	 */
	public void setPhone (java.lang.String phone) {
		this.phone = phone;
	}



	/**
	 * Return the value associated with the column: productId
	 */
	public java.lang.Integer getProductId () {
		return productId;
	}

	/**
	 * Set the value related to the column: productId
	 * @param productId the productId value
	 */
	public void setProductId (java.lang.Integer productId) {
		this.productId = productId;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.gw.model.Orders)) return false;
		else {
			com.gw.model.Orders orders = (com.gw.model.Orders) obj;
			if (null == this.getId() || null == orders.getId()) return false;
			else return (this.getId().equals(orders.getId()));
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