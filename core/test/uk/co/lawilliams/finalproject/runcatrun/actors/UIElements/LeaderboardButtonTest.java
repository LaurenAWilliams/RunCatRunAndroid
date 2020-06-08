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
 *         Unit testing for LeaderboardButton class
 */
public class LeaderboardButtonTest extends GameTest {

    LeaderboardButton leaderboardButton;

    /**
     * Set up the leaderboard button we are testing on
     *
     * @throws Exception if fails
     */
    @Before
    public void setUp() throws Exception {
        leaderboardButton = new LeaderboardButton(new Rectangle(100, 100, 100, 100), new LeaderboardButton.LeaderboardButtonListener() {
            @Override
            public void onLeaderboard() {
            }
        });
    }

    /**
     * Test get region name for texture
     *
     * @throws Exception if fails
     */
    @Test
    public void testGetRegionName() throws Exception {
        assertEquals(leaderboardButton.getRegionName(), Constants.LEADERBOARD_BUTTON_REGION_NAME);
    }

    /**
     * Test get pressed region name for texture
     *
     * @throws Exception if fails
     */
    @Test
    public void testGetPressedRegionName() throws Exception {
        assertEquals(leaderboardButton.getPressedRegionName(), Constants.LEADERBOARD_BUTTON_PRESSED_REGION_NAME);
    }

}