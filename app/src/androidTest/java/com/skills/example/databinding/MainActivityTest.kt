package com.skills.example.databinding

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {


    /**
     * ActivityScenarioRule<MainActivity>: This is the rule itself.
     * ActivityScenarioRule is a class that provides lifecycle methods to start and stop your activity.
     * By specifying MainActivity.class,
     * you're telling ActivityScenarioRule to manage an instance of MainActivity for testing purposes.
     *
     */
    @JvmField
    @Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun checkViewsIsDisplayed() {
        onView(withId(R.id.tv_greeting)).check(matches(isDisplayed()))
        onView(withId(R.id.et_enter_name)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_submit)).check(matches(isDisplayed()))
    }

    @Test
    fun whenUserEntersName_andClicksButton_textViewDisplaysGreeting() {
        val name = "Ahmed"

        onView(withId(R.id.et_enter_name)).perform(typeText(name), closeSoftKeyboard())
        onView((withId(R.id.btn_submit))).perform(click())

        onView(withId(R.id.tv_greeting)).check(matches(withText("Hi, Ahmed")))
    }
}