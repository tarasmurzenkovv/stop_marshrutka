package com.stop_marshrutka.backend.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "route")
@Getter
@Setter
public class RouteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "START_COORDINATE_LAT")
    private Double startLat;

    @Column(name = "START_COORDINATE_LONG")
    private Double startLog;

    @Column(name = "END_COORDINATE_LAT")
    private Double endLat;

    @Column(name = "END_COORDINATE_LONG")
    private Double endtLog;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private UserEntity userEntity;
}
