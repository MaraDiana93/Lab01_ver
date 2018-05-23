package test.java;

import controller.ControllerSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Dell i5 on 18/05/2016.
 */
@RunWith(SerenityRunner.class)
public class webTest {


    /**
     * Created by Dell i5 on 18/05/2016.
     */


        @Steps
        public ControllerSteps steps;

        @Issue("STOCK-1")
        @Test
        public void checkTitle() {
            String pageTitle = steps.getTitle();
            assertTrue("The title of the page is correct", pageTitle.equals("Family Management"));

        }

        @Test
        public void checkTitleFail() {
            String source = steps.getTitle();
            assertEquals("The title is not correct", source.equals("Tittle"));
        }
    }

