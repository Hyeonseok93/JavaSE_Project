package mylab.student.control;
import mylab.student.entity.Student;
import mylab.student.exception.InvalidGradeException;

public class StudentTest {
    public static void main(String[] args) {
        try {
            Student std = new Student("김민수", "컴퓨터공학", 3);
            
            System.out.println(std.getName() + "/" + std.getMajor() + "/" + std.getGrade() + "학년");

            int newGrade = 5; 
            System.out.println(newGrade + "학년으로 변경"); 
            std.setGrade(newGrade); 
            
        } catch (InvalidGradeException e) {
            System.out.println(e.getMessage()); 
        }
    }
}