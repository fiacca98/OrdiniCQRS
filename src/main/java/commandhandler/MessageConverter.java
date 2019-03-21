package commandhandler;

import commandstorage.Order;
import events.command.CreateOrder;
import events.projection.CreateOrderProj;
import org.aspectj.weaver.ast.Or;

public class MessageConverter {

    public static Order convertToOrder(CreateOrder createOrder){
        Order order = new Order();
        order.setData(createOrder.getData());
        order.setNomeRichiedente(createOrder.getNomeRichiedente());
        return order;
    }

    public static CreateOrderProj convertToCreateOrderProj(Order order){
        CreateOrderProj createOrderProj = new CreateOrderProj();
        createOrderProj.build(order.getId(),order.getNomeRichiedente(),order.getData());
        return createOrderProj;
    }
}
