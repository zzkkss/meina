package com.gw.model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the products table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="products"
 */

public abstract class BaseProducts  implements Serializable {

	public static String REF = "Products";
	public static String PROP_IMG = "Img";
	public static String PROP_LITIMG = "Litimg";
	public static String PROP_DESCRIPTION = "Description";
	public static String PROP_PRICE = "Price";
	public static String PROP_SHOPS_ID = "ShopsId";
	public static String PROP_EVALUATE = "Evaluate";
	public static String PROP_ID = "Id";
	public static String PROP_NAME = "Name";
	public static String PROP_ABOUT = "About";


	// constructors
	public BaseProducts () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseProducts (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseProducts (
		java.lang.Integer id,
		java.lang.Integer evaluate) {

		this.setId(id);
		this.setEvaluate(evaluate);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String about;
	private java.lang.String description;
	private java.lang.Integer evaluate;
	private java.lang.String img;
	private java.lang.String litimg;
	private java.lang.String name;
	private java.lang.String price;
	private java.lang.Integer shopsId;



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
	 * Return the value associated with the column: about
	 */
	public java.lang.String getAbout () {
		return about;
	}

	/**
	 * Set the value related to the column: about
	 * @param about the about value
	 */
	public void setAbout (java.lang.String about) {
		this.about = about;
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
	 * Return the value associated with the column: evaluate
	 */
	public java.lang.Integer getEvaluate () {
		return evaluate;
	}

	/**
	 * Set the value related to the column: evaluate
	 * @param evaluate the evaluate value
	 */
	public void setEvaluate (java.lang.Integer evaluate) {
		this.evaluate = evaluate;
	}



	/**
	 * Return the value associated with the column: img
	 */
	public java.lang.String getImg () {
		return img;
	}

	/**
	 * Set the value related to the column: img
	 * @param img the img value
	 */
	public void setImg (java.lang.String img) {
		this.img = img;
	}



	/**
	 * Return the value associated with the column: litimg
	 */
	public java.lang.String getLitimg () {
		return litimg;
	}

	/**
	 * Set the value related to the column: litimg
	 * @param litimg the litimg value
	 */
	public void setLitimg (java.lang.String litimg) {
		this.litimg = litimg;
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
	 * Return the value associated with the column: price
	 */
	public java.lang.String getPrice () {
		return price;
	}

	/**
	 * Set the value related to the column: price
	 * @param price the price value
	 */
	public void setPrice (java.lang.String price) {
		this.price = price;
	}



	/**
	 * Return the value associated with the column: shopsId
	 */
	public java.lang.Integer getShopsId () {
		return shopsId;
	}

	/**
	 * Set the value related to the column: shopsId
	 * @param shopsId the shopsId value
	 */
	public void setShopsId (java.lang.Integer shopsId) {
		this.shopsId = shopsId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.gw.model.Products)) return false;
		else {
			com.gw.model.Products products = (com.gw.model.Products) obj;
			if (null == this.getId() || null == products.getId()) return false;
			else return (this.getId().equals(products.getId()));
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