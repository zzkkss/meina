package com.gw.model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the customers table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="customers"
 */

public abstract class BaseCustomers  implements Serializable {

	public static String REF = "Customers";
	public static String PROP_IMG = "Img";
	public static String PROP_EMAIL = "Email";
	public static String PROP_USERNAME = "Username";
	public static String PROP_PHONE = "Phone";
	public static String PROP_USER_ID = "UserId";
	public static String PROP_ID = "Id";


	// constructors
	public BaseCustomers () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCustomers (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String username;
	private java.lang.String email;
	private java.lang.String phone;
	private java.lang.String img;
	private java.lang.Integer userId;



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
	 * Return the value associated with the column: email
	 */
	public java.lang.String getEmail () {
		return email;
	}

	/**
	 * Set the value related to the column: email
	 * @param email the email value
	 */
	public void setEmail (java.lang.String email) {
		this.email = email;
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
	 * Return the value associated with the column: img
	 */
	public java.lang.String getImg () {
		return img;
	}

	/**
	 * Set the value related to the column: img
	 * @param img the img value
	 */
	public void setImg (java.lang.String img) {
		this.img = img;
	}



	/**
	 * Return the value associated with the column: userId
	 */
	public java.lang.Integer getUserId () {
		return userId;
	}

	/**
	 * Set the value related to the column: userId
	 * @param userId the userId value
	 */
	public void setUserId (java.lang.Integer userId) {
		this.userId = userId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.gw.model.Customers)) return false;
		else {
			com.gw.model.Customers customers = (com.gw.model.Customers) obj;
			if (null == this.getId() || null == customers.getId()) return false;
			else return (this.getId().equals(customers.getId()));
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