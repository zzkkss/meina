package com.gw.model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the main_users table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="main_users"
 */

public abstract class BaseMainUsers  implements Serializable {

	public static String REF = "MainUsers";
	public static String PROP_USERNAME = "Username";
	public static String PROP_ENABLED = "Enabled";
	public static String PROP_ID = "Id";
	public static String PROP_WEIXIN_USER_ID = "WeixinUserId";
	public static String PROP_PASSWORD = "Password";


	// constructors
	public BaseMainUsers () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMainUsers (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseMainUsers (
		java.lang.Integer id,
		java.lang.String username) {

		this.setId(id);
		this.setUsername(username);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String username;
	private java.lang.String password;
	private boolean enabled;
	private java.lang.Integer weixinUserId;



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
	 * Return the value associated with the column: username
	 */
	public java.lang.String getUsername () {
		return username;
	}

	/**
	 * Set the value related to the column: username
	 * @param username the username value
	 */
	public void setUsername (java.lang.String username) {
		this.username = username;
	}



	/**
	 * Return the value associated with the column: password
	 */
	public java.lang.String getPassword () {
		return password;
	}

	/**
	 * Set the value related to the column: password
	 * @param password the password value
	 */
	public void setPassword (java.lang.String password) {
		this.password = password;
	}



	/**
	 * Return the value associated with the column: enabled
	 */
	public boolean isEnabled () {
		return enabled;
	}

	/**
	 * Set the value related to the column: enabled
	 * @param enabled the enabled value
	 */
	public void setEnabled (boolean enabled) {
		this.enabled = enabled;
	}



	/**
	 * Return the value associated with the column: weixinUserId
	 */
	public java.lang.Integer getWeixinUserId () {
		return weixinUserId;
	}

	/**
	 * Set the value related to the column: weixinUserId
	 * @param weixinUserId the weixinUserId value
	 */
	public void setWeixinUserId (java.lang.Integer weixinUserId) {
		this.weixinUserId = weixinUserId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.gw.model.MainUsers)) return false;
		else {
			com.gw.model.MainUsers mainUsers = (com.gw.model.MainUsers) obj;
			if (null == this.getId() || null == mainUsers.getId()) return false;
			else return (this.getId().equals(mainUsers.getId()));
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