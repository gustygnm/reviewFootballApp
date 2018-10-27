package com.gnm.finalprojek

import android.support.test.espresso.Espresso.onView
import com.gnm.finalprojek.activities.MainActivity
import org.junit.Rule
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule

import com.gnm.finalprojek.R.id.*
import org.junit.Test

class IntrumentTest {
//	@Rule
//	@JvmField var actRule = ActivityTestRule(MainActivity::class.java)
	@Rule
	@JvmField var actRule = ActivityTestRule(MainActivity::class.java)

	@Test
	fun TestAppBehavior(){
		onView(withId(navigate)).check(matches(isDisplayed()))
		onView(withId(navigate)).perform(click())
		onView(withId(spinnerLiga)).check(matches(isDisplayed()))
		onView(withId(recTeam)).check(matches(isDisplayed()))
		onView(withId(search)).check(matches(isDisplayed()))
		onView(withId(search)).perform(click())
		onView(withId(searchEdit)).check(matches(isDisplayed()))
		onView(withId(recSearch)).check(matches(isDisplayed()))
		onView(withId(recSearch)).perform(click())
	}
}