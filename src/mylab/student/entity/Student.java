package mylab.student.entity;
import mylab.student.exception.InvalidGradeException;

public class Student {  
    private String studentId;
    private String name;
    private String major;
    private int grade;

    public Student(String name, String major, int grade) throws InvalidGradeException {
        this.name = name;
        this.major = major;
        setGrade(grade);
    }
 
    // studentId
    public void setStudentId(String studentId) { 
    	this.studentId = studentId;
    }
    public String getStudentId() { 
    	return studentId; 
    }

    // name
    public void setName(String name) { 
    	this.name = name;
    }
    public String getName() { 
    	return name; 
    }

    // major
    public void setMajor(String major) { 
    	this.major = major;
    }
    public String getMajor() { 
    	return major;
    }

    // grade
    public void setGrade(int grade) throws InvalidGradeException {
        if (grade < 1 || grade > 4) {
            throw new InvalidGradeException();
        }
        this.grade = grade;
    }
    public int getGrade() { 
    	return grade;
    }
}
