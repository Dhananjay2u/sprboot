package com.dj.test.sample;

//This class only accepts type parametes as any class 
//which extends class A or class A itself. 
//Passing any other type will cause compiler time error 

class Bound<T extends Z> 
{ 
 
 private T objRef; 
 
 public Bound(T obj){ 
     this.objRef = obj; 
 } 
 
 public void doRunTest(){ 
     this.objRef.displayClass(); 
 } 
} 

interface X{
     void check();
}
class XC implements X{

    @Override
    public void check() {
        // TODO Auto-generated method stub
        System.out.println("its XC");
    }
    
}
class Z
{ 
 public void displayClass() 
 { 
     System.out.println("Inside super class A"); 
 } 
} 

class B extends Z 
{ 
 public void displayClass() 
 { 
     System.out.println("Inside sub class B"); 
 } 
} 

class C extends Z
{ 
 public void displayClass() 
 { 
     System.out.println("Inside sub class C"); 
 } 
} 

public class BoundedClass 
{ 
 public static void main(String a[]) 
 { 
  // Creating object of sub class C and  
     // passing it to Bound as a type parameter. 
     Bound<C> bec = new Bound<C>(new C()); 
     bec.doRunTest(); 
       
     // Creating object of sub class B and  
     // passing it to Bound as a type parameter. 
     Bound<B> beb = new Bound<B>(new B()); 
     beb.doRunTest(); 
       
     // similarly passing super class A 
     Bound<Z> bea = new Bound<Z>(new Z()); 
     bea.doRunTest(); 
 } 
} 
