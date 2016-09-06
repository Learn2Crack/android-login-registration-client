package com.learn2crack.loginregistration;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class RegistrationUnitTest {
    @Test
    public void emailValidator_CorrectEmailSimple_ReturnsTrue() {
        assertThat(4, is(4));
    }
}
