package com.gatorv.console.ui.menu;

public class Option {
	private String menuLabel;
	private Action menuAction;

	public Option(String label, Action menuAction) {
		setMenuLabel(label);
		setMenuAction(menuAction);
	}

	public String getMenuLabel() {
		return menuLabel;
	}

	public void setMenuLabel(String menuLabel) {
		this.menuLabel = menuLabel;
	}

	public Action getMenuAction() {
		return menuAction;
	}

	public void setMenuAction(Action menuAction) {
		this.menuAction = menuAction;
	}

}
