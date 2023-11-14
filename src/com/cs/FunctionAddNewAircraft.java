package com.cs;

import java.util.LinkedList;
import java.util.Scanner;

import com.cs.data.ACAttributes;
import com.cs.data.ACCategory;
import com.cs.data.ACType;
import com.cs.data.Aircraft;
import com.cs.data.AirplaneMultiEngineLand;
import com.cs.data.AirplaneSingleEngineLand;

public class FunctionAddNewAircraft {
	
	private Scanner input;
	private LogbookDataTracks db;
	
	public FunctionAddNewAircraft(LogbookDataTracks db, Scanner input) {
		this.db = db;
		this.input = input;
	}
	
	public boolean printFunctionAddNewAircraft() {
		String model, tail, cla, attr;
		char cat, verify;
		boolean completed = false;
		
		LogbookProgram.clearScreen();
		System.out.println("*********************************************************************");
		System.out.println("ADD NEW AIRCRAFT");
		System.out.println("*********************************************************************");
		System.out.println("Let's Enter the Aircraft's Tail Number.");
		System.out.println("Enter Aircraft Tail Number. This will be used to search so be VERY careful!");
		System.out.println("If you fly different aircraft from different countries, we suggest to skip the prefix part.");
		System.out.print("Tail Number?>> ");
		tail = input.nextLine();
		
		System.out.println();
		System.out.println("Enter Aircraft Model. This can be a code or a name.");
		System.out.print("Aircraft Model?>> ");
		model = input.nextLine();
		
		System.out.println();
		cat = checkAircraftCategory();
		
		System.out.println();
		cla = checkAircraftClass();
		
		System.out.println();
		System.out.println("Enter Aircraft attributes.");
		System.out.println("Currently supported Types are;");
		System.out.println("CPX(cpx)\tComplex");
		System.out.println("TAA(taa)\tTechnically Advanced Aircraft");
		System.out.println("TRB(trb)\tTechnically Advanced Aircraft");
		System.out.println("JET(jet)\tJet");
		System.out.println("HPF(hpf)\tHigh Performance");
		System.out.println("Separate each attributes with SINGLE space (ex. CPX TAA)");
		System.out.println("If there are no attributes, simply press enter.");
		System.out.print("Attributes?>> ");
		attr = input.nextLine();
		
		// PROCESS
		Aircraft ac = processInputs(model, tail, cat, cla, attr);
		if(ac.getCateogry() == ACCategory.AIRPLANE && ac.getType() == ACType.SINGLE_ENGINE_LAND)
			ac = (AirplaneSingleEngineLand) ac;
		else if(ac.getCateogry() == ACCategory.AIRPLANE && ac.getType() == ACType.MULTI_ENGINE_LAND)
			ac = (AirplaneMultiEngineLand) ac;
		
		System.out.println();
		System.out.println("V-----Your New Aircraft Data-----V");
		System.out.print(ac.toString());
		System.out.println("/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\");
		
		System.out.println("Is this correct? (Y/N)");
		System.out.print(">> ");
		verify = input.next().charAt(0);
		completed = false;
		
		input.nextLine();
		
		while(!completed) {
			if(verify == 'y' || verify == 'Y') {
				db.addAircraft(tail, ac);
				System.out.println("New aircraft added to the aircraft list!");
				System.out.println("Enter to continue...");
				input.nextLine();
				return true;
			}
			else if(verify == 'n' || verify == 'N') {
				System.out.println("Enter Y to start over, or N to go back to main menu.");
				System.out.print("Start Over?>> ");
				char restart = input.next().charAt(0);
				input.nextLine();
				
				if(restart == 'y' || restart == 'Y') {
					if(printFunctionAddNewAircraft()) {
						return true;
					}
					else return false;
				}
				else if(restart == 'n' || restart == 'N') {
					return false;
				}
			}
			else {
				System.out.println("Is this correct? (Y/N)");
				System.out.print(">> ");
				verify = input.next().charAt(0);
				input.nextLine();
			}
		}
		return false;
	}
	
	private Aircraft processInputs(String model, String tail, char cat, String cla, String attr) {
		Aircraft ac = null;
		LinkedList<ACAttributes> attrs = new LinkedList<ACAttributes>();
		
		// Process attributes first to process
		String[] attrlist = attr.split(" ");
		for(int i = 0; i < attrlist.length; i++) {
			if(attrlist[i].equals("CPX") || attrlist[i].equals("cpx")) { // Complex attribute
				if(!attrs.contains(ACAttributes.COMPLEX)) // Duplex check
					attrs.add(ACAttributes.COMPLEX);
			}
			else if(attrlist[i].equals("TAA") || attrlist[i].equals("taa")) { // Technically Advanced Aircraft
				if(!attrs.contains(ACAttributes.TAA)) // Duplex check
					attrs.add(ACAttributes.TAA);
			}
			else if(attrlist[i].equals("TRB") || attrlist[i].equals("trb")) { // Turbine
				if(!attrs.contains(ACAttributes.TURBINE)) // Duplex check
					attrs.add(ACAttributes.TURBINE);
			}
			else if(attrlist[i].equals("JET") || attrlist[i].equals("jet")) { // Turbine
				if(!attrs.contains(ACAttributes.JET)) // Duplex check
					attrs.add(ACAttributes.JET);
			}
			else if(attrlist[i].equals("HPF") || attrlist[i].equals("hpf")) { // Turbine
				if(!attrs.contains(ACAttributes.HIGH_PERF)) // Duplex check
					attrs.add(ACAttributes.HIGH_PERF);
			}
		}
		
		switch(cat) {
			case 'a':
			case 'A':
				if(cla.equals("sel") || cla.equals("SEL")) { // ASEL
					ac = new AirplaneSingleEngineLand(tail, model, ACCategory.AIRPLANE, ACType.SINGLE_ENGINE_LAND, attrs);
				}
				else if(cla.equals("mel") || cla.equals("MEL")) { // AMEL
					ac = new AirplaneMultiEngineLand(tail, model, ACCategory.AIRPLANE, ACType.MULTI_ENGINE_LAND, attrs);
				}
				break;
		}
		
		return ac;
	}
	
	private char checkAircraftCategory() {
		char cat = 0;
		
		while(cat != 'a') {
			System.out.println("Enter Aircraft Category.");
			System.out.println("Currently supported categories are;");
			System.out.println("A(a)\tAirplane");
			System.out.print("Category?>> ");
			cat = input.next().charAt(0);
			input.nextLine();
			
			if(cat != 'a') {
				System.out.println("Could not recognize aircraft category. Try again.\n");
			}
		}
		
		return cat;
	}
	
	private String checkAircraftClass() {
		String cla = "";
		boolean accepted = false;
		
		while(!accepted) {
			System.out.println("Enter Aircraft Class.");
			System.out.println("Currently supported Classes are;");
			System.out.println("SEL(sel)\tSingle Engine Land");
			System.out.println("MEL(mel)\tMulti-Engine Land");
			System.out.print("Class?>> ");
			cla = input.nextLine();
			
			if(cla.toLowerCase().equals("sel") || cla.toLowerCase().equals("mel"))
				accepted = true;
			else {
				System.out.println("Could not recognize aircraft class. Try again.\n");
				accepted = false;
			}
		}
		
		return cla;
	}
}
