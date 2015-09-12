package com.gw.model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the weixin_user table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="weixin_user"
 */

public abstract class BaseWeixinUser  implements Serializable {

	public static String REF = "WeixinUser";
	public static String PROP_LANGUAGE = "Language";
	public static String PROP_SUBSCRIBE_TIME = "SubscribeTime";
	public static String PROP_SEX = "Sex";
	public static String PROP_UNIONID = "Unionid";
	public static String PROP_COUNTRY = "Country";
	public static String PROP_HEADIMGURL = "Headimgurl";
	public static String PROP_SUBSCRIBE = "Subscribe";
	public static String PROP_CITY = "City";
	public static String PROP_ID = "Id";
	public static String PROP_OPENID = "Openid";
	public static String PROP_PROVINCE = "Province";
	public static String PROP_NICKNAME = "Nickname";


	// constructors
	public BaseWeixinUser () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseWeixinUser (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseWeixinUser (
		java.lang.Integer id,
		java.lang.String openid) {

		this.setId(id);
		this.setOpenid(openid);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String city;
	private java.lang.String country;
	private java.lang.String headimgurl;
	private java.lang.String language;
	private byte[] nickname;
	private java.lang.String openid;
	private java.lang.String province;
	private java.lang.String sex;
	private java.lang.String subscribe;
	private java.lang.String subscribeTime;
	private java.lang.String unionid;



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
	 * Return the value associated with the column: city
	 */
	public java.lang.String getCity () {
		return city;
	}

	/**
	 * Set the value related to the column: city
	 * @param city the city value
	 */
	public void setCity (java.lang.String city) {
		this.city = city;
	}



	/**
	 * Return the value associated with the column: country
	 */
	public java.lang.String getCountry () {
		return country;
	}

	/**
	 * Set the value related to the column: country
	 * @param country the country value
	 */
	public void setCountry (java.lang.String country) {
		this.country = country;
	}



	/**
	 * Return the value associated with the column: headimgurl
	 */
	public java.lang.String getHeadimgurl () {
		return headimgurl;
	}

	/**
	 * Set the value related to the column: headimgurl
	 * @param headimgurl the headimgurl value
	 */
	public void setHeadimgurl (java.lang.String headimgurl) {
		this.headimgurl = headimgurl;
	}



	/**
	 * Return the value associated with the column: language
	 */
	public java.lang.String getLanguage () {
		return language;
	}

	/**
	 * Set the value related to the column: language
	 * @param language the language value
	 */
	public void setLanguage (java.lang.String language) {
		this.language = language;
	}



	/**
	 * Return the value associated with the column: nickname
	 */
	public byte[] getNickname () {
		return nickname;
	}

	/**
	 * Set the value related to the column: nickname
	 * @param nickname the nickname value
	 */
	public void setNickname (byte[] nickname) {
		this.nickname = nickname;
	}



	/**
	 * Return the value associated with the column: openid
	 */
	public java.lang.String getOpenid () {
		return openid;
	}

	/**
	 * Set the value related to the column: openid
	 * @param openid the openid value
	 */
	public void setOpenid (java.lang.String openid) {
		this.openid = openid;
	}



	/**
	 * Return the value associated with the column: province
	 */
	public java.lang.String getProvince () {
		return province;
	}

	/**
	 * Set the value related to the column: province
	 * @param province the province value
	 */
	public void setProvince (java.lang.String province) {
		this.province = province;
	}



	/**
	 * Return the value associated with the column: sex
	 */
	public java.lang.String getSex () {
		return sex;
	}

	/**
	 * Set the value related to the column: sex
	 * @param sex the sex value
	 */
	public void setSex (java.lang.String sex) {
		this.sex = sex;
	}



	/**
	 * Return the value associated with the column: subscribe
	 */
	public java.lang.String getSubscribe () {
		return subscribe;
	}

	/**
	 * Set the value related to the column: subscribe
	 * @param subscribe the subscribe value
	 */
	public void setSubscribe (java.lang.String subscribe) {
		this.subscribe = subscribe;
	}



	/**
	 * Return the value associated with the column: subscribe_time
	 */
	public java.lang.String getSubscribeTime () {
		return subscribeTime;
	}

	/**
	 * Set the value related to the column: subscribe_time
	 * @param subscribeTime the subscribe_time value
	 */
	public void setSubscribeTime (java.lang.String subscribeTime) {
		this.subscribeTime = subscribeTime;
	}



	/**
	 * Return the value associated with the column: unionid
	 */
	public java.lang.String getUnionid () {
		return unionid;
	}

	/**
	 * Set the value related to the column: unionid
	 * @param unionid the unionid value
	 */
	public void setUnionid (java.lang.String unionid) {
		this.unionid = unionid;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.gw.model.WeixinUser)) return false;
		else {
			com.gw.model.WeixinUser weixinUser = (com.gw.model.WeixinUser) obj;
			if (null == this.getId() || null == weixinUser.getId()) return false;
			else return (this.getId().equals(weixinUser.getId()));
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