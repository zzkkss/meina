package com.gw.model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the weixin_article table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="weixin_article"
 */

public abstract class BaseWeixinArticle  implements Serializable {

	public static String REF = "WeixinArticle";
	public static String PROP_DESCRIPTION = "Description";
	public static String PROP_TITLE = "Title";
	public static String PROP_ID = "Id";
	public static String PROP_PIC_URL = "PicUrl";
	public static String PROP_URL = "Url";


	// constructors
	public BaseWeixinArticle () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseWeixinArticle (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String title;
	private java.lang.String description;
	private java.lang.String picUrl;
	private java.lang.String url;



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
	 * Return the value associated with the column: title
	 */
	public java.lang.String getTitle () {
		return title;
	}

	/**
	 * Set the value related to the column: title
	 * @param title the title value
	 */
	public void setTitle (java.lang.String title) {
		this.title = title;
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
	 * Return the value associated with the column: pic_url
	 */
	public java.lang.String getPicUrl () {
		return picUrl;
	}

	/**
	 * Set the value related to the column: pic_url
	 * @param picUrl the pic_url value
	 */
	public void setPicUrl (java.lang.String picUrl) {
		this.picUrl = picUrl;
	}



	/**
	 * Return the value associated with the column: url
	 */
	public java.lang.String getUrl () {
		return url;
	}

	/**
	 * Set the value related to the column: url
	 * @param url the url value
	 */
	public void setUrl (java.lang.String url) {
		this.url = url;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.gw.model.WeixinArticle)) return false;
		else {
			com.gw.model.WeixinArticle weixinArticle = (com.gw.model.WeixinArticle) obj;
			if (null == this.getId() || null == weixinArticle.getId()) return false;
			else return (this.getId().equals(weixinArticle.getId()));
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