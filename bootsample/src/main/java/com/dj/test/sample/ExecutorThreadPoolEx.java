package com.dj.test.sample;



//Java program to illustrate 
//ThreadPool 
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService; 
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

import org.springframework.scheduling.concurrent.ForkJoinPoolFactoryBean;

import com.google.common.primitives.UnsignedBytes; 

//Task class to be executed (Step 1) 
class Task implements Runnable 
{ 
 private String name; 
 
 public Task(String s) 
 { 
     name = s; 
 } 
 
 // Prints task name and sleeps for 1s 
 // This Whole process is repeated 5 times 
 public void run() 
 { 
     try
     { 
         for (int i = 0; i<=5; i++) 
         { 
             if (i==0) 
             { 
                 Date d = new Date(); 
                 SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss"); 
                 System.out.println("Initialization Time for"
                         + " task name - "+ name +" = " +ft.format(d)); 
                 //prints the initialization time for every task 
             } 
             else
             { 
                 Date d = new Date(); 
                 SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss"); 
                 System.out.println("Executing Time for task name - "+ 
                         name +" = " +ft.format(d)); 
                 // prints the execution time for every task 
             } 
             Thread.sleep(1000); 
         } 
         System.out.println(name+" complete"); 
     } 
     
     catch(InterruptedException e) 
     { 
         e.printStackTrace(); 
     } 
 } 
} 

class AddWorker implements Callable<Integer>{

    int arr[];
    AddWorker(int arr[]){
        this.arr=arr;
    }
    @Override
    public Integer call() throws Exception {
        // TODO Auto-generated method stub
        int res=0;
        for(int k:arr) {
            res+=k;
        }
        return new Integer(res);
        
    }
}

public class ExecutorThreadPoolEx 
{ 
 // Maximum number of threads in thread pool 
 static final int MAX_T = 2;          

 public static void main(String[] args) throws InterruptedException, ExecutionException 
 { 
     // creates five tasks 
     System.out.println(System.currentTimeMillis());
     Runnable r1 = new Task("task 1"); 
     Runnable r2 = new Task("task 2"); 
     int k[]=new int [10000];
     for(int m=0;m<10000;m++) {
         k[m]=m+1;
     }
     AddWorker worker1=new AddWorker(k);
     AddWorker worker2=new AddWorker(k);
     
     // creates a thread pool with MAX_T no. of 
     // threads as the fixed pool size(Step 2) 
      ExecutorService pool = Executors.newFixedThreadPool(1); 
     
     ForkJoinPool fjPool=ForkJoinPool.commonPool();
     System.out.println(fjPool.getParallelism()+"**"+fjPool.getPoolSize());
     int d[]= {1,2,3,4,6};
     int e[]=Arrays.copyOfRange(d, 1, 3);
     for(int m:e)
         System.out.print("#"+m);
     System.out.println();
     // passes the Task objects to the pool to execute (Step 3) 
     //pool.execute(r1); 
     //pool.execute(r2); 
     System.out.println(System.currentTimeMillis());
     System.out.println(">>>>1>>"+pool.submit(worker1).get());
     System.out.println();
     System.out.println(">>>>2>>"+pool.submit(worker2).get());
     pool.shutdown();
     System.out.println(System.currentTimeMillis());
     
     MyRecursiveTask task=new MyRecursiveTask(k);
     MyRecursiveTask task2=new MyRecursiveTask(k);
     System.out.println(">>>>1>>"+fjPool.invoke(task));
     
     System.out.println(">>>>2>>"+fjPool.invoke(task2));
     // pool shutdown ( Step 4) 
     fjPool.shutdown();
     
     System.out.println(System.currentTimeMillis());
     
     int a = 60;          int b = -60;        int c = 0;
     System.out.println("60  = " + Integer.toBinaryString(a));
     System.out.println("-60 = " + Integer.toBinaryString(b));

     //signed shift
     c = a >> 3;  
     System.out.println(c);
 } 
} 

   
    
 class MyRecursiveTask extends RecursiveTask<Integer> {
     
     int arr[];

    public MyRecursiveTask(int arr[]) {
        this.arr = arr;
    }

    protected Integer compute() {

        //if work is above threshold, break tasks up into smaller tasks
        if(arr.length > 200) {
            //System.out.println("Splitting workLoad : " + this.arr);

            List<MyRecursiveTask> subtasks =
                new ArrayList<MyRecursiveTask>();
            subtasks.addAll(createSubtasks());

            for(MyRecursiveTask subtask : subtasks){
                subtask.fork();
            }

            int result = 0;
            for(MyRecursiveTask subtask : subtasks) {
                result += subtask.join();
            }
            return new Integer(result);

        } else {
            //System.out.println("Doing workLoad myself: " + this.arr);
            int res=0;
            for(int k:arr) {
                res+=k;
            }
            return new Integer(res);
        }
    }

    private List<MyRecursiveTask> createSubtasks() {
        List<MyRecursiveTask> subtasks =
        new ArrayList<MyRecursiveTask>();
        int size=arr.length;
        int newArr1Size=0;
        int newArr2Size=0;
        int arr1[],arr2[];
        
       arr1= Arrays.copyOfRange(arr, 0, (size/2));
       arr2= Arrays.copyOfRange(arr, size/2, size);
        MyRecursiveTask subtask1 = new MyRecursiveTask(arr1);
        MyRecursiveTask subtask2 = new MyRecursiveTask(arr2);

        subtasks.add(subtask1);
        subtasks.add(subtask2);

        return subtasks;
    }
}
