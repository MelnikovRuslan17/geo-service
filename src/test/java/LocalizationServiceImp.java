import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationServiceImpl;

public class LocalizationServiceImp {
    LocalizationServiceImpl sut;

    @BeforeEach
    void start_each() {
        sut = new LocalizationServiceImpl();

    }

    @AfterEach
    void end_each() {
        sut = null;
    }
    @ParameterizedTest
    @EnumSource(value = Country.class, names = {"GERMANY", "USA", "BRAZIL"})
    void testLocate(Country country){
        String result = sut.locale(country);
        String expected = "Welcome";
        Assertions.assertEquals(expected, result);
    }
}


