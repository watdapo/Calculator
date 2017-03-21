package swew17.at.calculator;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.Rule;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule <MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("swew17.at.calculator", appContext.getPackageName());
    }


    @Test
    public void testButtons() {
        for (int i = 0; i <= 9; i++) {
            onView(withText(Integer.toString(i))).perform(click());
        }


        onView(withText("+")).perform(click());
        onView(withText("-")).perform(click());
        onView(withText("*")).perform(click());
        onView(withText("/")).perform(click());
        onView(withText("=")).perform(click());
        onView(withText("C")).perform(click());
    }

    @Test
    public void testInput() {
        for (int i = 9; i >= 0; i--) {
            onView(withText(Integer.toString(i))).perform(click());
        }

        onView(withText("9876543210")).check(matches(isDisplayed()));
    }

    @Test
    public void testClear() {
        onView(withText("7")).perform(click());
        onView(withText("C")).perform(click());

        onView(withId(R.id.resultView)).check(matches(withText("")));
    }

    @Test
    public void testPlus() {
        onView(withText("7")).perform(click());
        onView(withText("+")).perform(click());
        onView(withText("9")).perform(click());
        onView(withText("=")).perform(click());

        onView(withId(R.id.resultView)).check(matches(withText("16")));
    }

    @Test
    public void testMinus() {
        onView(withText("2")).perform(click());
        onView(withText("-")).perform(click());
        onView(withText("5")).perform(click());
        onView(withText("=")).perform(click());

        onView(withId(R.id.resultView)).check(matches(withText("-3")));
    }

    @Test
    public void testMinusMul() {
        onView(withText("2")).perform(click());
        onView(withText("-")).perform(click());
        onView(withText("4")).perform(click());
        onView(withText("=")).perform(click());
        onView(withText("*")).perform(click());
        onView(withText("5")).perform(click());
        onView(withText("=")).perform(click());

        onView(withId(R.id.resultView)).check(matches(withText("-10")));
    }

    @Test
    public void testMul() {
        onView(withText("3")).perform(click());
        onView(withText("*")).perform(click());
        onView(withText("5")).perform(click());
        onView(withText("=")).perform(click());

        onView(withId(R.id.resultView)).check(matches(withText("15")));
    }

    @Test
    public void testDiv() {
        onView(withText("8")).perform(click());
        onView(withText("/")).perform(click());
        onView(withText("4")).perform(click());
        onView(withText("=")).perform(click());

        onView(withId(R.id.resultView)).check(matches(withText("2")));
    }

    @Test
    public void testDivByZero() {
        onView(withText("8")).perform(click());
        onView(withText("/")).perform(click());
        onView(withText("0")).perform(click());
        onView(withText("=")).perform(click());

        onView(withId(R.id.resultView)).check(matches(withText("NaN")));
    }


}
