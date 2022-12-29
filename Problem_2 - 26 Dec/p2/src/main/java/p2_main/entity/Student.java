package cshyb_main.entity;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int studentRoll;
	
	private String studentName; 
	private long mobileNumber ;
	private String email; 
	@ManyToOne(cascade = CascadeType.ALL)
	private Collage collage;
	
	public Student() {}

	public Student(int studentRoll, String studentName, long mobileNumber, String email) {
		super();
		this.studentRoll = studentRoll;
		this.studentName = studentName;
		this.mobileNumber = mobileNumber;
		this.email = email;
	}

	public int getStudentRoll() {
		return studentRoll;
	}

	public void setStudentRoll(int studentRoll) {
		this.studentRoll = studentRoll;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

	@Override
	public String toString() {
		return "Student [studentRoll=" + studentRoll + ", studentName=" + studentName + ", mobileNumber=" + mobileNumber
				+ ", email=" + email + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, mobileNumber, studentName, studentRoll);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(email, other.email) && mobileNumber == other.mobileNumber
				&& Objects.equals(studentName, other.studentName) && studentRoll == other.studentRoll;
	}
	
	

}
