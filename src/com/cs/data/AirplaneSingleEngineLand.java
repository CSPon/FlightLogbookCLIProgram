package com.cs.data;

import java.util.LinkedList;

public class AirplaneSingleEngineLand extends Airplane {

	public AirplaneSingleEngineLand(String ident, String model, ACCategory category, ACType type,
			LinkedList<ACAttributes> attributes) {
		super(ident, model, category, type, attributes);
	}
}
