package com.dj.test.sample;

class A{
    int num;
    A(){
       num=10; 
    }
}
public class InstanceVarHiding  extends A{
    int num;
    InstanceVarHiding(){
        num=20;
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
        
    }

}
