package com.cs.data;

import java.util.LinkedList;

public abstract class Airplane implements Aircraft {
	private String ident, model;
	private ACCategory category;
	private ACType type;
	private LinkedList<ACAttributes> attributes;
	
	public Airplane(String ident, String model, ACCategory category, ACType type, LinkedList<ACAttributes> attributes) {
		this.ident = ident;
		this.model = model;
		this.category = category;
		this.type = type;
		
		if(attributes != null)
			this.attributes = attributes;
		else
			this.attributes = new LinkedList<ACAttributes>();
	}
	
	
	@Override
	public String getIdent() {
		return ident;
	}


	@Override
	public String getModel() {
		return model;
	}


	@Override
	public ACCategory getCateogry() {
		return category;
	}


	@Override
	public ACType getType() {
		return type;
	}


	@Override
	public LinkedList<ACAttributes> getAttributes() {
		return attributes;
	}


	@Override
	public String toString()
	{
		String data;
		data = "MODEL: " + model +"\n" + "IDENT: " + ident + "\n"
				+ "CAT: " + category.toString() + "\n"
				+ "CLA: " + type.toString() + "\n";
		
		data += "Attributes\n";
		if(attributes.size() == 0) {
			data += "None\n";
		}
		else {
			for(int i = 0; i < attributes.size(); i++)
				data += attributes.get(i).toString() + "\n";
		}
		
		return data;
	}
}
