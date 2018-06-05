package com.ehive.api.samples.accounts;

import com.ehive.api.EHiveApi;
import com.ehive.api.domain.accounts.Account;
import com.ehive.api.domain.objects.Attribute;
import com.ehive.api.domain.objects.Media;
import com.ehive.api.domain.objects.MediaRow;
import com.ehive.api.domain.objects.MediaSet;
import com.ehive.api.domain.objects.Attribute.AttributeIdentifier;
import com.ehive.api.exceptions.EHiveApiException;
import com.ehive.api.exceptions.EHiveFatalServerException;
import com.ehive.api.exceptions.EHiveForbiddenException;
import com.ehive.api.exceptions.EHiveNotFoundException;
import com.ehive.api.exceptions.EHiveUnauthorizedException;

public class GetAccountInCommunity {
	
	// Add you own API Keys below
	private static String clientId = "";
	private static String clientSecret = "";
	private static String trackingId = "";

	private static Integer accountId = 3406;
	
	private static Integer communityId = 1001;
	
	public static void main(String[] args) throws EHiveApiException, EHiveFatalServerException, EHiveNotFoundException, EHiveUnauthorizedException, EHiveForbiddenException {
		
		// Instantiate the EHiveApi object
		EHiveApi eHiveApi = new EHiveApi(clientId, clientSecret, trackingId);
		
		// Invoke an API method
		Account account = eHiveApi.getAccountInCommunity(communityId, accountId);
		
		// Print some output using the returned account object
		printAccountInfo(account);
	}
	
	private static void printAccountInfo(Account account) {
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append(account.getPublicProfileName() + "\n\n");
		
		stringBuilder.append("About:\n\t");
		stringBuilder.append(account.getAboutCollection());
		stringBuilder.append("\n\n");
		
		stringBuilder.append("Contact Details:\n\t");
		stringBuilder.append("Ph: " + account.getPhoneNumber() + "\n\t");
		stringBuilder.append("Email: " + account.getEmailAddress() + "\n\t");
		stringBuilder.append("Postal Address: " + account.getPostalAddress() + "\n");
		stringBuilder.append("\n\n");
		
		stringBuilder.append("Visitor Info:\n\t");
		stringBuilder.append("Location: " + account.getPhysicalAddress() + "\n\t");
		stringBuilder.append("Opening Hours: " + account.getHoursOfOperation() + "\n");
		stringBuilder.append("\n\n");
		
		stringBuilder.append("Facilities:\n\t");
		
		if (account.getWheelChairAccessFacility()) {
			stringBuilder.append("Wheelchair accessible\n\t");
		}
		
		if (account.getGuidedTourFacility()) {
			stringBuilder.append("Guided Tours\n\t");
		}
		
		if (account.getMembershipClubFacility()) {
			stringBuilder.append("Club Membership\n\t");
		}
		
		if (account.getShopFacility()) {
			stringBuilder.append("Visitors Shop\n\t");
		}
		
		if (account.getParkingFacility()) {
			stringBuilder.append("Parking\n\t");
		}
		
		if (account.getToiletFacility()) {
			stringBuilder.append("Toilets\n\t");
		}
		
		stringBuilder.append(account.getOtherFacility());
		
		stringBuilder.append("\n\n");
		
		for (MediaSet mediaSet : account.getMediaSets()) {
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
