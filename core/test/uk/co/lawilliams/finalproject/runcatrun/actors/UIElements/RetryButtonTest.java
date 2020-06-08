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
 *         Unit testing for retry button class.
 */
public class RetryButtonTest extends GameTest {

    RetryButton retryButton;

    /**
     * Set up retry button for testing
     *
     * @throws Exception if fails
     */
    @Before
    public void setUp() throws Exception {
        retryButton = new RetryButton(new Rectangle(100, 100, 100, 100), new RetryButton.RetryButtonListener() {
            @Override
            public void onRetry() {

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
        assertEquals(retryButton.getRegionName(), Constants.RETRY_BUTTON_REGION_NAME);
    }

    /**
     * Get region name for pressed texture
     *
     * @throws Exception if fails
     */
    @Test
    public void testGetPressedRegionName() throws Exception {
        assertEquals(retryButton.getPressedRegionName(), Constants.RETRY_BUTTON_PRESSED_REGION_NAME);
    }

}