package com.dj.test.sample;

import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.IntPredicate;
import java.util.stream.Stream;

import org.springframework.data.util.Pair;

class Alpha  
{ 
    static String s = " "; 
    protected Alpha()  
    { 
        s += "alpha "; 
    } 
    static void display() {
        
    }
} 
class SubAlpha extends Alpha  
{ 
    private SubAlpha()  
    { 
        s += "sub "; 
    } 
} 
  
class Sample extends Alpha  
{ 
    private Sample()  
    { 
        s += "subsub "; 
    } 
    public static void main(String[] args)  
    { 
        new Sample(); 
        System.out.println(Sample.s); 
        System.out.println(("a".compareTo("ABC")));
        System.out.println("ab#c".chars().allMatch(new IntPredicate() {
            
            @Override
            public boolean test(int value) {
                // TODO Auto-generated method stub
                return Character.isLetter(value);
            }
        }));
        System.out.println("abc".matches("[a-zA-Z]*"));
        Integer a[]= {1,2};Integer b[]= {1,2};
        
        Stream.concat(Arrays.stream(a),  
                Arrays.stream(b)) 
        .toArray(); 
        
        Pair<String, Integer> pair=Pair.of("abc", 20);
        try {
            String abc="abc";
            abc.charAt(6);
            
        }
        catch(RuntimeException ex) {
            System.out.println("exception");
        }
        finally {
            System.out.println("finally");
        }
        System.out.println(pair.getFirst());
        
        LinkedBlockingQueue<Integer> abq 
        = new LinkedBlockingQueue<Integer>(); 

    // add  numbers 
    abq.add(1); 
    abq.add(2); 
    abq.add(null); 
    System.out.println(">>>>"+abq.toArray()[2]);
    } 
}