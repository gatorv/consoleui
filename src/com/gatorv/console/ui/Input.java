package com.gatorv.console.ui;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Input {
	private String errorMessage = "that is not a valid input!";
	private InputStream reader;
	private PrintStream writer;
	private Scanner scan;
	
	private static Input singleton;
	
	public static Input getInstance() {
		if (singleton == null) {
			singleton = new Input();
		}
		
		return singleton;
	}
	
	public static void setInstance(Input instance) {
		singleton = instance;
	}
	
	public Input(PrintStream writer, InputStream reader) {
		setWriter(writer);
		setReader(reader);
		
		scan = new Scanner(reader);
	}
	
	public Input() {
		setWriter(System.out);
		setReader(System.in);
		
		scan = new Scanner(reader);
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public InputStream getReader() {
		return reader;
	}

	public void setReader(InputStream reader) {
		this.reader = reader;
	}

	public PrintStream getWriter() {
		return writer;
	}

	public void setWriter(PrintStream writer) {
		this.writer = writer;
	}
	
	public int getNumber(String label) {
		int input;
		writer.print(label);
		while (!scan.hasNextInt()) {
			writer.println(getErrorMessage());
			scan.next();
		}
		input = scan.nextInt();
		
		return input;
	}
	
	public String getText(String label) {
		String input;
		writer.print(label);
		input = scan.next();
		
		return input;
	}
	
	public Double getDouble(String label) {
		Double input;
		writer.print(label);
		while (!scan.hasNextDouble()) {
			writer.println(getErrorMessage());
			scan.next();
		}
		input = scan.nextDouble();
		
		return input;
	}
	
	public static int readNumber() {
		return getInstance().getNumber("Enter a number: ");
	}
	
	public static int readNumber(String label) {
		return getInstance().getNumber(label);
	}
	
	public static String readText() {
		return getInstance().getText("Enter some text: ");
	}
	
	public static String readText(String label) {
		return getInstance().getText(label);
	}
	
	public static Double readDouble() {
		return getInstance().getDouble("Enter a number: ");
	}
	
	public static Double readDouble(String label) {
		return getInstance().getDouble(label);
	}
}
