package guru.springframework.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

/**
 * Created by jt on 4/17/16.
 */
@Component
public class SendTextMessageServiceImpl implements SendTextMessageService {

    private Queue textMessageQueue;
    private JmsTemplate jmsTemplate;

    @Autowired
    public void setTextMessageQueue(Queue textMessageQueue) {
        this.textMessageQueue = textMessageQueue;
    }

    @Autowired
    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public void sendTextMessage(String msg) {

        this.jmsTemplate.convertAndSend(this.textMessageQueue, msg);

    }
}
