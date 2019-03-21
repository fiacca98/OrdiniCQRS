package commandstorage;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class MongoDBManager {

    private static CodecRegistry pojoCodecRegistry;
    private static MongoClient mongoClient;

    private static MongoDatabase database;

    public static MongoDatabase getMongoDB(String dbName){
        if(pojoCodecRegistry == null){
            pojoCodecRegistry = fromRegistries(
                    MongoClient.getDefaultCodecRegistry(),
                    fromProviders(PojoCodecProvider.builder().automatic(true).build())
            );
        }
        if(mongoClient == null){
            mongoClient = new MongoClient(new ServerAddress("localhost",27017),
                    MongoClientOptions.builder().
                            codecRegistry(pojoCodecRegistry).build());
        }
        if(database == null){
            database = mongoClient.getDatabase(dbName);
        }

        return database;

    }

}
