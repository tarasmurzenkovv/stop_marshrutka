package com.stop_marshrutka.backend.repositories;

import com.stop_marshrutka.backend.model.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
