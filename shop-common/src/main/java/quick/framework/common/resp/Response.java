package quick.framework.common.resp;

import java.io.Serializable;

/**
 * 单数据响应对象
 */
public class Response implements Serializable {
    private static final long serialVersionUID = -1069648653024086052L;

    private int code = 200;

    private String message = "操作成功";

    private Object obj;

    /**
     * 异常响应消息对象
     *
     * @param code    消息码
     * @param message 消息
     */
    public static Response error(int code, String message) {
        Response response = new Response();
        response.setCode(code);
        response.setMessage(message);
        return response;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
