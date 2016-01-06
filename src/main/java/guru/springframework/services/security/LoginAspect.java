package guru.springframework.services.security;

import org.aspectj.lang.annotation.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 1/6/16.
 */
@Aspect
@Component
public class LoginAspect {

    @Pointcut("execution(* org.springframework.security.authentication.AuthenticationProvider.authenticate(..))")
    public void doAuthenticate(){

    }

    @Before("guru.springframework.services.security.LoginAspect.doAuthenticate() && args(authentication)")
    public void logBefore(Authentication authentication){

        System.out.println("This is before the Authenticate Method: authentication: " + authentication.isAuthenticated());
    }

    @AfterReturning(value = "guru.springframework.services.security.LoginAspect.doAuthenticate()",
            returning = "authentication")
    public void logAfterAuthenticate( Authentication authentication){
        System.out.println("This is after the Authenticate Method authentication: " + authentication.isAuthenticated());
    }

    @AfterThrowing("guru.springframework.services.security.LoginAspect.doAuthenticate() && args(authentication)")
    public void logAuthenicationException(Authentication authentication){
        String userDetails = (String) authentication.getPrincipal();
        System.out.println("Login failed for user: " + userDetails);
    }
}
