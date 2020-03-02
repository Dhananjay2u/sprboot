package com.dj.test.sample;

import java.io.FileNotFoundException;
import java.io.IOException;

interface one 
{ 
    public void print_geek(); 
} 

interface one1 
{ 
    public default void print_geek() {
        
    }
} 

interface two 
{ 
    public void print_for(); 
} 
   
interface three extends one,two 
{ 
    public void print_geek(); 
} 
class child implements three 
{ 
    @Override
    public void print_geek() { 
        System.out.println("Geeks"); 
    } 
   
    public void print_for() 
    { 
        System.out.println("for"); 
    } 
} 

class abc implements one,one1{

    @Override
    public void print_geek() {
        // TODO Auto-generated method stub
        one1.super.print_geek();
    }

}

class Fruit 
{ 
    public Fruit() 
    { 
        System.out.println("Super class constructor"); 
        System.out.println("Super class object hashcode :" + 
                           this.hashCode()); 
        System.out.println(this.getClass().getName()); 
    }
    public Number getNumber() throws NullPointerException, IOException {
        return null;
        
    }
    
} 
  
// sub class 
class Apple extends Fruit 
{ 
    public Apple() 
    { 
        System.out.println("Subclass constructor invoked"); 
        System.out.println("Sub class object hashcode :" + 
                           this.hashCode()); 
        System.out.println(this.hashCode() + "   " + 
                           super.hashCode()); 
  
        System.out.println(this.getClass().getName() + "  " + 
                           super.getClass().getName()); 
    }

    @Override
    public Number getNumber() throws FileNotFoundException {
        // TODO Auto-generated method stub
        return 3;
    }

    @Override
    protected Apple clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        return (Apple)super.clone();
    } 
    
    
} 

public class InheritEx {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Apple myApple = new Apple();
        
    }

}
