package com.ecommerce.utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestDataGenerator {
    
    private static Faker faker = new Faker(new Locale("en-US"));
    
    public static String getFirstName() {
        return faker.name().firstName();
    }
    
    public static String getLastName() {
        return faker.name().lastName();
    }
    
    public static String getFullName() {
        return faker.name().fullName();
    }
    
    public static String getEmail() {
        return faker.internet().emailAddress();
    }
    
    public static String getPassword() {
        return faker.internet().password(8, 16, true, true);
    }
    
    public static String getPhoneNumber() {
        return faker.phoneNumber().phoneNumber();
    }
    
    public static String getAddress() {
        return faker.address().fullAddress();
    }
    
    public static String getCity() {
        return faker.address().city();
    }
    
    public static String getState() {
        return faker.address().state();
    }
    
    public static String getZipCode() {
        return faker.address().zipCode();
    }
    
    public static String getCompany() {
        return faker.company().name();
    }
    
    public static String getProductName() {
        return faker.commerce().productName();
    }
    
    public static String getProductDescription() {
        return faker.lorem().sentence(10);
    }
    
    public static String getCreditCardNumber() {
        return faker.finance().creditCard();
    }
    
    public static String getRandomNumber(int digits) {
        return faker.number().digits(digits);
    }
    
    public static User getRandomUser() {
        return new User(
            getFirstName(),
            getLastName(),
            getEmail(),
            getPassword(),
            getPhoneNumber()
        );
    }
    
    public static class User {
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private String phone;
        
        public User(String firstName, String lastName, String email, String password, String phone) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.password = password;
            this.phone = phone;
        }
        
        // Getters
        public String getFirstName() { return firstName; }
        public String getLastName() { return lastName; }
        public String getEmail() { return email; }
        public String getPassword() { return password; }
        public String getPhone() { return phone; }
    }
}
