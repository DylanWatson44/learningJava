package com.ehive.api.samples.objectrecordtags;

import com.ehive.api.EHiveApi;
import com.ehive.api.domain.tags.ObjectRecordTag;
import com.ehive.api.exceptions.EHiveApiException;
import com.ehive.api.exceptions.EHiveFatalServerException;
import com.ehive.api.exceptions.EHiveForbiddenException;
import com.ehive.api.exceptions.EHiveNotFoundException;
import com.ehive.api.exceptions.EHiveUnauthorizedException;

public class DeleteObjectRecordTag {
	
	// Add you own API Keys below
	private static String clientId = "";
	private static String clientSecret = "";
	private static String trackingId = "";
	
	private final static Long objectRecordId = 2509L;
	private static ObjectRecordTag objectTag = new ObjectRecordTag();
	
	public static void main(String[] args) throws EHiveApiException, EHiveFatalServerException, EHiveNotFoundException, EHiveUnauthorizedException, EHiveForbiddenException {
		
		// Instantiate the EHiveApi object
		EHiveApi eHiveApi = new EHiveApi(clientId, clientSecret, trackingId);
		
		objectTag.setRawTagName("Mermaid");
		
		// Invoke an API method
		ObjectRecordTag objectRecordTag = eHiveApi.deleteObjectRecordTag(objectRecordId, objectTag);
		
		// Print some output using the returned object record tag
		printObjectRecordTagInfo(objectRecordTag);
		
	}
	
	private static void printObjectRecordTagInfo(ObjectRecordTag objectRecordTag) {
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append("Tag deleted: " + objectRecordTag.getRawTagName() + "\n");
		
		System.out.println(stringBuilder.toString());
	}
}
