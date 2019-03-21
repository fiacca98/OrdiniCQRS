package projectionstorage;

import commandstorage.Order;
import events.projection.CreateOrderProj;

import java.util.UUID;

public interface OrderNumberDao {
    public CreateOrderProj save(CreateOrderProj order);
    public OrderNumber getOrderNumber(String nomeRichiedente);
}
