package com.gw.model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the main_authorities_resources table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="main_authorities_resources"
 */

public abstract class BaseMainAuthoritiesResources  implements Serializable {

	public static String REF = "MainAuthoritiesResources";
	public static String PROP_AUTHORITIES_ID = "AuthoritiesId";
	public static String PROP_ID = "Id";
	public static String PROP_RESOURCES_ID = "ResourcesId";


	// constructors
	public BaseMainAuthoritiesResources () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMainAuthoritiesResources (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer authoritiesId;
	private java.lang.Integer resourcesId;



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
	 * Return the value associated with the column: authoritiesId
	 */
	public java.lang.Integer getAuthoritiesId () {
		return authoritiesId;
	}

	/**
	 * Set the value related to the column: authoritiesId
	 * @param authoritiesId the authoritiesId value
	 */
	public void setAuthoritiesId (java.lang.Integer authoritiesId) {
		this.authoritiesId = authoritiesId;
	}



	/**
	 * Return the value associated with the column: resourcesId
	 */
	public java.lang.Integer getResourcesId () {
		return resourcesId;
	}

	/**
	 * Set the value related to the column: resourcesId
	 * @param resourcesId the resourcesId value
	 */
	public void setResourcesId (java.lang.Integer resourcesId) {
		this.resourcesId = resourcesId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.gw.model.MainAuthoritiesResources)) return false;
		else {
			com.gw.model.MainAuthoritiesResources mainAuthoritiesResources = (com.gw.model.MainAuthoritiesResources) obj;
			if (null == this.getId() || null == mainAuthoritiesResources.getId()) return false;
			else return (this.getId().equals(mainAuthoritiesResources.getId()));
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