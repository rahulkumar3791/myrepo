package com.test;

import java.util.ArrayList;

import com.amazonaws.services.dynamodbv2.document.DynamoDB;

public class Test {
	
	public static void main(String aa[]) throws InterruptedException
	{
		DynamoDB dynamoDB = new DynamoDB(new AmazonDynamoDBClient(
				new ProfileCredentialsProvider()));

			ArrayList<AttributeDefinition> attributeDefinitions= new ArrayList<AttributeDefinition>();
			attributeDefinitions.add(new AttributeDefinition().withAttributeName("Id").withAttributeType("N"));

			ArrayList<KeySchemaElement> keySchema = new ArrayList<KeySchemaElement>();
			keySchema.add(new KeySchemaElement().withAttributeName("Id").withKeyType(KeyType.HASH));
			        
			CreateTableRequest request = new CreateTableRequest()
					.withTableName("stu")
					.withKeySchema(keySchema)
					.withAttributeDefinitions(attributeDefinitions)
					.withProvisionedThroughput(new ProvisionedThroughput()
					    .withReadCapacityUnits(5L)
						.withWriteCapacityUnits(6L));

			Table table = dynamoDB.createTable(request);

			table.waitForActive();
		
		
	}
}
