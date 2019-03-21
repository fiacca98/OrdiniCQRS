package projectionstorage;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import commandstorage.MongoDBManager;
import commandstorage.Order;
import events.projection.CreateOrderProj;

import java.util.List;
import java.util.UUID;

import static com.mongodb.client.model.Filters.eq;

public class OrderNumberDaoImpl implements OrderNumberDao {

    private final static String DB_NAME = "firstProjectionDB";

    @Override
    public CreateOrderProj save(CreateOrderProj order) {
        OrderNumber orderNumber = new OrderNumber(order.getNomeRichiedente(),1);
        OrderNumber tmp = this.getOrderNumber(order.getNomeRichiedente());
        MongoDatabase database = MongoDBManager.getMongoDB(DB_NAME);
        MongoCollection<OrderNumber> orderNumbers =
                database.getCollection("orderNumbers",OrderNumber.class);

        if(tmp != null){
            tmp.setCount(tmp.getCount()+1);
            orderNumbers.insertOne(tmp);
        }
        else {
            orderNumbers.insertOne(orderNumber);
        }

        return order;

    }

    @Override
    public OrderNumber getOrderNumber(String nomeRichiedente) {
        MongoDatabase database = MongoDBManager.getMongoDB(DB_NAME);
        MongoCollection<OrderNumber> orderNumbers =
                database.getCollection("orderNumbers",OrderNumber.class);
        OrderNumber result = orderNumbers.find(eq("nomeRichiedente", nomeRichiedente)).first();
        return result;
    }
}
