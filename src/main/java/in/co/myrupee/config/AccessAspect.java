package in.co.myrupee.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AccessAspect {


    private Logger logger = LoggerFactory.getLogger(getClass());

    @Before("execution(* in.co.myrupee..*.*(..))")
    public void before(JoinPoint joinPoint) {

        logger.info("Before execute " + joinPoint.getSignature().getName());
        StringBuilder stringBuilder = new StringBuilder();
        for (Object object : joinPoint.getArgs()) {
            stringBuilder.append(object.toString().concat(","));
        }
        logger.info("Inbound params: "+stringBuilder.toString());
        logger.info("Allowed execution for {}", joinPoint);
    }


    @After("execution(* in.co.myrupee..*.*(..))")
    public void after(JoinPoint joinPoint) {

        logger.info("After execute " + joinPoint.getSignature().getName());
        StringBuilder stringBuilder = new StringBuilder();
        for (Object object : joinPoint.getArgs()) {
            stringBuilder.append(object.toString().concat(","));
        }
        logger.info("outbound params: " + stringBuilder.toString());
        logger.info("Return for {}", joinPoint);
    }

}