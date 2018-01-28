//package view;
//
//import javax.swing.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Observable;
//
///**
// * @author Frederic Fauberteau
// */
//public class CLI /* TODO: make this class a View */ {
//
//    public void update(Observable o, Object arg) {
//        new SwingWorker<List<String>,String>() {
//
//            List<String> users = new ArrayList<>();
//
//            @Override
//            protected List<String> doInBackground() throws Exception {
//                String[] data; // TODO: get data
//                int index = 0;
//                while (index < data.length && ! isCancelled()) {
//                    users.add(data[index]);
//                    publish((data[index]));
//                    index++;
//                }
//                return users;
//            }
//
//            @Override
//            protected void process(List<String> chunks) {
//                for (String data : chunks) {
//                    System.out.println(data);
//                }
//            }
//
//            @Override
//            protected void done() {
//                System.out.println("---");
//            }
//
//        }.execute();
//    }
//
//}