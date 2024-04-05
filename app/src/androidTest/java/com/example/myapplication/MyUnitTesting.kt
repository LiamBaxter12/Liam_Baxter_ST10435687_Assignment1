@file:Suppress("UNUSED_EXPRESSION")

package com.example.myapplication

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest {

    @Before
    fun setUp() {
        ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun enterValidAge_DisplayHistoricalFigure() {
        val validAge = "76"
        val expectedHistoricalFigure = "Albert Einstein"

        Espresso.onView(withId(R.id.numberText))
            .perform(ViewActions.typeText(validAge), ViewActions.closeSoftKeyboard())

        Espresso.onView(withId(R.id.Generate))
            .perform(ViewActions.click())

        Espresso.onView(withId(R.id.editHistoryText))
            .check(matches(withText("You are the same age as $expectedHistoricalFigure who is a famous historical figure")))
    }

    @Test
    fun enterInvalidAge_DisplayErrorMessage() {
        ""
        val expectedErrorMessage = "Please enter an age"

        Espresso.onView(withId(R.id.numberText))
            .perform(ViewActions.clearText(), ViewActions.closeSoftKeyboard())

        Espresso.onView(withId(R.id.Generate))
            .perform(ViewActions.click())

        Espresso.onView(withId(R.id.editHistoryText))
            .check(matches(withText(expectedErrorMessage)))
    }

    // Add more test cases as needed for different scenarios
}
