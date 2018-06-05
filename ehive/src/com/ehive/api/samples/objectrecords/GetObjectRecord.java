package com.ehive.api.samples.objectrecords;

import com.ehive.api.EHiveApi;
import com.ehive.api.domain.objects.Attribute;
import com.ehive.api.domain.objects.Attribute.AttributeIdentifier;
import com.ehive.api.domain.objects.Field;
import com.ehive.api.domain.objects.FieldRow;
import com.ehive.api.domain.objects.FieldSet;
import com.ehive.api.domain.objects.Media;
import com.ehive.api.domain.objects.MediaRow;
import com.ehive.api.domain.objects.MediaSet;
import com.ehive.api.domain.objects.ObjectRecord;
import com.ehive.api.exceptions.EHiveApiException;
import com.ehive.api.exceptions.EHiveFatalServerException;
import com.ehive.api.exceptions.EHiveForbiddenException;
import com.ehive.api.exceptions.EHiveNotFoundException;
import com.ehive.api.exceptions.EHiveUnauthorizedException;

public class GetObjectRecord {

	// Add you own API Keys below
	private static String clientId = "";
	private static String clientSecret = "";
	private static String trackingId = "";

	private final static Long objectRecordId = 2509L;
	
	public static void main(String[] args) throws EHiveApiException, EHiveFatalServerException, EHiveNotFoundException, EHiveUnauthorizedException, EHiveForbiddenException {
			// Instantiate the EHiveApi object
			EHiveApi eHiveApi = new EHiveApi(clientId, clientSecret, trackingId);
			
			// Invoke an API method
			ObjectRecord objectRecord = eHiveApi.getObjectRecord(objectRecordId);
			
			// Print some output using the returned object record
			printObjectRecordInfo(objectRecord);
	}
	
	private static void printObjectRecordInfo(ObjectRecord objectRecord) {
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append("Record ID: " + objectRecord.getObjectRecordId().toString() + "\n\n");
		
		for (FieldSet fieldSet : objectRecord.getFieldSets()) {
						
			for (FieldRow fieldRow : fieldSet.getFieldRows()) {
				for (Field field : fieldRow.getFields()) {
					for (Attribute attribute : field.getAttributes()) {
						if (AttributeIdentifier.getIdentifier(attribute.getKey()) == AttributeIdentifier.LABEL) { 
							stringBuilder.append(attribute.getValue() + ":");
						} else if (AttributeIdentifier.getIdentifier(attribute.getKey()) == AttributeIdentifier.VALUE) {
							stringBuilder.append(" " + attribute.getValue() + "\n\n");
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
		
		System.out.println(stringBuilder.toString());
	}
}
