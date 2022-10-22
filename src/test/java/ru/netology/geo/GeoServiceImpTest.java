package ru.netology.geo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Location;
import ru.netology.GeoServiceImpl;

import java.util.stream.Stream;

public class GeoServiceImpTest {
    GeoServiceImpl geoService;

    @BeforeEach
   public void geo_init() {
        geoService = new GeoServiceImpl();
    }

    @AfterEach
    public void geo_end() {
        geoService = null;
    }

    @MethodSource("source")
    @ParameterizedTest
   public void geo_test_by_name(String ip, String expected) {
        Location location = geoService.byIp(ip);
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

    //P.S
    //Юрий, подскажите в каком месседжере можно связаться с Вами по возникающим вопросам,
    //писал в дискорде, но обратной связи не было.

}
