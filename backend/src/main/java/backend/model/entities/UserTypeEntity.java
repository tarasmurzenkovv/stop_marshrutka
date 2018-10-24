package backend.model.entities;

import backend.model.dto.UserType;
import backend.service.convertors.UserTypeConverter;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "application_user_type")
public class UserTypeEntity {
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "USER_TYPE")
    @Convert(converter = UserTypeConverter.class)
    private UserType userType;
}
