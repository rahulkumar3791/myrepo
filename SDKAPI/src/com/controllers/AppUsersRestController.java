package com.controllers;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.entity.AppUsers;

@Path("/app")
public class AppUsersRestController extends AppUsers {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	AmazonDynamoDBClient client = new AmazonDynamoDBClient(
			new ProfileCredentialsProvider());
	DynamoDBMapper mapper = new DynamoDBMapper(client);

	@POST
	@Path("/users")
	@Consumes(MediaType.APPLICATION_JSON)
	public AppUsersRestController consumeJSON(AppUsers appUsers) {
		System.out.println("country-------------" + appUsers.getCity());
		client.setRegion(Region.getRegion(Regions.US_EAST_1));
		mapper.save(appUsers);
		return null;

	}

}