package com.ehive.api.samples.popularobjectrecords;

import com.ehive.api.EHiveApi;
import com.ehive.api.domain.objects.Attribute;
import com.ehive.api.domain.objects.Field;
import com.ehive.api.domain.objects.FieldRow;
import com.ehive.api.domain.objects.FieldSet;
import com.ehive.api.domain.objects.Media;
import com.ehive.api.domain.objects.MediaRow;
import com.ehive.api.domain.objects.MediaSet;
import com.ehive.api.domain.objects.ObjectRecord;
import com.ehive.api.domain.objects.ObjectRecordsCollection;
import com.ehive.api.domain.objects.Attribute.AttributeIdentifier;
import com.ehive.api.exceptions.EHiveApiException;
import com.ehive.api.exceptions.EHiveFatalServerException;
import com.ehive.api.exceptions.EHiveForbiddenException;
import com.ehive.api.exceptions.EHiveNotFoundException;
import com.ehive.api.exceptions.EHiveUnauthorizedException;

public class GetPopularObjectRecordsInAccountInCommunity {	
	
	// Add you own API Keys below
	private static String clientId = "";
	private static String clientSecret = "";
	private static String trackingId = "";

	private static Integer accountId = 3406;
	private static Integer communityId = 1001;
	
	private static Boolean hasImages = false;
	private static Integer offset = 0;
	private static Integer limit = 12;
	
	public static void main(String[] args) throws EHiveApiException, EHiveFatalServerException, EHiveNotFoundException, EHiveUnauthorizedException, EHiveForbiddenException {
		
		// Instantiate the EHiveApi object
		EHiveApi eHiveApi = new EHiveApi(clientId, clientSecret, trackingId);
		
		// Invoke an API method
		ObjectRecordsCollection objectRecordsCollection = eHiveApi.getPopularObjectRecordsInAccountInCommunity(communityId, accountId, hasImages, offset, limit);
		
		// Print some output using the returned object records collection
		printObjectRecordInfo(objectRecordsCollection);
		
	}
	
	private static void printObjectRecordInfo(ObjectRecordsCollection objectRecordsCollection) {
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append("Search results found: " + objectRecordsCollection.getTotalObjects() + "\n\n");
		stringBuilder.append("----------------------------------------------------------------------------\n\n");
		
		for (ObjectRecord objectRecord : objectRecordsCollection.getObjectRecords()) {
			stringBuilder.append("Record ID: " + objectRecord.getObjectRecordId().toString() + "\n\n");
			
			for (FieldSet fieldSet : objectRecord.getFieldSets()) {
				stringBuilder.append("FIELD SET: " + fieldSet.getIdentifier() + "\n");
				
				for (FieldRow fieldRow : fieldSet.getFieldRows()) {
					for (Field field : fieldRow.getFields()) {
						for (Attribute attribute : field.getAttributes()) {
							if (AttributeIdentifier.getIdentifier(attribute.getKey()) == AttributeIdentifier.LABEL) { 
								stringBuilder.append(attribute.getValue() + ":");
							} else if (AttributeIdentifier.getIdentifier(attribute.getKey()) == AttributeIdentifier.VALUE) {
								stringBuilder.append("\t   " + attribute.getValue() + "\n\n");
							}
						}
					}
				}
				stringBuilder.append("\n\n");
			}
			
			for (MediaSet mediaSet : objectRecord.getMediaSets()) {
				stringBuilder.append(mediaSet.getIdentifier().toUpperCase() + " URL: \n");
				
				for (MediaRow mediaRow : mediaSet.getMediaRows()) {
					for (Media media : mediaRow.getMedia()) {
						for (Attribute attribute : media.getAttributes()) {
							if (AttributeIdentifier.getIdentifier(attribute.getKey()) == AttributeIdentifier.URL) { 
								stringBuilder.append(attribute.getValue() + "\n");
							} 
						}
					}
				}
			}
			stringBuilder.append("----------------------------------------------------------------------------\n\n");
			
		}
		System.out.println(stringBuilder.toString());
	}
}
