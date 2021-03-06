package controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import controller.Controller;
import model.UserList;
import view.GUI;
import view.CLI;
import view.View;

public class Main2 {

	public static void main(String[] args) {
		 
		UserList model = new UserList();
		GUI gui = new GUI(model,"Lab3", 320,240);
		CLI cli = new CLI(model);
		Set<View> set = new HashSet<>(Arrays.asList(gui,cli));
		Controller controller = new Controller(model,set);
		controller.start();
		model.addUser("triaxx");
		model.addUser("violine");
		model.addUser("root");
	}
}
