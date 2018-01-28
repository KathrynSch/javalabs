package view;

import java.awt.event.ActionListener;

import javax.swing.JTextField;

public interface GUIListener {

	ActionListener getAddUserListener(JTextField textComponent);
}
