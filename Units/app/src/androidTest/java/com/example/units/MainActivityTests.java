package com.example.units;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

public class MainActivityTests {
    @Rule public ActivityScenarioRule<MainActivity> activityScenario = new ActivityScenarioRule<MainActivity>(MainActivity.class);
    @Test
    public void test_100C_shouldBecome_212F(){
        //given
        onView(withId(R.id.edit_input)).perform(clearText(), typeText("100"));
        onView(withId(R.id.btn_convert)).perform(click());
        onView(withId(R.id.txt_output)).check(matches(withText("212.0")));
    }
}
