package com.gw.model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the admin_info table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="admin_info"
 */

public abstract class BaseAdminInfo  implements Serializable {

	public static String REF = "AdminInfo";
	public static String PROP_IMG = "Img";
	public static String PROP_PHONE = "Phone";
	public static String PROP_ID = "Id";
	public static String PROP_NAME = "Name";


	// constructors
	public BaseAdminInfo () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAdminInfo (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String name;
	private java.lang.String phone;
	private java.lang.String img;



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
	 * Return the value associated with the column: name
	 */
	public java.lang.String getName () {
		return name;
	}

	/**
	 * Set the value related to the column: name
	 * @param name the name value
	 */
	public void setName (java.lang.String name) {
		this.name = name;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.gw.model.AdminInfo)) return false;
		else {
			com.gw.model.AdminInfo adminInfo = (com.gw.model.AdminInfo) obj;
			if (null == this.getId() || null == adminInfo.getId()) return false;
			else return (this.getId().equals(adminInfo.getId()));
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