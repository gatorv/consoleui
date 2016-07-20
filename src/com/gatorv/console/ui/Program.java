package com.gatorv.console.ui;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import com.gatorv.console.ui.menu.Action;
import com.gatorv.console.ui.menu.Option;

public class Program {
	private String menuInputLabel;
	private ArrayList<Option> menuOptions;
	private PrintStream writer;
	private InputStream reader;
	private Boolean isRunning;
	
	public Program(PrintStream writer, InputStream reader) {
		this.setWriter(writer);
		this.setReader(reader);
		
		menuInputLabel = "Select menu option: ";
		menuOptions = new ArrayList<Option>();
		isRunning = false;
	}

	public PrintStream getWriter() {
		return writer;
	}

	public void setWriter(PrintStream writer) {
		this.writer = writer;
	}
	
	public InputStream getReader() {
		return reader;
	}

	public void setReader(InputStream reader) {
		this.reader = reader;
	}

	public String getMenuInputLabel() {
		return menuInputLabel;
	}

	public void setMenuInputLabel(String menuInputLabel) {
		this.menuInputLabel = menuInputLabel;
	}

	public void addOption(Option option) {
		this.menuOptions.add(option);
	}
	
	public int getUserOption() {
		return Input.readNumber(getMenuInputLabel());
	}
	
	private void drawMenu() {
		int num = 1;
		for (Option o : this.menuOptions) {
			writer.format("%d - %s\n", num, o.getMenuLabel());
			num++;
		}
	}
	
	private void processMenu() {
		int choice = getUserOption();
		
		if (choice == 0 || choice > menuOptions.size()) {
			writer.format("Option %d is not valid\n", choice);
			return;
		}
		
		Option menuOption = menuOptions.get(--choice);
		menuOption.getMenuAction().doAction(writer, reader);
	}
	
	public void run() {
		addOption(new Option("Exit", new Action() {
			public void doAction(PrintStream out, InputStream in) {
				isRunning = false;
			}
		}));
		isRunning = true;
		
		do {
			drawMenu();
			processMenu();
		} while (isRunning == true);
	}
}
