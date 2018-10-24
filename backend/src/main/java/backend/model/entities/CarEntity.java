package backend.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "car")
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "DRIVER_ID")
    private UserEntity userEntity;

    @Column(name = "CAR_TYPE")
    private String carType;

    @Column(name = "CAR_NUMBER")
    private String carNumber;
}
