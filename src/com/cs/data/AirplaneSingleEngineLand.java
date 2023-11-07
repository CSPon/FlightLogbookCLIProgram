package com.cs.data;

import java.util.LinkedList;

public class AirplaneSingleEngineLand extends Airplane {
	public AirplaneSingleEngineLand(String ident, String model, LinkedList<ACCategory> tags) {
		super(ident, model, ACCategory.AIRPLANE, ACCategory.SINGLE_ENGINE_LAND, tags);
	}
}
