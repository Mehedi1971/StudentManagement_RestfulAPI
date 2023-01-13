package com.mahedi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mahedi.entity.Student;
import com.mahedi.repository.StudentRepository;

@RestController
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;

	@GetMapping("/")
	public String hello() {
		return "Hello World";
	}

	@GetMapping("/student")
	public List<Student> getstudentAll() {
		return studentRepository.findAll();
	}

	@GetMapping("/student/{id}")
	public Optional<Student> getstudent(@PathVariable long id) {
		return studentRepository.findById(id);
	}

	@PostMapping("/student/add")
	public Student addstudent(@RequestBody Student student) {
		return studentRepository.save(student);
	}

	@PutMapping("/student/update")
	public Student updatestudent(@RequestBody Student student) {
		return studentRepository.save(student);
	}

	@DeleteMapping("/student/delete/{id}")
	public String deletestudent(@PathVariable long id) {
		studentRepository.deleteById(id);
		return "Success!!!";
	}
}
