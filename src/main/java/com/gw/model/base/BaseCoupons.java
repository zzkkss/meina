package com.gw.model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the coupons table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="coupons"
 */

public abstract class BaseCoupons  implements Serializable {

	public static String REF = "Coupons";
	public static String PROP_IMG = "Img";
	public static String PROP_DESCRIPTION = "Description";
	public static String PROP_END_TIME = "EndTime";
	public static String PROP_SHOPS_ID = "ShopsId";
	public static String PROP_START_TIME = "StartTime";
	public static String PROP_ID = "Id";
	public static String PROP_NAME = "Name";


	// constructors
	public BaseCoupons () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCoupons (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String name;
	private java.lang.String description;
	private java.lang.String img;
	private java.lang.Integer shopsId;
	private java.util.Date startTime;
	private java.util.Date endTime;



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
	 * Return the value associated with the column: description
	 */
	public java.lang.String getDescription () {
		return description;
	}

	/**
	 * Set the value related to the column: description
	 * @param description the description value
	 */
	public void setDescription (java.lang.String description) {
		this.description = description;
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
	 * Return the value associated with the column: startTime
	 */
	public java.util.Date getStartTime () {
		return startTime;
	}

	/**
	 * Set the value related to the column: startTime
	 * @param startTime the startTime value
	 */
	public void setStartTime (java.util.Date startTime) {
		this.startTime = startTime;
	}



	/**
	 * Return the value associated with the column: endTime
	 */
	public java.util.Date getEndTime () {
		return endTime;
	}

	/**
	 * Set the value related to the column: endTime
	 * @param endTime the endTime value
	 */
	public void setEndTime (java.util.Date endTime) {
		this.endTime = endTime;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.gw.model.Coupons)) return false;
		else {
			com.gw.model.Coupons coupons = (com.gw.model.Coupons) obj;
			if (null == this.getId() || null == coupons.getId()) return false;
			else return (this.getId().equals(coupons.getId()));
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