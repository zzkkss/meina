package com.gw.model;

import com.gw.model.base.BaseTerminalsXingzhe;



public class TerminalsXingzhe extends BaseTerminalsXingzhe {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public TerminalsXingzhe () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public TerminalsXingzhe (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public TerminalsXingzhe (
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

		super (
			id,
			tname,
			deviceType,
			parameter,
			rawData,
			dataLength,
			dataType,
			tcpSession,
			udpSession,
			lat,
			lng,
			hgt,
			speed,
			distance,
			stepNumber);
	}

/*[CONSTRUCTOR MARKER END]*/


}