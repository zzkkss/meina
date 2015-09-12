package com.gw.model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the main_users_roles table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="main_users_roles"
 */

public abstract class BaseMainUsersRoles  implements Serializable {

	public static String REF = "MainUsersRoles";
	public static String PROP_USERS_ID = "UsersId";
	public static String PROP_ROLES_ID = "RolesId";
	public static String PROP_ID = "Id";


	// constructors
	public BaseMainUsersRoles () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMainUsersRoles (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer usersId;
	private java.lang.Integer rolesId;



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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.gw.model.MainUsersRoles)) return false;
		else {
			com.gw.model.MainUsersRoles mainUsersRoles = (com.gw.model.MainUsersRoles) obj;
			if (null == this.getId() || null == mainUsersRoles.getId()) return false;
			else return (this.getId().equals(mainUsersRoles.getId()));
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