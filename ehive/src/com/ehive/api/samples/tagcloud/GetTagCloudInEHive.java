package com.ehive.api.samples.tagcloud;

import com.ehive.api.EHiveApi;
import com.ehive.api.domain.tags.TagCloud;
import com.ehive.api.domain.tags.TagCloudTag;
import com.ehive.api.exceptions.EHiveApiException;
import com.ehive.api.exceptions.EHiveFatalServerException;
import com.ehive.api.exceptions.EHiveForbiddenException;
import com.ehive.api.exceptions.EHiveNotFoundException;
import com.ehive.api.exceptions.EHiveUnauthorizedException;

public class GetTagCloudInEHive {
	
	// Add you own API Keys below
	private static String clientId = "";
	private static String clientSecret = "";
	private static String trackingId = "";
	
	private static Integer limit = 24;
	
	public static void main(String[] args) throws EHiveApiException, EHiveFatalServerException, EHiveNotFoundException, EHiveUnauthorizedException, EHiveForbiddenException {
		
		// Instantiate the EHiveApi object
		EHiveApi eHiveApi = new EHiveApi(clientId, clientSecret, trackingId);
		
		// Invoke an API method
		TagCloud tagCloud = eHiveApi.getTagCloudInEHive(limit);
		
		// Print some output using the returned tag cloud
		printTagCloudInfo(tagCloud);
		
	}
	
	private static void printTagCloudInfo(TagCloud tagCloud) {
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append("Total number of tags found: " + tagCloud.getTagCloudTags().size() + "\n\n");
		stringBuilder.append("----------------------------------------------------------------------------\n\n");
		
		for (TagCloudTag tagCloudTag : tagCloud.getTagCloudTags()) {
			stringBuilder.append("Tag: " + tagCloudTag.getCleanTagName() + "\n");

		}
		System.out.println(stringBuilder.toString());
	}
}
