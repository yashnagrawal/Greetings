package com.example.units;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class TempretureConverterTest {
    @Test
    public void fahrenheitToCelcius_32_is_0C(){
        //given
        double input = 32.0;

        //when
        double output=TempretureConverter.fahrenheitToCelcius(input);

        //then
        assertThat(output, is(0.00));
    }

    @Test
    public void fahrenheitToCelcius_212_is_100C(){
        //
        double input = 212.0;

        // when
        double output=TempretureConverter.fahrenheitToCelcius(input);

        //then
        assertThat(output, is(100.0));
    }
}
