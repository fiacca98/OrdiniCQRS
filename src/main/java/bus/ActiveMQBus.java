package bus;

import org.springframework.jms.core.JmsTemplate;

import javax.inject.Named;

@Named("bus")
public class ActiveMQBus implements Bus{

    private JmsTemplate jmsTemplate;

    public ActiveMQBus(@Named("jmsQueueTemplate")
                               JmsTemplate jmsTemplate){
        this.jmsTemplate = jmsTemplate;
    }
    @Override
    public <T> void register(Class<T> clazz, MessageConsumer consumer) {

    }

    @Override
    public void send(BusMessage message) {
        jmsTemplate.convertAndSend(
                "queue",
                message,
                m ->
                {
                    m.setStringProperty(
                            ("classtype"),
                            message.getClass().getSimpleName());
                    return m;}
        );
    }
}
