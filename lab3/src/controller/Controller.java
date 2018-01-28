package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import model.UserList;
import view.View;
import view.GUIListener;

public class Controller implements GUIListener{

	private UserList model;
	private Set<View> viewSet;
	/*
	 * controller has a reference to a UserList and not a Model because it has to update the model (write)
	 * has a reference to a View, which is an interface because it only needs to read the data from the view
	 */
	public Controller(UserList model, Set<View> viewSet) {
		this.model = model;
		this.viewSet = viewSet;
		for(View view : viewSet) {
			view.setController(this);
			this.model.addObserver(view);
		}
		
	}
	
	public void start() {
		for(View view : viewSet) {
			view.start();
		}
	}

	@Override
	public ActionListener getAddUserListener(JTextField textComponent) {
		textComponent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.addUser(textComponent.getText());
            }
        });
		return textComponent.getActionListeners()[0];
	}
	

}
