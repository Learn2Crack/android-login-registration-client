package com.learn2crack.loginregistration;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class RegistrationTest {

    private String mName;
    private String mEmail;
    private String mPassword;
    private String mSuccessString;
    private String mExistsString;
    private String mEmptyFieldsString;
    private String mInvalidEmailString;

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void initVariables(){

        mName = "Raj Amal W";
        mEmail = "raj.amalw@gmail.com";
        mPassword = "rajamalw";
        mSuccessString = "User Registered Successfully !";
        mExistsString = "User Already Registered !";
        mEmptyFieldsString = "Fields are empty !";
        mInvalidEmailString = "Invalid Email";
    }

    @Test
    public void test1CheckRegisterSuccess(){

        onView(withId(R.id.tv_register)).perform(click());

        onView(withId(R.id.et_name)).perform(typeText(mName));

        closeSoftKeyboard();

        onView(withId(R.id.et_email)).perform(typeText(mEmail));

        closeSoftKeyboard();

        onView(withId(R.id.et_password)).perform(typeText(mPassword));

        closeSoftKeyboard();

        onView(withId(R.id.btn_register)).perform(click());

        onView(allOf(withId(android.support.design.R.id.snackbar_text), withText(mSuccessString))).check(matches(isDisplayed()));


    }

    @Test
    public void test2CheckDuplicateRegister(){

        onView(withId(R.id.tv_register)).perform(click());

        onView(withId(R.id.et_name)).perform(typeText(mName));

        closeSoftKeyboard();

        onView(withId(R.id.et_email)).perform(typeText(mEmail));

        closeSoftKeyboard();

        onView(withId(R.id.et_password)).perform(typeText(mPassword));

        closeSoftKeyboard();

        onView(withId(R.id.btn_register)).perform(click());

        onView(allOf(withId(android.support.design.R.id.snackbar_text), withText(mExistsString))).check(matches(isDisplayed()));
    }

    @Test
    public void test3CheckInvalidEmail(){

        onView(withId(R.id.tv_register)).perform(click());

        onView(withId(R.id.et_name)).perform(typeText(mName));

        closeSoftKeyboard();

        onView(withId(R.id.et_email)).perform(typeText(mName));

        closeSoftKeyboard();

        onView(withId(R.id.et_password)).perform(typeText(mPassword));

        closeSoftKeyboard();

        onView(withId(R.id.btn_register)).perform(click());

        onView(allOf(withId(android.support.design.R.id.snackbar_text), withText(mInvalidEmailString))).check(matches(isDisplayed()));
    }

    @Test
    public void test4CheckFieldsEmpty(){

        onView(withId(R.id.tv_register)).perform(click());

        onView(withId(R.id.btn_register)).perform(click());

        onView(allOf(withId(android.support.design.R.id.snackbar_text), withText(mEmptyFieldsString))).check(matches(isDisplayed()));

    }

}
