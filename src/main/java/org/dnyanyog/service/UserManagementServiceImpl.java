package org.dnyanyog.service;

import static java.util.Objects.nonNull;

import java.util.List;
import java.util.Optional;
import org.dnyanyog.dto.AddUserRequest;
import org.dnyanyog.dto.AddUserResponse;
import org.dnyanyog.dto.UserData;
import org.dnyanyog.encryption.EncryptionService;
import org.dnyanyog.entity.Users;
import org.dnyanyog.enums.ErrorCode;
import org.dnyanyog.repo.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManagementServiceImpl implements UserManagementService {

  Logger logger = LoggerFactory.getLogger(UserManagementService.class);

  @Autowired UsersRepository userRepo;

  @Autowired AddUserResponse userResponse;

  @Autowired private List<Long> userIds;

  @Autowired EncryptionService encryptionService;

  public Optional<AddUserResponse> addUser(AddUserRequest request) {

    //		Users usersTable = new Users();
    //
    //		usersTable.setAge(request.getAge());
    //		usersTable.setEmail(request.getEmail());
    //		usersTable.setPassword(request.getPassword());
    //		usersTable.setUsername(request.getUsername());
    //
    //		usersTable = userRepo.save(usersTable);

    Users usersTable;
    try {
      usersTable =
          Users.getInstance()
              .setAge(request.getAge())
              .setEmail(request.getEmail())
              .setPassword(encryptionService.encrypt(request.getPassword()))
              .setUsername(request.getUsername());
      usersTable = userRepo.save(usersTable);

      userResponse.setMessage(ErrorCode.USER_ADD_SUCCESS.getMessage());
      userResponse.setStatus(ErrorCode.USER_ADD_SUCCESS.getStatus());
      userResponse.setUserId(usersTable.getUserId());

      System.out.println(usersTable.getEmail());
      System.out.println(usersTable.getUsername());
      System.out.println(usersTable.getPassword());
      userResponse.setUserId(usersTable.getUserId());
      userResponse.getUserData().setEmail(usersTable.getEmail());
      userResponse.getUserData().setUsername(usersTable.getUsername());
      userResponse.getUserData().setPassword(usersTable.getPassword());
      userResponse.getUserData().setAge(usersTable.getAge());

    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return Optional.of(userResponse);
  }

  public AddUserResponse getSingleUser(Long userId) {

    Optional<Users> receivedData = userRepo.findById(userId);

    if (receivedData.isPresent()) {
      Users user = receivedData.get();

      String encyptedPassword = user.getPassword();

      userResponse.setStatus(ErrorCode.USER_FOUND.getStatus());
      userResponse.setMessage(ErrorCode.USER_FOUND.getMessage());
      userResponse.setUserId(user.getUserId());
      userResponse.getUserData().setEmail(user.getEmail());
      userResponse.getUserData().setUsername(user.getUsername());
      try {
        userResponse.getUserData().setPassword(encryptionService.decrypt(encyptedPassword));
      } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      userResponse.getUserData().setAge(user.getAge());

    } else {
      userResponse.setStatus(ErrorCode.USER_NOTFOUND.getStatus());

      userResponse.setMessage(ErrorCode.USER_NOTFOUND.getMessage());
    }
    return userResponse;
  }

  public List<Users> getAllUser() {
    return userRepo.findAll();
  }

  public List<Long> getAllUserIds() {

    List<Users> users = userRepo.findAll();

    for (Users user : users) {
      if (nonNull(user)) {
        userIds.add(user.getUserId());
      }
    }
    return userIds;
  }

  public AddUserResponse addUpdatesUser(UserData userData) {
    // TODO Auto-generated method stub
    return null;
  }

  public Object addUpdateUser(AddUserRequest userRequest) {
    // TODO Auto-generated method stub
    return null;
  }
}
