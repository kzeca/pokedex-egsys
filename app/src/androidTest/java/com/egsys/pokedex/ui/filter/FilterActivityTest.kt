package com.egsys.pokedex.ui.filter

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.egsys.pokedex.R
import org.hamcrest.Matchers.not
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class FilterActivityTest {

    @get:Rule
    val activityRule = ActivityTestRule(FilterActivity::class.java)

    @Test
    fun contaisPokedexActionBar() {
        onView(withText("Pokedex")).check(matches(isDisplayed()))
    }

    @Test
    fun checkIfTypesListLoads() {
        onView(withText("Normal")).check(matches(isDisplayed()))
    }


}