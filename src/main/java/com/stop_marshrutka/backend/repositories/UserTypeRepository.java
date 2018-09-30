package com.stop_marshrutka.backend.repositories;

import com.stop_marshrutka.backend.model.dto.UserType;
import com.stop_marshrutka.backend.model.entities.UserTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserTypeRepository extends JpaRepository<UserTypeEntity, Long> {

    @Query("select userType from UserTypeEntity userType"
            + " where userType.userType=:userTypeAsString ")
    Optional<UserTypeEntity> findForStringValue(@Param("userTypeAsString") UserType userTypeAsString);
}
