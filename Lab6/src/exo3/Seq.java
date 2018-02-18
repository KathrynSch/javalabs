/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exo3;

import java.util.Objects;
import java.util.function.Consumer;

/**
 *
 * @author User
 * @param <T>
 */
public interface Seq<T> {
    
    void forEach(Consumer<T> action);
    
    public static Seq nil(){
        return new Nil();
    }

    public default Seq prepend(T element){
        return new Cons(element, this);
    }
    
    static class Cons<T> implements Seq<T>{
    
        private final T element;
        private final Seq next;
        

        public Cons(T element, Seq next){
            this.element = Objects.requireNonNull(element);
            this.next = Objects.requireNonNull(next);
        }

        @Override
        public String toString(){
            return this.element.toString();
        }

        @Override
        public void forEach(Consumer consumer) {
            consumer.accept(this);
            next.forEach(consumer);
        }
    }
    

    static class Nil<T> implements Seq<T> {
    
        public Nil(){
        }
        @Override
        public void forEach(Consumer consumer) {
           // do nothing
        }
    }
}
