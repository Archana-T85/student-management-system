package edu.sample.student_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sample.student_management_system.DTO.StudentRequestDto;
import edu.sample.student_management_system.DTO.StudentResponseDto;
import edu.sample.student_management_system.Exception.StudentNotFoundException;
import edu.sample.student_management_system.entity.Student;
import edu.sample.student_management_system.repository.studentRepositary;

@Service
public class StudentService {

	@Autowired
	private studentRepositary stdRepo;
	
	//insert
	public StudentResponseDto add(StudentRequestDto studentReqDto) {
		Student student=new Student();
		student.setFirstName(studentReqDto.getFirstName());
		student.setLastName(studentReqDto.getLastName());
		student.setEmail(studentReqDto.getEmail());
		student.setDepartment(studentReqDto.getDepartment());
		student.setPhoneNumber(studentReqDto.getPhoneNumber());
		student.setPercentage(studentReqDto.getPercentage());
		Student savedStudent=stdRepo.save(student);
		StudentResponseDto studentResDto=new StudentResponseDto();
		studentResDto.setStudentId(savedStudent.getStudentId());
		studentResDto.setFirstName(savedStudent.getFirstName());
		studentResDto.setLastName(savedStudent.getLastName());
		studentResDto.setEmail(savedStudent.getEmail());
		studentResDto.setDepartment(savedStudent.getDepartment());
		studentResDto.setPercentage(savedStudent.getPercentage());
		return studentResDto;
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

