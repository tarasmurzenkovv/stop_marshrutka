package backend.model.entities;

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

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.PERSIST)
    private List<RouteEntity> routeEntities;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.PERSIST)
    private List<CarEntity> carEntities;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_TYPE_ID")
    private UserTypeEntity userTypeEntity;

    @Embedded
    private UserInformation userInformation;
}
