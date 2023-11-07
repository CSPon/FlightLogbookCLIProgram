package com.cs;

import java.util.Scanner;

import com.cs.data.AirplaneSingleEngineLand;

public class FunctionAddNewAircraft {
	
	private Scanner input;
	
	public FunctionAddNewAircraft(Scanner input) {
		this.input = input;
	}
	
	public boolean printFunctionAddNewAircraft() {
		String model, tail, cla;
		char cat, ls, verify;
		boolean completed = false;
		
		LogbookProgram.clearScreen();
		System.out.println("Let's Enter the Aircraft's Info First.");
		System.out.println("Enter Aircraft Model. This can be a code or a name.");
		System.out.print("Aircraft Model?>> ");
		model = input.nextLine();
		
		System.out.println();
		System.out.println("Enter Aircraft Tail Number. This will be used to search so be very careful!");
		System.out.println("If you fly different aircraft from different countries, we suggest to skip the prefix part.");
		System.out.print("Tail Number?>> ");
		tail = input.nextLine();
		
		System.out.println();
		System.out.println("Enter Aircraft Category.");
		System.out.println("Currently supported categories are;");
		System.out.println("A(a)\tAirplane");
		System.out.println("R(r)\tRotorcraft");
		System.out.print("Category?>> ");
		cat = input.next().charAt(0);
		input.nextLine();
		
		System.out.println();
		System.out.println("Enter Aircraft Class.");
		System.out.println("Currently supported Classes are;");
		System.out.println("SE(se)\tSingle Engine");
		System.out.println("ME(me)\tMulti-Engine");
		System.out.print("Class?>> ");
		cla = input.nextLine();
		
		System.out.println();
		System.out.println("Enter Aircraft Type.");
		System.out.println("Currently supported Types are;");
		System.out.println("L(l)\tLand Aircraft");
		System.out.println("S(s)\tSeaplane");
		System.out.print("Type?>> ");
		ls = input.next().charAt(0);
		input.nextLine();
		
		System.out.println();
		System.out.println("V-----This is what you entered-----V");
		if((cat == 'A' || cat == 'a') && (cla.equals("SE") || cla.equals("se")) && (ls == 'L' || ls == 'l')) {
			AirplaneSingleEngineLand asel = new AirplaneSingleEngineLand(tail, model, null);
			System.out.print(asel.toString());
		}
		System.out.println("/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\");
		
		System.out.println("Is this correct? (Y/N)");
		System.out.print(">> ");
		verify = input.next().charAt(0);
		completed = false;
		
		input.nextLine();
		
		while(!completed) {
			if(verify == 'y' || verify == 'Y') {
				System.out.println("Airplane has been added to the airplane list");
				System.out.println("Enter to continue...");
				input.nextLine();
				return true;
			}
			else if(verify == 'n' || verify == 'N') {
				System.out.println("Enter Y to start over, or N to go back to menu.");
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
}
