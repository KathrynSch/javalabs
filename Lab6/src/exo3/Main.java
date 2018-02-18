/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exo3;


/**
 *
 * @author User
 */
public class Main {
    
    public static void main(String[] args){
        ///// PREVIOUS QUESTIONS
       // Seq seq = new Cons("hello", new Cons("world", new Nil()));
       // seq.forEach(t -> System.out.println(t));
       Seq seq = Seq.nil();
       Seq seq2 = seq.prepend("world").prepend("hello");
       Seq seq3 = seq2.prepend("world").prepend(3);
       seq3.forEach(System.out::println);
    }
}
