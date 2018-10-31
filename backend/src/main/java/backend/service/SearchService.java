package backend.service;

import backend.controllers.ActiveUserRequests;
import backend.model.dto.PassengersSearchRequest;

import lombok.RequiredArgsConstructor;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.GeoOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SearchService {
    private final RedisTemplate<String, Point> redisGeoOpsTemplate;
    private GeoOperations<String, Point> geoOps;

    @PostConstruct
    public void init() {
        this.geoOps = redisGeoOpsTemplate.opsForGeo();
    }

    public List<ActiveUserRequests> findAppropriateRequestsForARide(PassengersSearchRequest passengersSearchRequest) {
        Distance radius = new Distance(100, RedisGeoCommands.DistanceUnit.METERS);
        return passengersSearchRequest.getRoute()
                .stream()
                .map(point -> new Point(point.getX(), point.getY()))
                .map(point -> geoOps.radius("ACTIVE_USER_REQUESTS", new Circle(point, radius)))
                .filter(Objects::nonNull)
                .flatMap(result -> result.getContent().stream())
                .map(GeoResult::getContent)
                .map(content -> new ActiveUserRequests("", content.getPoint().getX(), content.getPoint().getY(), null, null))
                .collect(Collectors.toList());
    }
}
