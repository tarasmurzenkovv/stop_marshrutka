package backend.service;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.TestPropertySource;
import org.testcontainers.containers.GenericContainer;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@TestPropertySource
public class SearchServiceTest {

    @Rule
    public GenericContainer redis = new GenericContainer("redis:latest")
            .withExposedPorts(6379);

    @Autowired
    private SearchService searchService;

    @Before
    public void init() {
        RedisTemplate<String, Point> redisTemplate = ;
        searchService = new SearchService(redisTemplate);
    }

    @Test
    public void shouldFindAllActiveUserPointsThatAreCloseToTheDriverRoute() {

    }
}
