package com.gw.model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the bbs_user table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="bbs_user"
 */

public abstract class BaseBbsUser  implements Serializable {

	public static String REF = "BbsUser";
	public static String PROP_EMAIL = "Email";
	public static String PROP_FEELING = "Feeling";
	public static String PROP_USERNAME = "Username";
	public static String PROP_SEX = "Sex";
	public static String PROP_REGIST_DATE = "RegistDate";
	public static String PROP_ID = "Id";
	public static String PROP_HEAD_IMG = "HeadImg";
	public static String PROP_MAIN_USERS_ID = "MainUsersId";
	public static String PROP_PASSWORD = "Password";
	public static String PROP_BLOG_URL = "BlogUrl";


	// constructors
	public BaseBbsUser () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBbsUser (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseBbsUser (
		java.lang.Integer id,
		java.lang.String username,
		java.lang.String password,
		boolean sex) {

		this.setId(id);
		this.setUsername(username);
		this.setPassword(password);
		this.setSex(sex);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String blogUrl;
	private java.lang.String email;
	private java.lang.String feeling;
	private java.lang.String headImg;
	private java.lang.Integer mainUsersId;
	private java.lang.String password;
	private java.util.Date registDate;
	private boolean sex;
	private java.lang.String username;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="id"
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
	 * Return the value associated with the column: blogUrl
	 */
	public java.lang.String getBlogUrl () {
		return blogUrl;
	}

	/**
	 * Set the value related to the column: blogUrl
	 * @param blogUrl the blogUrl value
	 */
	public void setBlogUrl (java.lang.String blogUrl) {
		this.blogUrl = blogUrl;
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
	 * Return the value associated with the column: feeling
	 */
	public java.lang.String getFeeling () {
		return feeling;
	}

	/**
	 * Set the value related to the column: feeling
	 * @param feeling the feeling value
	 */
	public void setFeeling (java.lang.String feeling) {
		this.feeling = feeling;
	}



	/**
	 * Return the value associated with the column: headImg
	 */
	public java.lang.String getHeadImg () {
		return headImg;
	}

	/**
	 * Set the value related to the column: headImg
	 * @param headImg the headImg value
	 */
	public void setHeadImg (java.lang.String headImg) {
		this.headImg = headImg;
	}



	/**
	 * Return the value associated with the column: mainUsersId
	 */
	public java.lang.Integer getMainUsersId () {
		return mainUsersId;
	}

	/**
	 * Set the value related to the column: mainUsersId
	 * @param mainUsersId the mainUsersId value
	 */
	public void setMainUsersId (java.lang.Integer mainUsersId) {
		this.mainUsersId = mainUsersId;
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
	 * Return the value associated with the column: registDate
	 */
	public java.util.Date getRegistDate () {
		return registDate;
	}

	/**
	 * Set the value related to the column: registDate
	 * @param registDate the registDate value
	 */
	public void setRegistDate (java.util.Date registDate) {
		this.registDate = registDate;
	}



	/**
	 * Return the value associated with the column: sex
	 */
	public boolean isSex () {
		return sex;
	}

	/**
	 * Set the value related to the column: sex
	 * @param sex the sex value
	 */
	public void setSex (boolean sex) {
		this.sex = sex;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.gw.model.BbsUser)) return false;
		else {
			com.gw.model.BbsUser bbsUser = (com.gw.model.BbsUser) obj;
			if (null == this.getId() || null == bbsUser.getId()) return false;
			else return (this.getId().equals(bbsUser.getId()));
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