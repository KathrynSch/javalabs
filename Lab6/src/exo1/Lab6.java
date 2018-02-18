/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exo1;

import java.util.TreeSet;

/**
 *
 * @author User
 */
public class Lab6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Thread thread = new Thread(() -> System.out.println("Hello World"));
        thread.start();
        // with lambda 
        TreeSet<String> treeSet = new TreeSet<>((String s1,String s2) -> s1.compareTo(s2));
        // with method reference
        TreeSet<String> treeSet2 = new TreeSet<>(String::compareTo);
    }
    
}
