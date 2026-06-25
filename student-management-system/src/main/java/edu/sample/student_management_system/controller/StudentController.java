package edu.sample.student_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.sample.student_management_system.entity.Student;
import edu.sample.student_management_system.service.StudentService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/students")
public class StudentController {

	@Autowired
	public StudentService stdService;
	
	@PostMapping
	public Student insert(@Valid @RequestBody Student student) {
		return stdService.add(student);
	}
	@GetMapping
	public List<Student> getAllStudent() {
		return stdService.getAll();
	}
	@GetMapping("/getById/{id}")
	public Student getById(@PathVariable Long id) {
		return stdService.getById(id);
	}
	@GetMapping("/getByEmail/{email}")
	public Student getByEmail(@PathVariable String email) {
		return stdService.getByEmail(email);
	}
	@DeleteMapping("/{id}")
	public String removeById(@PathVariable Long id) {
		stdService.removeById(id);
		return "Student deleted successfully";
	}
	
	@PutMapping("/{id}")
	public Student updateById(@PathVariable Long id, @RequestBody Student student) {
		return stdService.updateById(id,student);
	}
}
