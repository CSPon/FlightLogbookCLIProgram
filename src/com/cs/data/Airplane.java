package com.cs.data;

import java.util.LinkedList;

public abstract class Airplane implements Aircraft {
	private String ident, model;
	private ACCategory ac_category, ac_class;
	
	private LinkedList<ACCategory> tags;
	
	public Airplane(String ident, String model, ACCategory ac_category, ACCategory ac_class, LinkedList<ACCategory> tags) {
		super();
		this.ident = ident;
		this.model = model;
		this.ac_category = ac_category;
		this.ac_class = ac_class;
		
		if(tags != null)
			this.tags = tags;
		else
			this.tags = new LinkedList<ACCategory>();
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
	public String toString()
	{
		String data;
		data = "MODEL: " + model +"\n" + "IDENT: " + ident + "\n"
				+ "CAT: " + ac_category.toString() + "\n"
				+ "CLA: " + ac_class.toString() + "\n";
		
		data += "Additional Tags\n";
		if(tags.size() == 0) {
			data += "None\n";
		}
		else {
			for(int i = 0; i < tags.size(); i++)
				data += tags.get(i).toString() + "\n";
		}
		
		return data;
	}
	public ACCategory getAc_category() {
		return ac_category;
	}
	public void setAc_category(ACCategory ac_category) {
		this.ac_category = ac_category;
	}
	public ACCategory getAc_class() {
		return ac_class;
	}
	public void setAc_class(ACCategory ac_class) {
		this.ac_class = ac_class;
	}
	public void setIdent(String ident) {
		this.ident = ident;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public LinkedList<ACCategory> getTags() {
		return tags;
	}
	public void setTags(LinkedList<ACCategory> tags) {
		this.tags = tags;
	}
}
