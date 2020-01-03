package com.dj.boot.student.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentVersionController {

    @GetMapping(path = "/v1/getStudent")
    public Student getStudent()
    {
        return new Student("Dhananjay Kumar");
    }
    @GetMapping(path = "/v2/getStudent")
    public StudentV2 getStudentV2()
    {
        return new StudentV2(new Name("Dhananjay", "Kumar"));
    }
    
    @GetMapping(path = "/getStudent", params = "version=1")
    public Student getStudentQuery()
    {
        return new Student("Dhananjay Kumar");
    }
    @GetMapping(path = "/getStudent", params = "version=2")
    public StudentV2 getStudentQueryV2()
    {
        return new StudentV2(new Name("Dhananjay", "Kumar"));
    }
    
    @GetMapping(path = "/getStudentHeader", headers = "version=1")
    public Student getStudentHeader()
    {
        return new Student("Dhananjay Kumar");
    }
    @GetMapping(path = "/getStudentHeader", headers = "version=2")
    public StudentV2 getStudentHeaderV2()
    {
        return new StudentV2(new Name("Dhananjay", "Kumar"));
    }
    
    @GetMapping(path = "/getStudentProduce", produces = "application/abcv1+json")
    public Student getStudentProduce()
    {
        return new Student("Dhananjay Kumar");
    }
    @GetMapping(path = "/getStudentProduce", produces = "application/abcv2+json")
    public StudentV2 getStudentProduceV2()
    {
        return new StudentV2(new Name("Dhananjay", "Kumar"));
    }
}
