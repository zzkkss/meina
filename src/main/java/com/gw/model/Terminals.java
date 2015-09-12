package com.gw.model;

import com.gw.model.base.BaseTerminals;



public class Terminals extends BaseTerminals {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Terminals () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Terminals (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Terminals (
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

		super (
			id,
			tId,
			tname,
			deviceType,
			deviceState,
			difKey,
			deviceSoftVersion,
			gpsCardNum,
			diftype,
			cardgpstype,
			lat,
			lng,
			hgt,
			positionState,
			rawData,
			dataLength,
			dataType,
			introductions,
			onlineState,
			tcpSession,
			udpSession);
	}

/*[CONSTRUCTOR MARKER END]*/


}