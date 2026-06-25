package edu.sample.student_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sample.student_management_system.Exception.StudentNotFoundException;
import edu.sample.student_management_system.entity.Student;
import edu.sample.student_management_system.repository.studentRepositary;

@Service
public class StudentService {

	@Autowired
	private studentRepositary stdRepo;
	
	//insert
	public Student add(Student student) {
		return stdRepo.save(student);
	}
	//List all
	public List<Student> getAll(){
		return stdRepo.findAll();
	}
	//deletebyId
	public void removeById(Long id) {
		 
		if(!stdRepo.existsById(id)) {
			throw new StudentNotFoundException("Student not found with id: "+id);
		}
		stdRepo.deleteById(id);
	}
	//find by id
	public Student getById(Long id) {
		return stdRepo.findById(id).orElseThrow(()->new StudentNotFoundException("student not found with id "+id));
	}
	
	//update
	public Student updateById(Long id,Student updateStudent) {
		Student existing_object=stdRepo.findById(id).orElseThrow(()->new StudentNotFoundException("student not found with id "+id));
		existing_object.setFirstName(updateStudent.getFirstName());
		existing_object.setLastName(updateStudent.getLastName());
		existing_object.setEmail(updateStudent.getEmail());
		existing_object.setDepartment(updateStudent.getDepartment());
		existing_object.setPhoneNumber(updateStudent.getPhoneNumber());
		existing_object.setPercentage(updateStudent.getPercentage());
		return stdRepo.save(existing_object);
	}
	//find by email
	public Student getByEmail(String email) {
		Student studentWithEmail=stdRepo.findByEmail(email);
		if(studentWithEmail==null) {
				new StudentNotFoundException("student not found with email "+email);
		} 
		return studentWithEmail;
	}
}

