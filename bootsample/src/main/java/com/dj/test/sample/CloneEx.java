package com.dj.test.sample;

class Student implements Cloneable{
    String name;
    Department dept;
    @Override
    protected Object clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        Student clStd=(Student)super.clone();
        clStd.dept=(Department)clStd.dept.clone();
        return clStd;
    }
    
}
class Department implements Cloneable{
    String name;
    Subject sub;
    @Override
    protected Object clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        Department clDept=(Department)super.clone();
        clDept.sub=(Subject)clDept.sub.clone();
        return clDept;
    }
    
}
class Subject implements Cloneable{
    String name;
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
}
public class CloneEx {

    public static void main(String[] args) {
        Subject sub1=new Subject();
        sub1.name="IT";
        Department d1=new Department();
        d1.name="CS";
        d1.sub=sub1;
        Student std1=new Student();
        std1.name="AA";
        std1.dept=d1;
        System.out.println(std1.name+":"+std1.dept.name+":"+std1.dept.sub.name);
        
        try {
            Student std2=(Student)std1.clone();
            std2.name="BB";
            std2.dept.name="Civil";
            std2.dept.sub.name="CivilEng";
            System.out.println(std2.name+":"+std2.dept.name+":"+std1.dept.sub.name);
        } catch (CloneNotSupportedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(std1.name+":"+std1.dept.name+":"+std1.dept.sub.name);

    }

}
