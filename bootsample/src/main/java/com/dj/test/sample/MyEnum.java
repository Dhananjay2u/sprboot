package com.dj.test.sample;

public enum MyEnum {
    
    A {
        @Override
        public void abMethod() {
            System.out.println("overridden method of abstract method of enum for A");
        }
    },B {
        @Override
        public void abMethod() {
            System.out.println("overridden method of abstract method of enum for B");
        }
    };
    MyEnum(){
        System.out.println("Enum Constructor");
    }
    
    public void display() {
        System.out.println("its display method from MyEnum");
    }
    public abstract void abMethod();

    public static void main(String args[]) {
        MyEnum.A.display();
        MyEnum.A.abMethod();
    }
}
