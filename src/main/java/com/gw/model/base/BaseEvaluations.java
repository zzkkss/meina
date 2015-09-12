package com.gw.model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the evaluations table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="evaluations"
 */

public abstract class BaseEvaluations  implements Serializable {

	public static String REF = "Evaluations";
	public static String PROP_SCORE = "Score";
	public static String PROP_CONTENT = "Content";
	public static String PROP_USER_ID = "UserId";
	public static String PROP_TITLE = "Title";
	public static String PROP_PRODUCT_ID = "ProductId";
	public static String PROP_ID = "Id";
	public static String PROP_ORDER_ID = "OrderId";


	// constructors
	public BaseEvaluations () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseEvaluations (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer productId;
	private java.lang.Integer orderId;
	private java.lang.Integer score;
	private java.lang.String title;
	private java.lang.String content;
	private java.lang.Integer userId;



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
	 * Return the value associated with the column: productId
	 */
	public java.lang.Integer getProductId () {
		return productId;
	}

	/**
	 * Set the value related to the column: productId
	 * @param productId the productId value
	 */
	public void setProductId (java.lang.Integer productId) {
		this.productId = productId;
	}



	/**
	 * Return the value associated with the column: orderId
	 */
	public java.lang.Integer getOrderId () {
		return orderId;
	}

	/**
	 * Set the value related to the column: orderId
	 * @param orderId the orderId value
	 */
	public void setOrderId (java.lang.Integer orderId) {
		this.orderId = orderId;
	}



	/**
	 * Return the value associated with the column: score
	 */
	public java.lang.Integer getScore () {
		return score;
	}

	/**
	 * Set the value related to the column: score
	 * @param score the score value
	 */
	public void setScore (java.lang.Integer score) {
		this.score = score;
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
	 * Return the value associated with the column: content
	 */
	public java.lang.String getContent () {
		return content;
	}

	/**
	 * Set the value related to the column: content
	 * @param content the content value
	 */
	public void setContent (java.lang.String content) {
		this.content = content;
	}



	/**
	 * Return the value associated with the column: userId
	 */
	public java.lang.Integer getUserId () {
		return userId;
	}

	/**
	 * Set the value related to the column: userId
	 * @param userId the userId value
	 */
	public void setUserId (java.lang.Integer userId) {
		this.userId = userId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.gw.model.Evaluations)) return false;
		else {
			com.gw.model.Evaluations evaluations = (com.gw.model.Evaluations) obj;
			if (null == this.getId() || null == evaluations.getId()) return false;
			else return (this.getId().equals(evaluations.getId()));
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