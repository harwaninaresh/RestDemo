package com.assign.coauthor.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


/**
 * Rest Interface for queries  for CoAuthor. 
 * @author poonam
 *
 */

@Path("CoAuthorResource")
public class CoAuthorResource {

	//Get will accept parameters in path. It returns back a list of custom(CoAuthorScore) objects. 
	//Response being a complex object is wrapped in GenericEntity.
	//Error handlng using WebApplicationException return HTTP Response status.
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/CoAuthorsWithMinCount/{minCount}/{isPaging}/{start}/{numRows}")
	public Response getCoAuthorsWithMinCount( @PathParam("minCount")int minCount,
			@PathParam("isPaging") boolean isPaging,
			@PathParam("start") int start,
			@PathParam("numRows") int numRows 
			) {

		Logger.getLogger(CoAuthorResource.class.getName()).log(Level.FINE, "Serving Request to getCoAuthorsWithMinCount with params " +
				"minCount : " + minCount 	 + "isPaging : " + isPaging + 	 "start: " + start + 
				"numRows: "+ numRows );

		// Check on the input parameter value if incorrect send back appropriate message
		if (minCount < 1) {
		    Response r = Response.status(Status.BAD_REQUEST).build();
	        throw new WebApplicationException(r);
		}
		List<CoAuthorScore> coAuthorScoreList = getDefaultCoAuthors();
		
		Logger.getLogger(CoAuthorResource.class.getName()).log(Level.FINE, "Returning coAuthors Array of size : " + coAuthorScoreList.size());
		GenericEntity entity = new GenericEntity<List<CoAuthorScore>>(coAuthorScoreList) {	};
		return Response.ok(entity).build();

	}

	private List<CoAuthorScore> getDefaultCoAuthors() {
		List<CoAuthorScore> coAuthorScoreList = new ArrayList<CoAuthorScore>();		
		coAuthorScoreList.add(new CoAuthorScore("Bob",36));
		coAuthorScoreList.add(new CoAuthorScore("Jane",49));
		coAuthorScoreList.add(new CoAuthorScore("Joshua",184));
		coAuthorScoreList.add(new CoAuthorScore("Kanitkar",75));
		return coAuthorScoreList; 
	}
}