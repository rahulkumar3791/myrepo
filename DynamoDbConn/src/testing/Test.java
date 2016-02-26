package testing;

public class Test {
	
	void testConnection()
	{
		DynamoDB dynamoDB = new DynamoDB(new AmazonDynamoDBClient(
				new ProfileCredentialsProvider()));

			ArrayList<AttributeDefinition> attributeDefinitions= new ArrayList<AttributeDefinition>();
			attributeDefinitions.add(new AttributeDefinition().withAttributeName("Id").withAttributeType("N"));

			ArrayList<KeySchemaElement> keySchema = new ArrayList<KeySchemaElement>();
			keySchema.add(new KeySchemaElement().withAttributeName("Id").withKeyType(KeyType.HASH));
			        
			CreateTableRequest request = new CreateTableRequest()
					.withTableName(tableName)
					.withKeySchema(keySchema)
					.withAttributeDefinitions(attributeDefinitions)
					.withProvisionedThroughput(new ProvisionedThroughput()
					    .withReadCapacityUnits(5L)
						.withWriteCapacityUnits(6L));

			Table table = dynamoDB.createTable(request);

			table.waitForActive();
		
		
		
	}

}
