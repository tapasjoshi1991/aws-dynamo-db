/**
 * 
 */
package com.trjoshi.aws.dynamodb.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.trjoshi.aws.dynamodb.demo.dao.UserDetailsRepositoryV2;
import com.trjoshi.aws.dynamodb.demo.model.UserDetails;

/**
 * @author tapas
 *
 */
@RestController
public class UserDetailsController {
	
	@Autowired
	private UserDetailsRepositoryV2 dao;
	
	@PostMapping("/UserDetails")
	public String addUserDetails(@RequestBody UserDetails userDetail) {
		return dao.addUserDetails(userDetail);
	}

	@GetMapping("/UserDetails/{key}")
	public UserDetails getUserDetails(@PathVariable("key") String key) {
		return dao.getUserDetails(key);
	}
	

}
