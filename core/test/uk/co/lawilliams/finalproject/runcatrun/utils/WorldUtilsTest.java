package uk.co.lawilliams.finalproject.runcatrun.utils;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import org.junit.Before;
import org.junit.Test;

import uk.co.lawilliams.finalproject.runcatrun.GameTest;

import static junit.framework.TestCase.assertEquals;
import static uk.co.lawilliams.finalproject.runcatrun.utils.WorldUtils.createFloor;

/**
 * @author Lauren Williams
 *         <p>
 *         Unit testing for WorldUtils
 */
public class WorldUtilsTest extends GameTest {

    World world;

    /**
     * Set up new world
     *
     * @throws Exception if fails
     */
    @Before
    public void setUp() throws Exception {
        world = new World(Constants.WORLD_GRAVITY, true);
    }

    /**
     * testing of creating world
     *
     * @throws Exception if fails
     */
    @Test
    public void testCreateWorld() throws Exception {
        World testWorld = WorldUtils.createWorld();
        assertEquals(testWorld.getGravity(), Constants.WORLD_GRAVITY);
    }

    /**
     * Testing of creating floor
     *
     * @throws Exception if fails
     */
    @Test
    public void testCreateFloor() throws Exception {
        Body testBody = createFloor(world);
        assertEquals(testBody.getPosition(), new Vector2(Constants.FLOOR_X, Constants.FLOOR_Y));
    }

    /**
     * Testing of creating cat
     *
     * @throws Exception if fails
     */
    @Test
    public void testCreateCat() throws Exception {
        Body testBody = WorldUtils.createCat(world);
        assertEquals(testBody.getType(), BodyDef.BodyType.DynamicBody);
        assertEquals(testBody.getPosition(), new Vector2(Constants.CAT_X, Constants.CAT_Y));
        assertEquals(testBody.getGravityScale(), Constants.CAT_GRAVITY_SCALE);
    }

    /**
     * Testing creating enemy
     *
     * @throws Exception if fails
     */
    @Test
    public void testCreateEnemy() throws Exception {
        Body testBody = WorldUtils.createEnemy(world);
        assertEquals(testBody.getType(), BodyDef.BodyType.KinematicBody);
    }

}