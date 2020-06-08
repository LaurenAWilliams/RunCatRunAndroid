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
 *         Unit testing for play button class
 */
public class PlayButtonTest extends GameTest {

    PlayButton playButton;

    /**
     * Set up play button to test with
     *
     * @throws Exception if fails
     */
    @Before
    public void setUp() throws Exception {
        playButton = new PlayButton(new Rectangle(100, 100, 100, 100), new PlayButton.PlayButtonListener() {
            @Override
            public void onPlay() {

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
        assertEquals(playButton.getRegionName(), Constants.PLAY_BUTTON_REGION_NAME);
    }

    /**
     * Get region name for pressed texture
     *
     * @throws Exception if fails
     */
    @Test
    public void testGetPressedRegionName() throws Exception {
        assertEquals(playButton.getPressedRegionName(), Constants.PLAY_BUTTON_PRESSED_REGION_NAME);
    }

}