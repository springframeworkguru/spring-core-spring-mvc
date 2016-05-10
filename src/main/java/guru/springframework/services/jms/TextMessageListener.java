package guru.springframework.services.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 5/6/16.
 */
@Component
public class TextMessageListener {

    @JmsListener(destination = "text.messagequeue")
    public void onMessage(String msg){
        System.out.println("###############################");
        System.out.println("###############################");
        System.out.println("I GOT A MESSAGE");
        System.out.println(msg);
        System.out.println("###############################");
        System.out.println("###############################");
    }
}
