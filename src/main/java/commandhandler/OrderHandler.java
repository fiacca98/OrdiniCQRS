package commandhandler;

import bus.Bus;
import bus.BusMessage;
import commandstorage.Order;
import commandstorage.OrderDao;
import events.command.CreateOrder;

import javax.inject.Named;

public class OrderHandler implements CommandHandler {

    private OrderDao orderDao;

    private Bus bus;

    public OrderHandler(@Named("orderDAO") OrderDao orderDao,
                       @Named("bus") Bus bus){
        this.orderDao = orderDao;
        this.bus = bus;
        bus.register(CreateOrder.class,this);

    }

    @Override
    public void handle(BusMessage message) throws Exception {
        CreateOrder msg =(CreateOrder)message;
        Order order = orderDao.save(MessageConverter.convertToOrder(msg));
        bus.send(MessageConverter.convertToCreateOrderProj(order));
    }
}
