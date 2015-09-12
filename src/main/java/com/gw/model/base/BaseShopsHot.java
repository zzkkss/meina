package com.gw.model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the shops_hot table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="shops_hot"
 */

public abstract class BaseShopsHot  implements Serializable {

	public static String REF = "ShopsHot";
	public static String PROP_CITY_CODE = "CityCode";
	public static String PROP_SHOPS_ID = "ShopsId";
	public static String PROP_ID = "Id";
	public static String PROP_HOT_SORT = "HotSort";


	// constructors
	public BaseShopsHot () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseShopsHot (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer shopsId;
	private java.lang.Integer hotSort;
	private java.lang.Integer cityCode;



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
	 * Return the value associated with the column: hotSort
	 */
	public java.lang.Integer getHotSort () {
		return hotSort;
	}

	/**
	 * Set the value related to the column: hotSort
	 * @param hotSort the hotSort value
	 */
	public void setHotSort (java.lang.Integer hotSort) {
		this.hotSort = hotSort;
	}



	/**
	 * Return the value associated with the column: cityCode
	 */
	public java.lang.Integer getCityCode () {
		return cityCode;
	}

	/**
	 * Set the value related to the column: cityCode
	 * @param cityCode the cityCode value
	 */
	public void setCityCode (java.lang.Integer cityCode) {
		this.cityCode = cityCode;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.gw.model.ShopsHot)) return false;
		else {
			com.gw.model.ShopsHot shopsHot = (com.gw.model.ShopsHot) obj;
			if (null == this.getId() || null == shopsHot.getId()) return false;
			else return (this.getId().equals(shopsHot.getId()));
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