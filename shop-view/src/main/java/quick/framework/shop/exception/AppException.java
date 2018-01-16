package quick.framework.shop.exception;

public class AppException extends RuntimeException {
    private static final long serialVersionUID = -7226272359888110473L;

    private int code;

    private String message;

    public AppException(int code,String message){
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
