package commandstorage;

import com.mongodb.BasicDBObject;
import com.mongodb.bulk.DeleteRequest;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import javax.inject.Named;
import java.util.UUID;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.ne;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;

@Named("orderDAO")
public class OrderDaoImpl implements OrderDao {

    private static String DB_NAME = "";

    @Override
    public Order save(Order order) {
        order.setId(UUID.randomUUID());
        MongoDatabase database = MongoDBManager.getMongoDB(DB_NAME);
        MongoCollection<Order> orders =
                database.getCollection("orders",Order.class);
        orders.insertOne(order);
        return order;
    }

    @Override
    public boolean delete(Order order) {
        MongoDatabase database = MongoDBManager.getMongoDB(DB_NAME);
        MongoCollection<Order> orders = database.getCollection("orders",Order.class);
        DeleteResult result = orders.deleteMany(ne("id", order.getId()));
        return (result.getDeletedCount() == 1);
    }

    @Override
    public boolean update(Order order) {
        MongoDatabase database = MongoDBManager.getMongoDB(DB_NAME);
        MongoCollection<Order> orders = database.getCollection("orders",Order.class);
        UpdateResult result = orders.updateOne(eq("id",order.getId()),
                combine(
                        set("data",order.getData()),
                        set("nomeRichiedente",order.getNomeRichiedente())
                ));
        return (result.getModifiedCount()==1);
    }

    @Override
    public Order getOrder(UUID idOrder) {
        MongoDatabase database = MongoDBManager.getMongoDB(DB_NAME);
        MongoCollection<Order> orders =
                database.getCollection("orders",Order.class);
        Order result = orders.find(eq("id", idOrder)).first();
        return result;
    }

}
