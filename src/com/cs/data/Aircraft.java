package com.cs.data;

import java.util.LinkedList;

public interface Aircraft {
	public String getIdent();
	public String getModel();
	public String toString();
	public ACCategory getCateogry();
	public ACType getType(); // THIS IS THE CLASS!!!!!
	public LinkedList<ACAttributes> getAttributes();
}
