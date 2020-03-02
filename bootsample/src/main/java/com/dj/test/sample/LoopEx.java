package com.dj.test.sample;

public class LoopEx {

    public static void main(String[] args) {

        int i=0;
        abc:
        do{
            System.out.println("I : "+i);
            xyz:
            for(int j=0;j<5;j++) {
                System.out.println("J : "+j);    
                if(j==2) {
                    i=5;
                    continue abc;
                }
                System.out.println(">>>>>");
                System.out.println(">>>>>");
                
            }
            i++;
        }while(i<5);
    }

}
