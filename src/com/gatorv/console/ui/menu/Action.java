package com.gatorv.console.ui.menu;

import java.io.InputStream;
import java.io.PrintStream;

public interface Action {
	public void doAction(PrintStream out, InputStream in);
}
