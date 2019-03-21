package eventhandler;

import bus.Bus;
import events.projection.CreateOrderProj;
import org.springframework.jms.annotation.JmsListener;
import projectionstorage.OrderNumberDao;

import javax.inject.Named;

public class OrderNumberHandlerJMS extends OrderNumberHandler {

    public OrderNumberHandlerJMS(@Named("orderDAO") OrderNumberDao orderNumberDao,
                                 @Named("bus") Bus bus) {
        super(orderNumberDao, bus);
    }

    @JmsListener(
            destination = "queue",
            containerFactory = "queueListenerFactory",
            selector = "classtype = 'CreateOrderProj'")
    public void handle(CreateOrderProj message) throws Exception {
        super.handle(message);
    }
}
