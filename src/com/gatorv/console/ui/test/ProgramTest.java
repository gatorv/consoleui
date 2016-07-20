package com.gatorv.console.ui.test;

import java.io.PrintStream;
import java.io.InputStream;

import com.gatorv.console.ui.Input;
import com.gatorv.console.ui.Program;
import com.gatorv.console.ui.menu.Action;
import com.gatorv.console.ui.menu.Option;

public class ProgramTest {

	public static void main(String[] args) {
		Program p = new Program(System.out, System.in);
		p.addOption(new Option("Choice 1", new Action() {
			public void doAction(PrintStream out, InputStream in) {
				String something = Input.readText("Give me some text: ");
				out.format("%s\n\n", something);
			}
		}));
		p.addOption(new Option("Choice 2", new Action() {
			public void doAction(PrintStream out, InputStream in) {
				out.println("Choice 2");
			}
		}));
		
		p.run();
	}

}
