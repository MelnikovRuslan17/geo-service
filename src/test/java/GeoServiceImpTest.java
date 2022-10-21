import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;

import java.util.stream.Stream;

public class GeoServiceImpTest {
    GeoServiceImpl sut;

    @BeforeEach
    void geo_init() {
        sut = new GeoServiceImpl();
    }

    @AfterEach
    void geo_end() {
        sut = null;
    }

    @MethodSource("source")
    @ParameterizedTest
    void geo_test_by_name(String ip, String expected) {
        Location location = sut.byIp(ip);
        String result = location.getCity();
        Assertions.assertEquals(expected, result);

    }

    public static Stream<Arguments> source() {
        return Stream.of(Arguments.of("172.0.0.1", "Moscow"),
                Arguments.of("172.1.1.1", "Moscow"),
                Arguments.of("96.1.1.2", "New York"),
                Arguments.of("172.0.0.23", "Moscow"),
                Arguments.of("96.11.23.224", "New York"));
    }



}
