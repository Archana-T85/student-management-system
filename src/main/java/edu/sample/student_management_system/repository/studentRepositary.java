package edu.sample.student_management_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.sample.student_management_system.entity.Student;

@Repository
public interface studentRepositary extends JpaRepository<Student,Long>{

	//save(student)
	//findAll()
	//findById(Id)
	//deleteById(Id)
	//existsById(Id)
	
	Student findByEmail(String email);
	List<Student> findByFirstName(String firstName);
}

