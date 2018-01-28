package view;

import javax.swing.*;

import model.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * @author Frederic Fauberteau
 */
public class CLI extends AbstractView {

    public CLI(Model model) {
		super(model);
	}

	public void update(Observable o, Object arg) {
        new SwingWorker<List<String>,String>() {

            List<String> users = new ArrayList<>();

            @Override
            protected List<String> doInBackground() throws Exception {
                String[] data = getModel().getData();
                int index = 0;
                while (index < data.length && ! isCancelled()) {
                    users.add(data[index]);
                    publish((data[index]));
                    index++;
                }
                return users;
            }

            @Override
            protected void process(List<String> chunks) {
                for (String data : chunks) {
                    System.out.println(data);
                }
            }

            @Override
            protected void done() {
                System.out.println("---");
            }

        }.execute();
    }

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

}