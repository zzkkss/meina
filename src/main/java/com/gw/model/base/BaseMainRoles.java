package com.gw.model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the main_roles table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="main_roles"
 */

public abstract class BaseMainRoles  implements Serializable {

	public static String REF = "MainRoles";
	public static String PROP_DESCRIPTION = "Description";
	public static String PROP_ID = "Id";
	public static String PROP_NAME = "Name";


	// constructors
	public BaseMainRoles () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMainRoles (java.lang.Integer id) {
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.gw.model.MainRoles)) return false;
		else {
			com.gw.model.MainRoles mainRoles = (com.gw.model.MainRoles) obj;
			if (null == this.getId() || null == mainRoles.getId()) return false;
			else return (this.getId().equals(mainRoles.getId()));
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