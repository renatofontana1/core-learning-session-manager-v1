package com.accenture.ada.sessionManager.sessionmanager.service;

import com.accenture.ada.baseapp.service.BaseService;
import com.accenture.ada.sessionManager.sessionmanager.exception.UserNotFoundException;
import com.accenture.ada.sessionManager.sessionmanager.model.entity.User;
import com.accenture.ada.sessionManager.sessionmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService {

    @Autowired
    private UserRepository userRepository;

    public User getUser(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }
}
