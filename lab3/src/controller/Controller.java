package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import model.UserList;
import view.View;
import view.GUIListener;

public class Controller implements GUIListener{

	private UserList model;
	private View view;
	/*
	 * controller has a reference to a UserList and not a Model because it has to update the model (write)
	 * has a reference to a View, which is an interface because it only needs to read the data from the view
	 */
	public Controller(UserList model, View view) {
		this.model = model;
		this.view = view;
		view.setController(this);
		this.model.addObserver(view);
	}
	
	public void start() {
		view.start();
	}

	@Override
	public ActionListener getAddUserListener(JTextField textComponent) {
		textComponent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.addUser(textComponent.getText());
            }
        });
		System.out.println(textComponent.getActionListeners().length);
		return textComponent.getActionListeners()[0];
	}
	
//	@Override
//    public ActionListener getAddUserListener(JTextComponent textComponent) {
//        return (ActionEvent ae) -> {
//            model.addUser(textComponent.getText());
//        };
//    }

}
