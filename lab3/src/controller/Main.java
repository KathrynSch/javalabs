package controller;

import controller.Controller;
import model.UserList;
import view.GUI;

public class Main {

	public static void main(String[] args) {
		UserList model = new UserList();
		GUI gui = new GUI(model, "Lab3", 320,240);
		Controller controller = new Controller(model, gui);
		Controller.start();
	}
}
