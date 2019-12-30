package com.dj.boot.student;

import java.net.URI;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.web.ProjectedPayload;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dj.boot.bootsample.BootsampleApplication;

@RestController
public class StudentController {
	@Autowired
	StudentDAO dao;
	
	@Autowired
	MessageSource messageSource;

	@RequestMapping(method=RequestMethod.GET, path="/sayHello")
	public String sayHello() {
		return "Hello! Dear";
	}
	
	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World";
	}

	@GetMapping(path = "/hello-world/{name}")
	public String helloWorldwithName(@PathVariable String name) {
		return "Hello World "+name;
	}
	
	@GetMapping(path = "/students")
	public List<Student> getStudents() {
		return dao.getAllStudents();
	}
	@GetMapping(path = "/students/{id}")
	public Resource<Student> getStudents(@PathVariable String id) {
		Student std= dao.getStudent(id);
		Resource<Student> student=new Resource<Student>(std);
		//ControllerLinkBuilder link=ControllerLinkBuilder.linkTo(this.getClass());-- referring host link
		//ControllerLinkBuilder link=ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).getStudents(id));
		ControllerLinkBuilder link=ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).getStudents());
		student.add(link.withRel("all-students"));
		return student;
		
	}
	@PostMapping(path = "/students")
	public ResponseEntity<Object> addStudent(@Valid @RequestBody Student std) {
		
		dao.addStudent(std);
		//URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/"+std.getId()).build().toUri();
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(std.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	@DeleteMapping(path="/students/{id}")
	public void deleteStudent(@PathVariable String id) {
		Student std=dao.deleteStudent(id);
		if(std!=null)
			ResponseEntity.noContent().build();
	}
	
	
	@GetMapping(path = "/salutation")
	public String getSalutation(@RequestHeader(name="Accept-Language", required=false) Locale locale ) {
		System.out.println("<<<<<<<<<<<<<<<<<");
		//BootsampleApplication app=new BootsampleApplication();
		//messageSource=app.bundleMessageSource();
		return messageSource.getMessage("hello.world",null, locale);
	}
	
	@GetMapping(path = "/salutation1")
	public String getSalutation1() {
		System.out.println("<<<<<<<<<<<<<<<<<");
		//BootsampleApplication app=new BootsampleApplication();
		//messageSource=app.bundleMessageSource();
		return messageSource.getMessage("hello.world",null, LocaleContextHolder.getLocale());
	}
}
