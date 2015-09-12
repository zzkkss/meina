package com.gw.model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the terminals table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="terminals"
 */

public abstract class BaseTerminals  implements Serializable {

	public static String REF = "Terminals";
	public static String PROP_RAW_DATA = "RawData";
	public static String PROP_LNG = "Lng";
	public static String PROP_UTC = "Utc";
	public static String PROP_TCP_SESSION = "TcpSession";
	public static String PROP_POSITION_STATE = "PositionState";
	public static String PROP_TNAME = "Tname";
	public static String PROP_T_ID = "TId";
	public static String PROP_DEVICE_TYPE = "DeviceType";
	public static String PROP_DEVICE_STATE = "DeviceState";
	public static String PROP_DIFTYPE = "Diftype";
	public static String PROP_HGT = "Hgt";
	public static String PROP_ONLINE_STATE = "OnlineState";
	public static String PROP_DEVICE_SOFT_VERSION = "DeviceSoftVersion";
	public static String PROP_DATA_LENGTH = "DataLength";
	public static String PROP_DATA_TYPE = "DataType";
	public static String PROP_ID = "Id";
	public static String PROP_INTRODUCTIONS = "Introductions";
	public static String PROP_CARDGPSTYPE = "Cardgpstype";
	public static String PROP_DIF_KEY = "DifKey";
	public static String PROP_GPS_CARD_NUM = "GpsCardNum";
	public static String PROP_LAT = "Lat";
	public static String PROP_UDP_SESSION = "UdpSession";


