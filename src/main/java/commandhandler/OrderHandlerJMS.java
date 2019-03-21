package commandhandler;

import bus.Bus;
import commandstorage.OrderDao;
import events.command.CreateOrder;
import org.springframework.jms.annotation.JmsListener;

import javax.inject.Named;

public class OrderHandlerJMS extends OrderHandler {

    public OrderHandlerJMS(@Named("orderDAO") OrderDao orderDao,
                           @Named("bus") Bus bus) {
        super(orderDao, bus);
    }

    @JmsListener(
            destination = "queue",
            containerFactory = "queueListenerFactory",
            selector = "classtype = 'CreateOrder'")
    public void handle(CreateOrder message) throws Exception {
        super.handle(message);
    }
}
