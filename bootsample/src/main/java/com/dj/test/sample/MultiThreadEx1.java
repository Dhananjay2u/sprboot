package com.dj.test.sample;

class Jbc{
    String name="abc";
    static String address="address";
    public  void display() throws InterruptedException {
        //synchronized (address) {
            for(int i=0;i<10;i++) {
                System.out.print(i+Thread.currentThread().getName()+":");
                //Thread.sleep(1000L);
            }
        //}
        
    }
}

class StudentThread extends Thread
{
    Jbc obj=new Jbc();
    @Override
    public void run() {
        for(int k=0;k<1;k++) {
            System.out.println("Student is reading...");
            try {
                //Thread.sleep(1000L);
               obj.display();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("child Thread is ending"+Thread.currentThread().getThreadGroup());
        Thread ch=Thread.currentThread();
        System.out.println(ch.getId()+">>"+ch.activeCount()+">>>"+ch.getState()+"<<<"+ch.isAlive());
       
       
    }
}

public class MultiThreadEx1 {

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub
        StudentThread t1=new StudentThread();
        StudentThread t2=new StudentThread();
        //t2.obj=t1.obj;
        t1.start();
        t1.join();
        t2.start();
        
        System.out.println("Main Thread is ending"+Thread.currentThread().getThreadGroup());
        System.out.println(t1.isAlive());
    }

}
