package com.homebakery.homebakery.service;

import com.homebakery.homebakery.dto.UserDto;
import com.homebakery.homebakery.model.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> fiindAllUsers();
}
