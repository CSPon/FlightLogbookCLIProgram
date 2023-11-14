package com.cs;

import java.util.HashMap;

import com.cs.data.Aircraft;

public class LogbookDataTracks {

	private HashMap<String, Aircraft> aircrafts;
	
	public LogbookDataTracks() {
		aircrafts = new HashMap<String, Aircraft>();
	}
	
	public void addAircraft(String ident, Aircraft data) {
		aircrafts.put(ident, data);
	}
	
	public Aircraft getAircraft(String ident) {
		return aircrafts.get(ident);
	}
}
