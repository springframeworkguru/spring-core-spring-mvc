package guru.springframework.services.security;

import org.springframework.context.ApplicationListener;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 1/6/16.
 */
@Component
public class LoginFailureEventHandler implements ApplicationListener<LoginFailureEvent> {
    @Override
    public void onApplicationEvent(LoginFailureEvent event) {

        Authentication authentication = (Authentication) event.getSource();
        System.out.println("LoginEvent Failure for: " + authentication.getPrincipal());
    }
}
