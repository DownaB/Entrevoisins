
package com.openclassrooms.entrevoisins.neighbour_list;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourActivity;
import com.openclassrooms.entrevoisins.utils.DeleteViewAction;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withSpinnerText;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.openclassrooms.entrevoisins.utils.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.core.IsNull.notNullValue;



/**
 * Test class for list of neighbours
 */
@RunWith(AndroidJUnit4.class)
public class NeighboursListTest {

    // This is fixed
    private static int ITEMS_COUNT = 12;

    private ListNeighbourActivity mActivity;

    @Rule
    public ActivityTestRule<ListNeighbourActivity> mActivityRule =
            new ActivityTestRule(ListNeighbourActivity.class);

    @Before
    public void setUp() {
        mActivity = mActivityRule.getActivity();
        assertThat(mActivity, notNullValue());
    }

    /**
     * We ensure that our recyclerview is displaying at least on item
     */
    @Test
    public void myNeighboursList_shouldNotBeEmpty() {
        // First scroll to the position that needs to be matched and click on it.
        onView(Matchers.allOf(isDisplayed(),ViewMatchers.withId(R.id.list_neighbours)))
                .check(matches(hasMinimumChildCount(1)));
    }

    /**
     * When we delete an item, the item is no more shown
     */
    @Test
    public void myNeighboursList_deleteAction_shouldRemoveItem() {
        // Given : We remove the element at position 2
        onView(Matchers.allOf(isDisplayed(),ViewMatchers.withId(R.id.list_neighbours))).check(withItemCount(ITEMS_COUNT));
        ITEMS_COUNT--;
        // When perform a click on a delete icon
        onView(Matchers.allOf(isDisplayed(),ViewMatchers.withId(R.id.list_neighbours)))
                .perform(RecyclerViewActions.actionOnItemAtPosition(1, new DeleteViewAction()));
        // Then : the number of element is 11
        onView(Matchers.allOf(isDisplayed(),ViewMatchers.withId(R.id.list_neighbours))).check(withItemCount(ITEMS_COUNT));
    }

    @Test
    public void checkIfClickNeighbour_NewActivityLaunched() {
        onView(withId(R.id.main_content)).perform(ViewActions.swipeRight());
        onView(Matchers.allOf(isDisplayed(),ViewMatchers.withId(R.id.list_neighbours)))
                .perform(RecyclerViewActions.actionOnItemAtPosition(1, ViewActions.click()));
        onView(withId(R.id.maincontainer)).check(matches(isDisplayed()));
        onView(withId(R.id.nameNeighbour)).check(matches(withText("Jack")));
        Espresso.pressBack();
    }

    @Test
    public void checkTextView_shouldFull_checkFavoriteTab_Contains_FavoriteNeighbour() {
        onView(withId(R.id.main_content)).perform(ViewActions.swipeRight());
        onView(Matchers.allOf(isDisplayed(),ViewMatchers.withId(R.id.list_neighbours)))
                .perform(RecyclerViewActions.actionOnItemAtPosition(1,ViewActions.click()));
        onView(withId(R.id.favorite)).perform(ViewActions.click());
        Espresso.pressBack();
        onView(withId(R.id.main_content)).perform(ViewActions.swipeLeft());
      onView(Matchers.allOf(isDisplayed(),ViewMatchers.withId(R.id.list_neighbours))).check(withItemCount(1));
      onView(Matchers.allOf(isDisplayed(),ViewMatchers.withId(R.id.list_neighbours)))
              .perform(RecyclerViewActions.actionOnItemAtPosition(0,new DeleteViewAction()));
      ITEMS_COUNT--;
      onView(Matchers.allOf(isDisplayed(),ViewMatchers.withId(R.id.list_neighbours))).check(withItemCount(0));
    }
}