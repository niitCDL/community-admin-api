package com.soft2242.one.convert;

import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Author : xuelong
 * @program
 * @description
 * @create 2023/5/28 11:44
 */
@Component
@Named("MyMapper")
public class MyMapper {

    @Named("convertToArray")
     public String[] convertToArray(String input) {
        if (input == null) {
            return null;
        }
        return input.split(",");
    }
    @Named("convertToString")
    public String convertToString(String[] input) {
        if (input == null || input.length == 0) {
            return null;
        }

        return String.join(",", input);
    }


}
