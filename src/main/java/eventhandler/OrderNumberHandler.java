package eventhandler;

import bus.Bus;
import bus.BusMessage;
import commandstorage.Order;
import events.projection.CreateOrderProj;
import projectionstorage.OrderNumberDao;

import javax.inject.Named;

public class OrderNumberHandler implements EventHandler {

    private OrderNumberDao orderNumberDao;

    private Bus bus;

    public OrderNumberHandler(@Named("orderDAO") OrderNumberDao orderNumberDao,
                              @Named("bus") Bus bus){
        this.orderNumberDao = orderNumberDao;
        this.bus = bus;
        bus.register(Order.class,this);

    }

    @Override
    public void handle(BusMessage message) throws Exception {
        CreateOrderProj msg =(CreateOrderProj)message;
        orderNumberDao.save(msg);
    }
}
