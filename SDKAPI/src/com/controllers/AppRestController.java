package com.controllers;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.entity.AppRegister;

@Path("/app")
public class AppRestController extends AppRegister {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AppRestController() {
		System.out.println("call controller");
	}

	AmazonDynamoDBClient client = new AmazonDynamoDBClient(
			new ProfileCredentialsProvider());
	DynamoDBMapper mapper = new DynamoDBMapper(client);

	@GET
    @Path("{name}/{country}")
    @Produces("text/html")
    public Response getResultByPassingValue(
                    @PathParam("name") String name,
                    @PathParam("country") String country) {
        
        String output = "Customer name - "+name+", Country - "+country+"";
        return Response.status(200).entity(output).build();
 
    }
	
	
	@POST
	@Path("/register")
	@Consumes(MediaType.APPLICATION_JSON)
	public AppRegister consumeJSON(AppRegister appRegister) {
		System.out.println("---------------country---------" + appRegister.getCountry());
		client.setRegion(Region.getRegion(Regions.US_EAST_1));
		mapper.save(appRegister);
		return null;

	}
	
}