package commandstorage;

import java.util.List;
import java.util.UUID;

public interface OrderDao {
    public Order save(Order order);
    public boolean update(Order order);
    public Order getOrder(UUID idOrder);
}
