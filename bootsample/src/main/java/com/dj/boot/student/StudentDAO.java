package com.dj.boot.student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class StudentDAO {
	
	private static List<Student> studentList=new ArrayList<>();
	
	static {
		studentList.add(new Student("1","Ram"));
		studentList.add(new Student("2","Shyam"));
		studentList.add(new Student("3","Kishan"));
	}
	
	public List<Student> getAllStudents(){
		return studentList;
	}
	Student temp;
	public Student getStudent(String id) {
		temp=null;
		studentList.forEach((std)->{
				if(std.getId().equals(id))
					temp=std;
		});
		if (temp == null) {
				throw new StudentNotFoundException("Given studentid is not found.");
		}
		return temp!=null?temp:null;
	}
	
	public boolean addStudent(Student std) {
		return studentList.add(std);
	}
	
	public Student deleteStudent(String id) {
		
		Iterator<Student> it= studentList.iterator();
		while(it.hasNext()) {
			Student std=it.next();
			if(std.getId().equals(id)) {
				it.remove();
				return std;
			}
		}
		throw new StudentNotFoundException("Given studentid is not found.");
	}
}
