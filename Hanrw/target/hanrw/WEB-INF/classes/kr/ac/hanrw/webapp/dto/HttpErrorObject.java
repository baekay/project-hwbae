package kr.ac.hanrw.webapp.dto;

public class HttpErrorObject {

	public static final int ERROR_SUCCESS = 1;
	public static final int ERROR_INVALID_PASSWORD = 2;
	public static final int ERROR_WRONG_PARAM = 3;
	public static final int ERROR_ALREADY_EXIST_USER =4;
	public static final int ERROR_USER_NOT_LOGIN =5;
	public static final int ERROR_USER_NOT_EXIST =5;
	
	
	private int errorCode;
	private String errorMessage;
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + errorCode;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HttpErrorObject other = (HttpErrorObject) obj;
		if (errorCode != other.errorCode)
			return false;
		return true;
	}
	
	
	
}
