package com.ehive.api.samples.objectrecordtags;

import com.ehive.api.EHiveApi;
import com.ehive.api.domain.tags.ObjectRecordTag;
import com.ehive.api.domain.tags.ObjectRecordTagsCollection;
import com.ehive.api.exceptions.EHiveApiException;
import com.ehive.api.exceptions.EHiveFatalServerException;
import com.ehive.api.exceptions.EHiveForbiddenException;
import com.ehive.api.exceptions.EHiveNotFoundException;
import com.ehive.api.exceptions.EHiveUnauthorizedException;

public class GetObjectRecordTags {
	
	// Add you own API Keys below
	private static String clientId = "";
	private static String clientSecret = "";
	private static String trackingId = "";
	
	private final static Long objectRecordId = 2509L;
	
	public static void main(String[] args) throws EHiveApiException, EHiveFatalServerException, EHiveNotFoundException, EHiveUnauthorizedException, EHiveForbiddenException {
		
		// Instantiate the EHiveApi object
		EHiveApi eHiveApi = new EHiveApi(clientId, clientSecret, trackingId);
		
		// Invoke an API method
		ObjectRecordTagsCollection objectRecordTagCollection = eHiveApi.getObjectRecordTags(objectRecordId);
		
		// Print some output using the returned object record tags
		printObjectRecordTagsInfo(objectRecordTagCollection);
		
	}
	
	private static void printObjectRecordTagsInfo(ObjectRecordTagsCollection objectRecordTagCollection) {
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append("Total number of tags found: " + objectRecordTagCollection.getObjectRecordTags().size() + "\n\n");
		stringBuilder.append("----------------------------------------------------------------------------\n\n");
		
		for(ObjectRecordTag objectRecordTag : objectRecordTagCollection.getObjectRecordTags()) {
			stringBuilder.append("Tag: " + objectRecordTag.getRawTagName() + "\n");
		}
		
		System.out.println(stringBuilder.toString());
	}
}
