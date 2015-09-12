package com.gw.model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the weixin_user_terminals table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="weixin_user_terminals"
 */

public abstract class BaseWeixinUserTerminals  implements Serializable {

	public static String REF = "WeixinUserTerminals";
	public static String PROP_BIND = "Bind";
	public static String PROP_CREATE_TIME = "CreateTime";
	public static String PROP_ID = "Id";
	public static String PROP_TNAME = "Tname";
	public static String PROP_NICK_NAME = "NickName";
	public static String PROP_OPENID = "Openid";
	public static String PROP_INTERVAL_SECONDS = "IntervalSeconds";
	public static String PROP_LAST_TIME = "LastTime";


	// constructors
	public BaseWeixinUserTerminals () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseWeixinUserTerminals (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseWeixinUserTerminals (
		java.lang.Integer id,
		java.lang.String nickName) {

		this.setId(id);
		this.setNickName(nickName);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String openid;
	private java.lang.String tname;
	private java.lang.Integer createTime;
	private java.lang.String nickName;
	private java.lang.String bind;
	private java.lang.Integer intervalSeconds;
	private java.lang.Integer lastTime;



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
	 * Return the value associated with the column: tname
	 */
	public java.lang.String getTname () {
		return tname;
	}

	/**
	 * Set the value related to the column: tname
	 * @param tname the tname value
	 */
	public void setTname (java.lang.String tname) {
		this.tname = tname;
	}



	/**
	 * Return the value associated with the column: createTime
	 */
	public java.lang.Integer getCreateTime () {
		return createTime;
	}

	/**
	 * Set the value related to the column: createTime
	 * @param createTime the createTime value
	 */
	public void setCreateTime (java.lang.Integer createTime) {
		this.createTime = createTime;
	}



	/**
	 * Return the value associated with the column: nickName
	 */
	public java.lang.String getNickName () {
		return nickName;
	}

	/**
	 * Set the value related to the column: nickName
	 * @param nickName the nickName value
	 */
	public void setNickName (java.lang.String nickName) {
		this.nickName = nickName;
	}



	/**
	 * Return the value associated with the column: bind
	 */
	public java.lang.String getBind () {
		return bind;
	}

	/**
	 * Set the value related to the column: bind
	 * @param bind the bind value
	 */
	public void setBind (java.lang.String bind) {
		this.bind = bind;
	}



	/**
	 * Return the value associated with the column: intervalSeconds
	 */
	public java.lang.Integer getIntervalSeconds () {
		return intervalSeconds;
	}

	/**
	 * Set the value related to the column: intervalSeconds
	 * @param intervalSeconds the intervalSeconds value
	 */
	public void setIntervalSeconds (java.lang.Integer intervalSeconds) {
		this.intervalSeconds = intervalSeconds;
	}



	/**
	 * Return the value associated with the column: lastTime
	 */
	public java.lang.Integer getLastTime () {
		return lastTime;
	}

	/**
	 * Set the value related to the column: lastTime
	 * @param lastTime the lastTime value
	 */
	public void setLastTime (java.lang.Integer lastTime) {
		this.lastTime = lastTime;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.gw.model.WeixinUserTerminals)) return false;
		else {
			com.gw.model.WeixinUserTerminals weixinUserTerminals = (com.gw.model.WeixinUserTerminals) obj;
			if (null == this.getId() || null == weixinUserTerminals.getId()) return false;
			else return (this.getId().equals(weixinUserTerminals.getId()));
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