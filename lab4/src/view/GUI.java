package view;


import javax.swing.*;

import model.Model;
import model.UserList;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Observable;

/**
 * @author Frederic Fauberteau
 */
public class GUI extends AbstractView implements View{

    private final JFrame frame;
    private JList<String> list = new JList<>();

    public GUI(Model model, String title, int width, int height) {
    	super(model);
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void configJMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        menuBar.add(fileMenu);
        JMenuItem quitItem = new JMenuItem("Quit");
        quitItem.setMnemonic(KeyEvent.VK_Q);
        quitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        fileMenu.add(quitItem);
        frame.setJMenuBar(menuBar);
    }

    private void configJPanel() {
        JPanel panel = new JPanel();
        frame.getContentPane().add(panel);
        panel.setLayout(new BorderLayout());
        final JTextField textField = new JTextField();
        textField.addActionListener(this.getController().getAddUserListener(textField));
        panel.add(textField, BorderLayout.PAGE_START);
        panel.add(list, BorderLayout.CENTER);
    }

    @Override
    public void start() {
        configJMenuBar();
        configJPanel();
        frame.setVisible(true);
    }
    
	

	@Override
	public void update(Observable arg0, Object arg1) {
		if(arg0 instanceof UserList) {
			DefaultListModel<String> userListTemp = new DefaultListModel<>();
			for(String str : getModel().getData()) {
				userListTemp.addElement(str);
				list.setModel(userListTemp);
			}
		}
		else if(arg0 instanceof Model) {
			if(arg1 instanceof JList) {
				list = (JList) arg1;
			}
		}
	}

}