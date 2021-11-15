package ru.netolgy.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;
import org.openqa.selenium.Keys;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        LocalDate date = LocalDate.now().plusDays(shift);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        // TODO: добавить логику для объявления переменной date и задания её значения, для генерации строки с датой
        // Вы можете использовать класс LocalDate и его методы для получения и форматирования даты
        return date.format(formatter);
    }

    public static String generateCity(String locale) {
        Faker faker = new Faker(new Locale(locale));
        // TODO: добавить логику для объявления переменной city и задания её значения, генерацию можно выполнить
        // с помощью Faker, либо используя массив валидных городов и класс Random
        return faker.address().city();
    }

    public static String generateName(String locale) {
        Faker faker = new Faker(new Locale(locale));
        // TODO: добавить логику для объявления переменной name и задания её значения, для генерации можно
        // использовать Faker
        return faker.name().name();
    }

    public static String generatePhone(String locale) {
        Faker faker = new Faker(new Locale(locale));
        // TODO: добавить логику для объявления переменной phone и задания её значения, для генерации можно
        // использовать Faker
        return faker.phoneNumber().phoneNumber();
    }

    public static String deleteString() {
        return Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            // TODO: добавить логику для создания пользователя user с использованием методов generateCity(locale),
            // generateName(locale), generatePhone(locale)
            return new UserInfo(
                    generateCity(locale),
                    generateName(locale),
                    generatePhone(locale)
            );
        }
    }

   @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}
