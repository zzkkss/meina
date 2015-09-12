package com.gw.model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the shops table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="shops"
 */

public abstract class BaseShops  implements Serializable {

	public static String REF = "Shops";
	public static String PROP_IMG = "Img";
	public static String PROP_LITIMG = "Litimg";
	public static String PROP_ADDRESS = "Address";
	public static String PROP_EVALUATE = "Evaluate";
	public static String PROP_TITLE = "Title";
	public static String PROP_CITY = "City";
	public static String PROP_ABOUT = "About";
	public static String PROP_USERS_ID = "UsersId";
	public static String PROP_TYPE = "Type";
	public static String PROP_CITYID = "Cityid";
	public static String PROP_COORDINATE = "Coordinate";
	public static String PROP_CONTENT = "Content";
	public static String PROP_PHONE = "Phone";
	public static String PROP_ID = "Id";


	// constructors
	public BaseShops () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseShops (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String title;
	private java.lang.String content;
	private java.lang.String img;
	private java.lang.Integer type;
	private java.lang.String address;
	private java.lang.String phone;
	private java.lang.String coordinate;
	private java.lang.String city;
	private java.lang.Integer usersId;
	private java.lang.String litimg;
	private java.lang.Integer evaluate;
	private java.lang.String about;
	private java.lang.Integer cityid;



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
	 * Return the value associated with the column: type
	 */
	public java.lang.Integer getType () {
		return type;
	}

	/**
	 * Set the value related to the column: type
	 * @param type the type value
	 */
	public void setType (java.lang.Integer type) {
		this.type = type;
	}



	/**
	 * Return the value associated with the column: address
	 */
	public java.lang.String getAddress () {
		return address;
	}

	/**
	 * Set the value related to the column: address
	 * @param address the address value
	 */
	public void setAddress (java.lang.String address) {
		this.address = address;
	}



	/**
	 * Return the value associated with the column: phone
	 */
	public java.lang.String getPhone () {
		return phone;
	}

	/**
	 * Set the value related to the column: phone
	 * @param phone the phone value
	 */
	public void setPhone (java.lang.String phone) {
		this.phone = phone;
	}



	/**
	 * Return the value associated with the column: coordinate
	 */
	public java.lang.String getCoordinate () {
		return coordinate;
	}

	/**
	 * Set the value related to the column: coordinate
	 * @param coordinate the coordinate value
	 */
	public void setCoordinate (java.lang.String coordinate) {
		this.coordinate = coordinate;
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
	 * Return the value associated with the column: cityid
	 */
	public java.lang.Integer getCityid () {
		return cityid;
	}

	/**
	 * Set the value related to the column: cityid
	 * @param cityid the cityid value
	 */
	public void setCityid (java.lang.Integer cityid) {
		this.cityid = cityid;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.gw.model.Shops)) return false;
		else {
			com.gw.model.Shops shops = (com.gw.model.Shops) obj;
			if (null == this.getId() || null == shops.getId()) return false;
			else return (this.getId().equals(shops.getId()));
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