package backend.repositories;

import backend.model.entities.RouteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RouteRepository extends JpaRepository<RouteEntity, Long> {
    @Query("select route from RouteEntity route "
            + "join fetch route.userEntity "
            + "where route.userEntity.id=:userId ")
    List<RouteEntity> findAllRoutesForUserId(@Param("userId") Long userId);
}
