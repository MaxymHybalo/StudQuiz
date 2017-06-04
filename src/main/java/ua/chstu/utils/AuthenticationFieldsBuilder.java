package ua.chstu.utils;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class AuthenticationFieldsBuilder {


    public String buildField(){
        int numericPart = (int) Math.round(Math.random() * 100);
        return randomStringPart() + numericPart;
    }

    public String randomStringPart(){
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            s.append(Character.toString(randomChar()));
        }
        return s.toString();
    }

    public char randomChar(){
        Random r = new Random();
        char result = (char) (r.nextInt(26)+97);
        System.out.println(result);
        return result;

    }
}
