package com.ehive.api.samples.comments;

import com.ehive.api.EHiveApi;
import com.ehive.api.domain.comments.Comment;
import com.ehive.api.domain.comments.CommentsCollection;
import com.ehive.api.exceptions.EHiveApiException;
import com.ehive.api.exceptions.EHiveFatalServerException;
import com.ehive.api.exceptions.EHiveForbiddenException;
import com.ehive.api.exceptions.EHiveNotFoundException;
import com.ehive.api.exceptions.EHiveUnauthorizedException;

public class GetObjectRecordComments {
	
	// Add you own API Keys below
	private static String clientId = "";
	private static String clientSecret = "";
	private static String trackingId = "";

	private static Long objectRecordId = 2509L;
	private static Integer offset = 0;
	private static Integer limit = 12;
	
	public static void main(String[] args) throws EHiveApiException, EHiveFatalServerException, 
												  EHiveNotFoundException, EHiveUnauthorizedException, EHiveForbiddenException {
			// Instantiate the EHiveApi object
			EHiveApi eHiveApi = new EHiveApi(clientId, clientSecret, trackingId);
			
			// Invoke an API method
			CommentsCollection commentsCollection = eHiveApi.getObjectRecordComments(objectRecordId, offset, limit);
			
			// Print some output using the returned object record comments
			printCommentsInfo(commentsCollection);
	}
	
	private static void printCommentsInfo(CommentsCollection commentsCollection) {
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append("Total number of comments: " + commentsCollection.getComments().size() + "\n\n");
		
		for (Comment comment : commentsCollection.getComments()) {
			stringBuilder.append("Commentor Name:\t\t " + comment.getCommentorName() + "\n");
			stringBuilder.append("Commentor Email Address: " + comment.getCommentorEmailAddress() + "\n");
			stringBuilder.append("Comment Text:\t\t " + comment.getCommentText() + "\n\n");
		}
		
		System.out.println(stringBuilder.toString());
	}
}
