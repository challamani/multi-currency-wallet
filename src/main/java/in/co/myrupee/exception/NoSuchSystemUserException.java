package in.co.myrupee.exception;

public class NoSuchSystemUserException extends Exception {

    private String errorCode;
    public NoSuchSystemUserException(String errorCode, String message){
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
