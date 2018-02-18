/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exo2_1;

import java.util.Random;
/**
 *
 * @author User
 */
public class Exo2 {
    
    public static void main(String[] args) {
        
        final Random random = new Random();
        System.out.println("Result= "+ random.ints(1,100).limit(1000).average());
    }
    
}   
