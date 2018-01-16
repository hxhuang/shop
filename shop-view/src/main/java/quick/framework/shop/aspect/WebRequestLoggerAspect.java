package quick.framework.shop.aspect;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import quick.framework.common.resp.Response;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Configuration
@Aspect
@Order(5)
public class WebRequestLoggerAspect {

    private ThreadLocal<Long> startTime = new ThreadLocal<>();

    private static final Logger logger = LoggerFactory.getLogger(WebRequestLoggerAspect.class);

    @Around("execution(* quick.framework.shop.admin.controller.*.*(..))")
    public Response doOperationLog(ProceedingJoinPoint pjp) throws Throwable {
        startTime.set(System.currentTimeMillis());
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        StringBuilder headers = new StringBuilder();
        Enumeration<String> enumeration = request.getHeaderNames();
        while (enumeration.hasMoreElements()) {
            String header = enumeration.nextElement();
            headers.append(header).append(":").append(request.getHeader(header)).append("\n");
        }
        logger.info("========================================================================================");
        logger.info("= REQUEST HEADERS : \n" + headers);
        logger.info("= REQUEST URL : " + request.getRequestURL());
        logger.info("= REQUEST METHOD : " + request.getMethod());
        logger.info("= REQUEST INVOKE METHOD : " + pjp.getSignature().getDeclaringTypeName() + "." + pjp.getSignature().getName());
        logger.info("= REQUEST ARGUMENTS : " + JSON.toJSONString(pjp.getArgs()));

        Response result = (Response) pjp.proceed();

        logger.info("= SERVER RESPONSE : " + JSON.toJSONString(result));
        long execTime = System.currentTimeMillis() - startTime.get();
        logger.info("= EXECUTE TIME IS : " + execTime);
        logger.info("========================================================================================");
        return result;
    }
}
