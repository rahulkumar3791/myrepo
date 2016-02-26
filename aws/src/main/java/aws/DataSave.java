public package aws;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;

public class DataSave {

    static DynamoDB dynamoDB = new DynamoDB(new AmazonDynamoDBClient(
            new ProfileCredentialsProvider()));
    
    static String productCatalogTableName = "ProductCatalog";
    
    public static void main(String[] args) throws Exception {

        try {
             System.out.println("calling...!!!");
            loadSampleProducts(productCatalogTableName);

        } catch (AmazonServiceException ase) 
        {
            System.err.println("Data load script failed.");
        }
    }
    
    private static void loadSampleProducts(String tableName) {

        Table table = dynamoDB.getTable(tableName);
        try {
            System.out.println("Adding data to " + tableName);
            
            Item item = new Item().withPrimaryKey("id", 9).with("book", "c++");
            System.out.println("iddd");
            table.putItem(item);
            System.out.println("successfully inserted");
            } 
        catch (Exception e) 
        {
            System.err.println("Failed to create item in " + tableName);
            System.err.println(e.getMessage());
        }

    }

}
	
	


