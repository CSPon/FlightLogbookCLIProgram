package com.cs;

import java.io.IOException;
import java.util.Scanner;

public class LogbookProgram {
	
	private Scanner input;
	
	private FunctionAddNewAircraft fana;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		LogbookProgram process = new LogbookProgram(input);
		process.startProcess();
	}
	
	public LogbookProgram(Scanner input)
	{
		this.input = input;
		fana = new FunctionAddNewAircraft(input);
	}
	
	private void printMainMenu() {
		System.out.println("*********************************************************************");
		System.out.println("CLI Logbook Program");
		System.out.println("*********************************************************************");
		System.out.println("1. Add New Aircraft");
		System.out.println("2. Remove Existing Aircraft");
		System.out.println("0. Exit Program");
		System.out.println("*********************************************************************");
		System.out.print(">> ");
	}
	
	public void startProcess()
	{
		printMainMenu();
		
		int command = input.nextInt();
		input.nextLine();
		
		while(command != 0) // Exit command entered?
		{
			switch(command) {
				case 1:
					fana.printFunctionAddNewAircraft();
					printMainMenu();
					command = input.nextInt();
					input.nextLine();
					break; // End of new aircraft
					
				default:
					System.out.println("Unknown or unsupported command. Try another command...");
					printMainMenu();
					command = input.nextInt();
					input.nextLine();
					break; // End of default
			}
		}
		
		// End of program (The exit part)
		System.out.println("End of Program");
		input.nextLine();
		input.close();
	}
	
	public static void clearScreen() {
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		}
		catch(IOException ioe) {
			
		}
		catch(InterruptedException ire) {
			
		}
	}
}
