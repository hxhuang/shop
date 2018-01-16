package quick.framework.shop.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import quick.framework.common.resp.Response;
import quick.framework.shop.constants.Constants;

/**
 * 统一异常处理
 */
@RestControllerAdvice
public class ShopHandlerAdvice {

    @ExceptionHandler
    public Response doException(Exception e) {

        if (e instanceof AppException) {
            AppException exception = (AppException) e;
            return Response.error(exception.getCode(), exception.getMessage());
        }

        return Response.error(Constants.ResponseStatus.APP_ERROR.code, Constants.ResponseStatus.APP_ERROR.message);
    }

}
