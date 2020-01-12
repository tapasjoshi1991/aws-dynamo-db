//package com.trjoshi.aws.dynamodb.demo.dao;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Repository;
//
//import com.amazonaws.services.cognitoidentity.model.ResourceNotFoundException;
//import com.trjoshi.aws.dynamodb.demo.model.UserDetails;
//
//import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
//import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
//import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;
//import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
//import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
//import software.amazon.awssdk.services.dynamodb.model.PutItemResponse;
//
//@Repository
//public class UserDetailsRepository {
//
//	private static Logger LOGGER = LoggerFactory.getLogger(UserDetailsRepository.class);
//	DynamoDbClient ddb = DynamoDbClient.create();
//
//	public String addUser(UserDetails userDetails) {
//
//		LOGGER.info("Adding the userDetails : " + userDetails);
//
//		HashMap<String, AttributeValue> item_values = new HashMap<String, AttributeValue>();
//
//		item_values.put("user_id", AttributeValue.builder().s(userDetails.getUserId()).build());
//		item_values.put("first_name", AttributeValue.builder().s(userDetails.getFirstName()).build());
//		item_values.put("last_name", AttributeValue.builder().s(userDetails.getLastName()).build());
//
//		PutItemRequest request = PutItemRequest.builder().tableName("user").item(item_values).build();
//
//		try {
//			PutItemResponse response = ddb.putItem(request);
//			return response.toString();
//		} catch (ResourceNotFoundException e) {
//			LOGGER.error("Exception occurred during add User Details : ", e);
//			return null;
//		} catch (DynamoDbException e) {
//			LOGGER.error("Exception occurred during add User Details : ", e);
//			return null;
//		}
//
//	}
//
//	public UserDetails getUserDetails(String userId) {
//		HashMap<String, AttributeValue> keyToGet = new HashMap<String, AttributeValue>();
//		keyToGet.put("user_id", AttributeValue.builder().s(userId).build());
//		GetItemRequest request = null;
//		request = GetItemRequest.builder().key(keyToGet).tableName("user").build();
//		DynamoDbClient ddb = DynamoDbClient.create();
//		UserDetails userDetail = new UserDetails();
//		try {
//			Map<String, AttributeValue> returnedItem = ddb.getItem(request).item();
//			if (returnedItem != null) {
//				userDetail.setUserId(returnedItem.get("user_id").s());
//				userDetail.setFirstName(returnedItem.get("first_name").s());
//				userDetail.setLastName(returnedItem.get("last_name").s());
//			} else {
//				LOGGER.info("No item found with the key %s!\n", "user_id");
//			}
//		} catch (DynamoDbException e) {
//			LOGGER.error("Error occurred while fetching userDetails : ", e);
//		}
//		return userDetail;
//	}
//
//}
