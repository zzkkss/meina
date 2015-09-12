package com.gw.model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the main_roles_authorities table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="main_roles_authorities"
 */

public abstract class BaseMainRolesAuthorities  implements Serializable {

	public static String REF = "MainRolesAuthorities";
	public static String PROP_ROLES_ID = "RolesId";
	public static String PROP_AUTHORITIES_ID = "AuthoritiesId";
	public static String PROP_ID = "Id";


	// constructors
	public BaseMainRolesAuthorities () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMainRolesAuthorities (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer rolesId;
	private java.lang.Integer authoritiesId;



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
	 * Return the value associated with the column: rolesId
	 */
	public java.lang.Integer getRolesId () {
		return rolesId;
	}

	/**
	 * Set the value related to the column: rolesId
	 * @param rolesId the rolesId value
	 */
	public void setRolesId (java.lang.Integer rolesId) {
		this.rolesId = rolesId;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.gw.model.MainRolesAuthorities)) return false;
		else {
			com.gw.model.MainRolesAuthorities mainRolesAuthorities = (com.gw.model.MainRolesAuthorities) obj;
			if (null == this.getId() || null == mainRolesAuthorities.getId()) return false;
			else return (this.getId().equals(mainRolesAuthorities.getId()));
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