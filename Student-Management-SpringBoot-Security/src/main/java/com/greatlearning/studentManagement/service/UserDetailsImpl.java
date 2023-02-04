package com.greatlearning.studentManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.greatlearning.studentManagement.entity.User;
import com.greatlearning.studentManagement.repository.UserRepository;
import com.greatlearning.studentManagement.security.StudUserDetails;

@Service
public class UserDetailsImpl implements UserDetailsService {

	@Autowired
	UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repository.getUserByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(username + "is not available");
		}
		return new StudUserDetails(user);
	}

}
