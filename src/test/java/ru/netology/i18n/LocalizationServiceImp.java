package ru.netology.i18n;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationServiceImpl;

public class LocalizationServiceImp {
    private LocalizationServiceImpl localizationService;

    @BeforeEach
    public void localization_init() {
        localizationService = new LocalizationServiceImpl();

    }
    @AfterEach
    public void localization_end() {
        localizationService = null;
    }
    @ParameterizedTest
    @EnumSource(value = Country.class, names = {"GERMANY", "USA", "BRAZIL"})
    public void testLocate(Country country){
        String result = localizationService.locale(country);
        String expected = "Welcome";
        Assertions.assertEquals(expected, result);
    }
    @Test
    public void localization_test_only_rus(){
        Country country = Country.RUSSIA;
        String result = localizationService.locale(country);
        String expected = "Добро пожаловать";
        Assertions.assertEquals(expected, result);
    }
}


