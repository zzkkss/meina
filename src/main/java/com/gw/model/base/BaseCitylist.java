package com.gw.model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the citylist table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="citylist"
 */

public abstract class BaseCitylist  implements Serializable {

	public static String REF = "Citylist";
	public static String PROP_PARENT_ID = "ParentId";
	public static String PROP_CITY_CODE = "CityCode";
	public static String PROP_SORT = "Sort";
	public static String PROP_ID = "Id";
	public static String PROP_NAME = "Name";


	// constructors
	public BaseCitylist () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCitylist (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer parentId;
	private java.lang.String name;
	private java.lang.Integer sort;
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
	 * Return the value associated with the column: parentId
	 */
	public java.lang.Integer getParentId () {
		return parentId;
	}

	/**
	 * Set the value related to the column: parentId
	 * @param parentId the parentId value
	 */
	public void setParentId (java.lang.Integer parentId) {
		this.parentId = parentId;
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
	 * Return the value associated with the column: sort
	 */
	public java.lang.Integer getSort () {
		return sort;
	}

	/**
	 * Set the value related to the column: sort
	 * @param sort the sort value
	 */
	public void setSort (java.lang.Integer sort) {
		this.sort = sort;
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
		if (!(obj instanceof com.gw.model.Citylist)) return false;
		else {
			com.gw.model.Citylist citylist = (com.gw.model.Citylist) obj;
			if (null == this.getId() || null == citylist.getId()) return false;
			else return (this.getId().equals(citylist.getId()));
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