package com.gw.model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the terminals_xingzhe table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="terminals_xingzhe"
 */

public abstract class BaseTerminalsXingzhe  implements Serializable {

	public static String REF = "TerminalsXingzhe";
	public static String PROP_RAW_DATA = "RawData";
	public static String PROP_SPEED = "Speed";
	public static String PROP_LNG = "Lng";
	public static String PROP_TCP_SESSION = "TcpSession";
	public static String PROP_TNAME = "Tname";
	public static String PROP_DEVICE_TYPE = "DeviceType";
	public static String PROP_HGT = "Hgt";
	public static String PROP_STEP_NUMBER = "StepNumber";
	public static String PROP_DATA_LENGTH = "DataLength";
	public static String PROP_PARAMETER = "Parameter";
	public static String PROP_DATA_TYPE = "DataType";
	public static String PROP_ID = "Id";
	public static String PROP_LAT = "Lat";
	public static String PROP_DISTANCE = "Distance";
	public static String PROP_UDP_SESSION = "UdpSession";


	// constructors
	public BaseTerminalsXingzhe () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTerminalsXingzhe (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseTerminalsXingzhe (
		java.lang.Integer id,
		java.lang.String tname,
		java.lang.String deviceType,
		java.lang.String parameter,
		java.lang.String rawData,
		java.lang.Integer dataLength,
		java.lang.Integer dataType,
		java.lang.Long tcpSession,
		java.lang.Long udpSession,
		java.lang.Double lat,
		java.lang.Double lng,
		java.lang.Double hgt,
		java.lang.Double speed,
		java.lang.Double distance,
		java.lang.Double stepNumber) {

		this.setId(id);
		this.setTname(tname);
		this.setDeviceType(deviceType);
		this.setParameter(parameter);
		this.setRawData(rawData);
		this.setDataLength(dataLength);
		this.setDataType(dataType);
		this.setTcpSession(tcpSession);
		this.setUdpSession(udpSession);
		this.setLat(lat);
		this.setLng(lng);
		this.setHgt(hgt);
		this.setSpeed(speed);
		this.setDistance(distance);
		this.setStepNumber(stepNumber);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String tname;
	private java.lang.String deviceType;
	private java.lang.String parameter;
	private java.lang.String rawData;
	private java.lang.Integer dataLength;
	private java.lang.Integer dataType;
	private java.lang.Long tcpSession;
	private java.lang.Long udpSession;
	private java.lang.Double lat;
	private java.lang.Double lng;
	private java.lang.Double hgt;
	private java.lang.Double speed;
	private java.lang.Double distance;
	private java.lang.Double stepNumber;



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
	 * Return the value associated with the column: deviceType
	 */
	public java.lang.String getDeviceType () {
		return deviceType;
	}

	/**
	 * Set the value related to the column: deviceType
	 * @param deviceType the deviceType value
	 */
	public void setDeviceType (java.lang.String deviceType) {
		this.deviceType = deviceType;
	}



	/**
	 * Return the value associated with the column: parameter
	 */
	public java.lang.String getParameter () {
		return parameter;
	}

	/**
	 * Set the value related to the column: parameter
	 * @param parameter the parameter value
	 */
	public void setParameter (java.lang.String parameter) {
		this.parameter = parameter;
	}



	/**
	 * Return the value associated with the column: rawData
	 */
	public java.lang.String getRawData () {
		return rawData;
	}

	/**
	 * Set the value related to the column: rawData
	 * @param rawData the rawData value
	 */
	public void setRawData (java.lang.String rawData) {
		this.rawData = rawData;
	}



	/**
	 * Return the value associated with the column: dataLength
	 */
	public java.lang.Integer getDataLength () {
		return dataLength;
	}

	/**
	 * Set the value related to the column: dataLength
	 * @param dataLength the dataLength value
	 */
	public void setDataLength (java.lang.Integer dataLength) {
		this.dataLength = dataLength;
	}



	/**
	 * Return the value associated with the column: dataType
	 */
	public java.lang.Integer getDataType () {
		return dataType;
	}

	/**
	 * Set the value related to the column: dataType
	 * @param dataType the dataType value
	 */
	public void setDataType (java.lang.Integer dataType) {
		this.dataType = dataType;
	}



	/**
	 * Return the value associated with the column: tcpSession
	 */
	public java.lang.Long getTcpSession () {
		return tcpSession;
	}

	/**
	 * Set the value related to the column: tcpSession
	 * @param tcpSession the tcpSession value
	 */
	public void setTcpSession (java.lang.Long tcpSession) {
		this.tcpSession = tcpSession;
	}



	/**
	 * Return the value associated with the column: udpSession
	 */
	public java.lang.Long getUdpSession () {
		return udpSession;
	}

	/**
	 * Set the value related to the column: udpSession
	 * @param udpSession the udpSession value
	 */
	public void setUdpSession (java.lang.Long udpSession) {
		this.udpSession = udpSession;
	}



	/**
	 * Return the value associated with the column: lat
	 */
	public java.lang.Double getLat () {
		return lat;
	}

	/**
	 * Set the value related to the column: lat
	 * @param lat the lat value
	 */
	public void setLat (java.lang.Double lat) {
		this.lat = lat;
	}



	/**
	 * Return the value associated with the column: lng
	 */
	public java.lang.Double getLng () {
		return lng;
	}

	/**
	 * Set the value related to the column: lng
	 * @param lng the lng value
	 */
	public void setLng (java.lang.Double lng) {
		this.lng = lng;
	}



	/**
	 * Return the value associated with the column: hgt
	 */
	public java.lang.Double getHgt () {
		return hgt;
	}

	/**
	 * Set the value related to the column: hgt
	 * @param hgt the hgt value
	 */
	public void setHgt (java.lang.Double hgt) {
		this.hgt = hgt;
	}



	/**
	 * Return the value associated with the column: speed
	 */
	public java.lang.Double getSpeed () {
		return speed;
	}

	/**
	 * Set the value related to the column: speed
	 * @param speed the speed value
	 */
	public void setSpeed (java.lang.Double speed) {
		this.speed = speed;
	}



	/**
	 * Return the value associated with the column: distance
	 */
	public java.lang.Double getDistance () {
		return distance;
	}

	/**
	 * Set the value related to the column: distance
	 * @param distance the distance value
	 */
	public void setDistance (java.lang.Double distance) {
		this.distance = distance;
	}



	/**
	 * Return the value associated with the column: stepNumber
	 */
	public java.lang.Double getStepNumber () {
		return stepNumber;
	}

	/**
	 * Set the value related to the column: stepNumber
	 * @param stepNumber the stepNumber value
	 */
	public void setStepNumber (java.lang.Double stepNumber) {
		this.stepNumber = stepNumber;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.gw.model.TerminalsXingzhe)) return false;
		else {
			com.gw.model.TerminalsXingzhe terminalsXingzhe = (com.gw.model.TerminalsXingzhe) obj;
			if (null == this.getId() || null == terminalsXingzhe.getId()) return false;
			else return (this.getId().equals(terminalsXingzhe.getId()));
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