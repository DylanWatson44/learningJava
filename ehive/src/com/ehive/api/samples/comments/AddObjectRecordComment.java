package com.ehive.api.samples.comments;

import com.ehive.api.EHiveApi;
import com.ehive.api.domain.comments.Comment;
import com.ehive.api.exceptions.EHiveApiException;
import com.ehive.api.exceptions.EHiveFatalServerException;
import com.ehive.api.exceptions.EHiveForbiddenException;
import com.ehive.api.exceptions.EHiveNotFoundException;
import com.ehive.api.exceptions.EHiveUnauthorizedException;

public class AddObjectRecordComment {
	
	// Add you own API Keys below
	private static String clientId = "";
	private static String clientSecret = "";
	private static String trackingId = "";

	private static Long objectRecordId = 2509L;
	private static Comment comment = new Comment();
	
	public static void main(String[] args) throws EHiveApiException, EHiveFatalServerException, EHiveNotFoundException, 
												  EHiveUnauthorizedException, EHiveForbiddenException {
			// Instantiate the EHiveApi object
			EHiveApi eHiveApi = new EHiveApi(clientId, clientSecret, trackingId);
			
			// Populate the parameters on the Comment request object
			comment.setCommentorEmailAddress("john.doe@ehivedevelopers.com");
			comment.setCommentorName("John Doe");
			comment.setCommentText(	"This is a test comment posted from developers.ehive.com. " +
									"You can check the timestamp on the response below against the " +
									"timestamp on the eHive object record to verify that your " +
									"comment was added.");
			
			// Invoke an API method
			Comment addedComment = eHiveApi.addObjectRecordComment(objectRecordId, comment);
			
			// Print some output using the added comment object
			printCommentInfo(addedComment);
	}
	
	private static void printCommentInfo(Comment addedComment) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("The added comment is:\n\n");
		stringBuilder.append("Commentor Name:\t\t " + addedComment.getCommentorName() + "\n");
		stringBuilder.append("Commentor Email Address: " + addedComment.getCommentorEmailAddress() + "\n");
		stringBuilder.append("Comment Text:\t\t " + addedComment.getCommentText() + "\n\n");
		
		System.out.println(stringBuilder.toString());
	}
}
