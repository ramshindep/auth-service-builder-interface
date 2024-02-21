package org.dnyanyog.service;

import static java.util.Objects.nonNull;

import java.util.List;
import java.util.Optional;

import org.dnyanyog.dto.AddUserRequest;
import org.dnyanyog.dto.AddUserResponse;
import org.dnyanyog.dto.LoginRequest;
import org.dnyanyog.dto.LoginResponse;
import org.dnyanyog.dto.UserData;
import org.dnyanyog.entity.Users;
import org.springframework.stereotype.Service;

@Service
public interface UserManagementService {

	public Optional<AddUserResponse> addUser(AddUserRequest request);

	public Object addUpdateUser(AddUserRequest userRequest);


	public List<Users> getAllUser();

	public List<Long> getAllUserIds();

	public AddUserResponse getSingleUser(Long userId);

	AddUserResponse addUpdatesUser(UserData userData);
	
	
	}
