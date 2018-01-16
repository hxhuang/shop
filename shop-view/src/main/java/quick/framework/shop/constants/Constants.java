package quick.framework.shop.constants;

/**
 * 常量配置
 */
public interface Constants {

    /**
     * 定义返回的响应对象
     */
    enum ResponseStatus {

        USER_NOT_EXISTS(10001, "用户不存在"),
        APP_ERROR(500, "系统内部错误");

        public int code;

        public String message;

        ResponseStatus(int code, String message) {
            this.code = code;
            this.message = message;
        }
    }
}
