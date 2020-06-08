package uk.co.lawilliams.finalproject.runcatrun.utils;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import org.junit.Before;
import org.junit.Test;

import uk.co.lawilliams.finalproject.runcatrun.GameTest;
import uk.co.lawilliams.finalproject.runcatrun.box2d.CatUserData;
import uk.co.lawilliams.finalproject.runcatrun.box2d.EnemyUserData;
import uk.co.lawilliams.finalproject.runcatrun.box2d.FloorUserData;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Lauren Williams
 *         <p>
 *         Unit testing for BodyUtils class
 */
public class BodyUtilsTest extends GameTest {

    Body body;

    /**
     * Set up world, bodydef and body
     *
     * @throws Exception if fails
     */
    @Before
    public void setUp() throws Exception {
        World world = new World(Constants.WORLD_GRAVITY, true);
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.KinematicBody;
        bodyDef.position.set(new Vector2(100, 150));
        body = world.createBody(bodyDef);
    }

    /**
     * Test if true when body should be in bounds, false when not
     *
     * @throws Exception if fails
     */
    @Test
    public void testBodyInBounds() throws Exception {
        body.setUserData(new EnemyUserData(200, 250, "Test"));
        assertTrue(BodyUtils.bodyInBounds(body));
        body.setUserData(new EnemyUserData(-200, -250, "Test"));
        assertFalse(BodyUtils.bodyInBounds(body));
    }

    /**
     * Test only when body is enemy that true is returned
     *
     * @throws Exception if fails
     */
    @Test
    public void testBodyIsEnemy() throws Exception {
        body.setUserData(new EnemyUserData(200, 250, "Test"));
        assertTrue(BodyUtils.bodyIsEnemy(body));
        body.setUserData(new CatUserData(200, 250));
        assertFalse(BodyUtils.bodyIsEnemy(body));
        body.setUserData(new FloorUserData(200, 250));
        assertFalse(BodyUtils.bodyIsEnemy(body));
    }

    /**
     * Test only when body is cat that true is returned
     *
     * @throws Exception if fails
     */
    @Test
    public void testBodyIsCat() throws Exception {
        body.setUserData(new CatUserData(200, 250));
        assertTrue(BodyUtils.bodyIsCat(body));
        body.setUserData(new EnemyUserData(200, 250, "Test"));
        assertFalse(BodyUtils.bodyIsCat(body));
        body.setUserData(new FloorUserData(200, 250));
        assertFalse(BodyUtils.bodyIsCat(body));
    }

    /**
     * Test only when body is floor that true is returned
     *
     * @throws Exception if fails
     */
    @Test
    public void testBodyIsFloor() throws Exception {
        body.setUserData(new FloorUserData(200, 250));
        assertTrue(BodyUtils.bodyIsFloor(body));
        body.setUserData(new EnemyUserData(200, 250, "Test"));
        assertFalse(BodyUtils.bodyIsFloor(body));
        body.setUserData(new CatUserData(200, 250));
        assertFalse(BodyUtils.bodyIsFloor(body));
    }

}