	// constructors
	public BaseTerminals () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTerminals (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseTerminals (
		java.lang.Integer id,
		java.lang.Long tId,
		java.lang.String tname,
		java.lang.String deviceType,
		java.lang.Integer deviceState,
		java.lang.String difKey,
		java.lang.String deviceSoftVersion,
		java.lang.String gpsCardNum,
		java.lang.Integer diftype,
		java.lang.Integer cardgpstype,
		java.lang.Double lat,
		java.lang.Double lng,
		java.lang.Double hgt,
		java.lang.String positionState,
		java.lang.String rawData,
		java.lang.Integer dataLength,
		java.lang.Integer dataType,
		java.lang.String introductions,
		java.lang.String onlineState,
		java.lang.Long tcpSession,
		java.lang.Long udpSession) {

		this.setId(id);
		this.setTId(tId);
		this.setTname(tname);
		this.setDeviceType(deviceType);
		this.setDeviceState(deviceState);
		this.setDifKey(difKey);
		this.setDeviceSoftVersion(deviceSoftVersion);
		this.setGpsCardNum(gpsCardNum);
		this.setDiftype(diftype);
		this.setCardgpstype(cardgpstype);
		this.setLat(lat);
		this.setLng(lng);
		this.setHgt(hgt);
		this.setPositionState(positionState);
		this.setRawData(rawData);
		this.setDataLength(dataLength);
		this.setDataType(dataType);
		this.setIntroductions(introductions);
		this.setOnlineState(onlineState);
		this.setTcpSession(tcpSession);
		this.setUdpSession(udpSession);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Long tId;
	private java.lang.String tname;
	private java.lang.String deviceType;
	private java.lang.Integer deviceState;
	private java.lang.String difKey;
	private java.lang.String deviceSoftVersion;
	private java.lang.String gpsCardNum;
	private java.lang.Integer diftype;
	private java.lang.Integer cardgpstype;
	private java.lang.Double lat;
	private java.lang.Double utc;
	private java.lang.Double lng;
	private java.lang.Double hgt;
	private java.lang.String positionState;
	private java.lang.String rawData;
	private java.lang.Integer dataLength;
	private java.lang.Integer dataType;
	private java.lang.String introductions;
	private java.lang.String onlineState;
	private java.lang.Long tcpSession;
	private java.lang.Long udpSession;



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
	 * Return the value associated with the column: tId
	 */
	public java.lang.Long getTId () {
		return tId;
	}

	/**
	 * Set the value related to the column: tId
	 * @param tId the tId value
	 */
	public void setTId (java.lang.Long tId) {
		this.tId = tId;
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
	 * Return the value associated with the column: deviceState
	 */
	public java.lang.Integer getDeviceState () {
		return deviceState;
	}

	/**
	 * Set the value related to the column: deviceState
	 * @param deviceState the deviceState value
	 */
	public void setDeviceState (java.lang.Integer deviceState) {
		this.deviceState = deviceState;
	}



	/**
	 * Return the value associated with the column: difKey
	 */
	public java.lang.String getDifKey () {
		return difKey;
	}

	/**
	 * Set the value related to the column: difKey
	 * @param difKey the difKey value
	 */
	public void setDifKey (java.lang.String difKey) {
		this.difKey = difKey;
	}



	/**
	 * Return the value associated with the column: deviceSoftVersion
	 */
	public java.lang.String getDeviceSoftVersion () {
		return deviceSoftVersion;
	}

	/**
	 * Set the value related to the column: deviceSoftVersion
	 * @param deviceSoftVersion the deviceSoftVersion value
	 */
	public void setDeviceSoftVersion (java.lang.String deviceSoftVersion) {
		this.deviceSoftVersion = deviceSoftVersion;
	}



	/**
	 * Return the value associated with the column: gpsCardNum
	 */
	public java.lang.String getGpsCardNum () {
		return gpsCardNum;
	}

	/**
	 * Set the value related to the column: gpsCardNum
	 * @param gpsCardNum the gpsCardNum value
	 */
	public void setGpsCardNum (java.lang.String gpsCardNum) {
		this.gpsCardNum = gpsCardNum;
	}



	/**
	 * Return the value associated with the column: diftype
	 */
	public java.lang.Integer getDiftype () {
		return diftype;
	}

	/**
	 * Set the value related to the column: diftype
	 * @param diftype the diftype value
	 */
	public void setDiftype (java.lang.Integer diftype) {
		this.diftype = diftype;
	}



	/**
	 * Return the value associated with the column: cardgpstype
	 */
	public java.lang.Integer getCardgpstype () {
		return cardgpstype;
	}

	/**
	 * Set the value related to the column: cardgpstype
	 * @param cardgpstype the cardgpstype value
	 */
	public void setCardgpstype (java.lang.Integer cardgpstype) {
		this.cardgpstype = cardgpstype;
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
	 * Return the value associated with the column: utc
	 */
	public java.lang.Double getUtc () {
		return utc;
	}

	/**
	 * Set the value related to the column: utc
	 * @param utc the utc value
	 */
	public void setUtc (java.lang.Double utc) {
		this.utc = utc;
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
	 * Return the value associated with the column: positionState
	 */
	public java.lang.String getPositionState () {
		return positionState;
	}

	/**
	 * Set the value related to the column: positionState
	 * @param positionState the positionState value
	 */
	public void setPositionState (java.lang.String positionState) {
		this.positionState = positionState;
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
	 * Return the value associated with the column: Introductions
	 */
	public java.lang.String getIntroductions () {
		return introductions;
	}

	/**
	 * Set the value related to the column: Introductions
	 * @param introductions the Introductions value
	 */
	public void setIntroductions (java.lang.String introductions) {
		this.introductions = introductions;
	}



	/**
	 * Return the value associated with the column: onlineState
	 */
	public java.lang.String getOnlineState () {
		return onlineState;
	}

	/**
	 * Set the value related to the column: onlineState
	 * @param onlineState the onlineState value
	 */
	public void setOnlineState (java.lang.String onlineState) {
		this.onlineState = onlineState;
	}



	/**
	 * Return the value associated with the column: TcpSession
	 */
	public java.lang.Long getTcpSession () {
		return tcpSession;
	}

	/**
	 * Set the value related to the column: TcpSession
	 * @param tcpSession the TcpSession value
	 */
	public void setTcpSession (java.lang.Long tcpSession) {
		this.tcpSession = tcpSession;
	}



	/**
	 * Return the value associated with the column: UdpSession
	 */
	public java.lang.Long getUdpSession () {
		return udpSession;
	}

	/**
	 * Set the value related to the column: UdpSession
	 * @param udpSession the UdpSession value
	 */
	public void setUdpSession (java.lang.Long udpSession) {
		this.udpSession = udpSession;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.gw.model.Terminals)) return false;
		else {
			com.gw.model.Terminals terminals = (com.gw.model.Terminals) obj;
			if (null == this.getId() || null == terminals.getId()) return false;
			else return (this.getId().equals(terminals.getId()));
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