package uk.co.lawilliams.finalproject.runcatrun.actors.UIElements;

import com.badlogic.gdx.math.Rectangle;

import org.junit.Before;
import org.junit.Test;

import uk.co.lawilliams.finalproject.runcatrun.GameTest;
import uk.co.lawilliams.finalproject.runcatrun.utils.Constants;

import static junit.framework.TestCase.assertEquals;

/**
 * @author Lauren Williams
 *         <p>
 *         Unit testing for tutorial button class
 */
public class TutorialButtonTest extends GameTest {
    TutorialButton tutorialButton;

    /**
     * Set up tutorial button for testing
     *
     * @throws Exception if fails
     */
    @Before
    public void setUp() throws Exception {
        tutorialButton = new TutorialButton(new Rectangle(100, 100, 100, 100), new TutorialButton.TutorialButtonListener() {
            @Override
            public void onTutorial() {

            }
        });
    }

    /**
     * Get region name for non pressed texture
     *
     * @throws Exception if fails
     */
    @Test
    public void testGetRegionName() throws Exception {
        assertEquals(tutorialButton.getRegionName(), Constants.TUTORIAL_BUTTON_REGION_NAME);
    }

    /**
     * Get region name for pressed texture
     *
     * @throws Exception if fails
     */
    @Test
    public void testGetPressedRegionName() throws Exception {
        assertEquals(tutorialButton.getPressedRegionName(), Constants.TUTORIAL_BUTTON_PRESSED_REGION_NAME);
    }

}