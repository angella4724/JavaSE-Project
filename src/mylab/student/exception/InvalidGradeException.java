package mylab.student.exception;

public class InvalidGradeException extends Exception{

	public InvalidGradeException(String message) {
		//부모 클래스의 생성자를 호출한다.
		super(message);
	}
	

}
