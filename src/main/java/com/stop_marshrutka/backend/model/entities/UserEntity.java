package com.stop_marshrutka.backend.model.entities;

import com.stop_marshrutka.backend.service.UserTypeConverter;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "application_user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String userName;

    @OneToMany(mappedBy = "userEntity", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<RouteEntity> routeEntities;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_TYPE_ID")
    private UserTypeEntity userTypeEntity;
}
