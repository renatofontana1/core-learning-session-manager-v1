package com.accenture.ada.sessionManager.sessionmanager.repository;

import com.accenture.ada.sessionManager.sessionmanager.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findById(String id);

}
