package mylab.student.exception;

public class InvalidGradeException extends Exception {   
    private static final long serialVersionUID = 1L;

    public InvalidGradeException() {
        super("학년은 1~4 사이여야 합니다."); 
    }
}