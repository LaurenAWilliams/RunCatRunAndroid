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
 *         Unit testing for mute button class
 */
public class MuteButtonTest extends GameTest {

    MuteButton muteButton;

    /**
     * Set up mute button for testing
     *
     * @throws Exception if fails
     */
    @Before
    public void setUp() throws Exception {
        muteButton = new MuteButton(new Rectangle(100, 100, 100, 100), new MuteButton.MuteButtonListener() {
            @Override
            public void onMute() {

            }
        });
    }

    /**
     * Get region name for texture
     *
     * @throws Exception if fails
     */
    @Test
    public void testGetRegionName() throws Exception {
        assertEquals(muteButton.getRegionName(), Constants.SOUND_ON_BUTTON_REGION_NAME);
    }

    /**
     * Get pressed region name for texture
     *
     * @throws Exception if fails
     */
    @Test
    public void testGetPressedRegionName() throws Exception {
        assertEquals(muteButton.getPressedRegionName(), Constants.SOUND_OFF_BUTTON_REGION_NAME);
    }

}