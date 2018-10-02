package com.assign.coauthor.rest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericType;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;


/**
 * Test Class for CoAuthorResource. Uses JerseyTest for sending API requests.
 * @author poonam
 *
 */
public class CoAuthorResourceTest extends JerseyTest {
	@Override
	protected Application configure() {
		return new ResourceConfig(CoAuthorResource.class);
	}


	@Test
	public void testGetCoAuthorsWithMinCount() {

		int minCnt = 27;
		final List<CoAuthorScore> coAuthorScoreList = target().path("CoAuthorResource/CoAuthorsWithMinCount/" + minCnt + "/1/0/10").request().get(new GenericType<List<CoAuthorScore>>() {});
		assertNotNull("No Response message received",  coAuthorScoreList);
		assertTrue( "No CoAuthors to return in DB",coAuthorScoreList.size() > 0);

		assertNotNull("No Co-Authors in the returned list",coAuthorScoreList.get(0));
		assertEquals("Author Name mismatch ",  "Bob",  coAuthorScoreList.get(0).getAuthorName());
		assertEquals("Author score mismatch ",  new Integer(36), coAuthorScoreList.get(0).getScore()); 

		assertNotNull("Only  one Co-Author in the returned list",coAuthorScoreList.get(1));
		assertEquals("Author Name mismatch ", "Jane",  coAuthorScoreList.get(1).getAuthorName());
		assertEquals("Author score mismatch ",  new Integer(49), coAuthorScoreList.get(1).getScore()); 
		
	}

	
	@Test(expected = BadRequestException.class)
	public void testGetCoAuthorsWithInvalidParam() {

		//Parameter value check
		int minCnt = 0;
		target().path("CoAuthorResource/CoAuthorsWithMinCount/" + minCnt + "/1/0/10").request().get(new GenericType<List<CoAuthorScore>>() {});

	}


}