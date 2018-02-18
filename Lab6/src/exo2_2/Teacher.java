/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exo2_2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author User
 */
public class Teacher {
    
    private final String name;
    private final Gender gender;
    
    public Teacher (String name, Gender gender){
        this.name = name;
        this.gender = gender;
    }
    
    public Gender getGender(){
        return this.gender;
    }
    public String getName(){
        return this.name;
    }

    public static void main(String[] args) {
        
        Map<Gender, List<Teacher>> myMap = Stream.of(new Teacher("Ravaut", Gender.MALE),
                  new Teacher("Soukane", Gender.FEMALE),
                  new Teacher("Palasi", Gender.FEMALE),
                  new Teacher("Segado", Gender.MALE),
                  new Teacher("Diedler", Gender.MALE)
                ).collect(Collectors.groupingBy(Teacher::getGender));
        
        for (Map.Entry<Gender, List<Teacher>> entry : myMap.entrySet())
        {
            System.out.println(entry.getKey() + ":");
            for(Teacher t : entry.getValue()){
                System.out.println("\t" +t.getName());
            }
        }
        
    }
    
    public enum Gender {
    MALE,
    FEMALE
}

}



