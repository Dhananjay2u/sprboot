package com.dj.test.sample;

class A{
    static int k;
    static {
        k=20;
    }
    int num;
    A(){
       num=10; 
    }
    static void check() {
        System.out.println("its static check");
    }
}
public class InstanceVarHiding  extends A{
    static int k;
    static {
        k=30;
    }
    int getstaticK() {
        return super.k;
    }
    int num;
    InstanceVarHiding(){
        num=20;
    }
    static void check() {
        System.out.println("its static check at child class");
    }
    public int getVal() {
        int num=30;
        System.out.println("this.num:"+this.num+":super.num:"+super.num+":local.num:"+num);
        return super.num;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        InstanceVarHiding obj=new InstanceVarHiding();
        System.out.println(obj.num);
        System.out.println(obj.getVal());
        System.out.println(obj.k+">>"+obj.getstaticK());
        InstanceVarHiding.check();
    }

}
