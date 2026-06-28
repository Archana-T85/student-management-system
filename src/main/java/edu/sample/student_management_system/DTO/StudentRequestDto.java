package edu.sample.student_management_system.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class StudentRequestDto {

	@NotBlank(message="Name cannot be empty")
	private String firstName;
	private String lastName;
	@Email(message="Invalid email format")
	@NotBlank(message="Email cannot be empty")
	private String email;
	@NotBlank
	@Pattern(regexp="^[0-9]{10}$",message="Phone number must contain 10 digits")
	private String phoneNumber;
	@NotBlank(message="department is required")
	private String department;
	@NotNull(message="percentag is not empty")
	@Min(value=0,message="percentage cannot be less than 0")
	@Max(value=100,message="percentage cannot be greater than 100")
	private Long percentage;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Long getPercentage() {
		return percentage;
	}
	public void setPercentage(Long percentage) {
		this.percentage = percentage;
	}
	
	
}
