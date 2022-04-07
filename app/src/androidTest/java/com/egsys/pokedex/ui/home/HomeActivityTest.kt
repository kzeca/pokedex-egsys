package com.egsys.pokedex.ui.home


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.egsys.pokedex.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class HomeActivityTest {

    @get:Rule
    val activityRule = ActivityTestRule(HomeActivity::class.java)

    @Test
    fun contaisPokedexActionBar() {
        onView(withText("Pokedex")).check(matches(isDisplayed()))
    }

    @Test
    fun checkFloatActionButtonMenu() {
        onView(withId(R.id.btnMenu)).perform(click())
        onView(withId(R.id.btnRandom)).check(matches(isDisplayed()))
        onView(withId(R.id.btnFilter)).check(matches(isDisplayed()))
        onView(withId(R.id.btnSearch)).check(matches(isDisplayed()))
    }

    @Test
    fun goToARandomPokemon(){
        onView(withId(R.id.btnMenu)).perform(click())
        onView(withId(R.id.btnRandom)).perform(click())
    }

    @Test
    fun openTypeFilterList(){
        onView(withId(R.id.btnMenu)).perform(click())
        onView(withId(R.id.btnFilter)).perform(click())
    }

    @Test
    fun checkIfPokemonListAppers() {
        onView(withText("Bulbasaur")).check(matches(isDisplayed()))
    }

    @Test
    fun openSearchMenuAndSearchAPokemon(){
        val pokemon = "Pikachu"
        onView(withId(R.id.btnMenu)).perform(click())
        onView(withId(R.id.btnSearch)).perform(click())
        onView(withId(R.id.etSearch)).perform(ViewActions.typeText(pokemon))
        onView(withId(R.id.btnSearchPokemon)).perform(click())
    }

    @Test
    fun openSearchMenuAndSearchAInvalidPokemon(){
        val pokemon = "Pikachuu"
        onView(withId(R.id.btnMenu)).perform(click())
        onView(withId(R.id.btnSearch)).perform(click())
        onView(withId(R.id.etSearch)).perform(ViewActions.typeText(pokemon))
        onView(withId(R.id.btnSearchPokemon)).perform(click())
    }

    @Test
    fun openSearchMenuAndSearchWithInvalidCharacters(){
        val pokemon = "Pikachuu123"
        onView(withId(R.id.btnMenu)).perform(click())
        onView(withId(R.id.btnSearch)).perform(click())
        onView(withId(R.id.etSearch)).perform(ViewActions.typeText(pokemon))
        onView(withId(R.id.btnSearchPokemon)).perform(click())
        onView(withText("Only accepts letters")).check(matches(isDisplayed()))
    }

}