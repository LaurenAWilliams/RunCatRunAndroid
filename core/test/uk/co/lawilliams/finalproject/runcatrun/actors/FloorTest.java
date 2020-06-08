package uk.co.lawilliams.finalproject.runcatrun.actors;

import com.badlogic.gdx.physics.box2d.World;

import org.junit.Before;
import org.junit.Test;

import uk.co.lawilliams.finalproject.runcatrun.GameTest;
import uk.co.lawilliams.finalproject.runcatrun.box2d.FloorUserData;
import uk.co.lawilliams.finalproject.runcatrun.utils.Constants;
import uk.co.lawilliams.finalproject.runcatrun.utils.WorldUtils;

import static junit.framework.TestCase.assertEquals;

/**
 * @author Lauren Williams
 *         <p>
 *         Unit testing for Floor class
 */
public class FloorTest extends GameTest {

    private Floor floor;

    /**
     * Sets up world and floor
     */
    @Before
    public void setUp() {
        World world = new World(Constants.WORLD_GRAVITY, true);
        floor = new Floor(WorldUtils.createFloor(world));
    }

    /**
     * Tests user data is what we expect
     *
     * @throws Exception if test fails
     */
    @Test
    public void testGetUserData() throws Exception {
        assertEquals(floor.getUserData().getHeight(), new FloorUserData(Constants.FLOOR_WIDTH, Constants.FLOOR_HEIGHT).getHeight());
        assertEquals(floor.getUserData().getWidth(), new FloorUserData(Constants.FLOOR_WIDTH, Constants.FLOOR_HEIGHT).getWidth());
    }

}