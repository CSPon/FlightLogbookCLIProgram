package com.cs.data;

import java.util.LinkedList;

public class AirplaneMultiEngineLand extends Airplane {
	public AirplaneMultiEngineLand(String ident, String model, LinkedList<ACCategory> tags) {
		super(ident, model, ACCategory.AIRPLANE, ACCategory.MULTI_ENGINE_LAND, tags);
	}
}
