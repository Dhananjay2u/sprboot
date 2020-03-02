package com.dj.test.sample;

class Car 
{ 
    int model, no; 
  
    // Constructor 
    Car(int model, int no) 
    { 
        this.model = model; 
        this.no = no; 
    } 
  
    // Utility method to print Car 
    void print() 
    { 
        System.out.println("no = " + no + 
                           ", model = " + model); 
    } 
} 
  
// A class that uses Car 
class SwapEx 
{ 
    // swap() doesn't swap c1 and c2 
    public static void swap(Car c1, Car c2) 
    { 
        Car temp = c1; 
        c1 = c2; 
        c2 = temp; 
        c1.print();
        c2.print();
    } 
  
    // Driver method 
    public static void main(String[] args) 
    { 
        Car c1 = new Car(101, 1); 
        Car c2 = new Car(202, 2); 
        swap(c1, c2); 
        c1.print(); 
        c2.print(); 
    } 
} 