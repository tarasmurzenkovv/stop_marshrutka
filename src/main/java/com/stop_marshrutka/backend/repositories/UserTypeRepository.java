package com.stop_marshrutka.backend.repositories;

import com.stop_marshrutka.backend.model.dto.UserType;
import com.stop_marshrutka.backend.model.entities.UserTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserTypeRepository extends JpaRepository<UserTypeEntity, Long> {

    @Query("select userType from UserTypeEntity userType"
            + " where userType.userType=:userType ")
    Optional<UserTypeEntity> findForType(@Param("userType") UserType userType);

    default UserTypeEntity getPassengerType() {
        return this.findForType(UserType.PASSENGER)
                .orElseThrow(() -> new RuntimeException("Cannot find driver entity"));
    }

    default UserTypeEntity getDriverType() {
        return this.findForType(UserType.DRIVER)
                .orElseThrow(() -> new RuntimeException("Cannot find driver entity"));
    }
}
