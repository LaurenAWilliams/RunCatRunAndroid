package uk.co.lawilliams.finalproject.runcatrun.actors;

import com.badlogic.gdx.physics.box2d.World;

import org.junit.Before;
import org.junit.Test;

import uk.co.lawilliams.finalproject.runcatrun.GameTest;
import uk.co.lawilliams.finalproject.runcatrun.box2d.CatUserData;
import uk.co.lawilliams.finalproject.runcatrun.utils.Constants;
import uk.co.lawilliams.finalproject.runcatrun.utils.WorldUtils;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Lauren Williams
 *         <p>
 *         Unit test set for Cat class.
 */
public class CatTest extends GameTest {

    private Cat cat;

    /**
     * Set up for testing.
     */
    @Before
    public void setUp() {
        World world = new World(Constants.WORLD_GRAVITY, true);
        cat = new Cat(WorldUtils.createCat(world));
    }

    /**
     * Tests user data made in cat constructor matches what we expect.
     *
     * @throws Exception if fails
     */
    @Test
    public void testGetUserData() throws Exception {
        assertEquals(cat.getUserData().getJumpingLinearImpulse(), new CatUserData(Constants.CAT_WIDTH, Constants.CAT_HEIGHT).getJumpingLinearImpulse());
        assertEquals(cat.getUserData().getHitAngularImpulse(), new CatUserData(Constants.CAT_WIDTH, Constants.CAT_HEIGHT).getHitAngularImpulse());
        assertEquals(cat.getUserData().getHeight(), new CatUserData(Constants.CAT_WIDTH, Constants.CAT_HEIGHT).getHeight());
        assertEquals(cat.getUserData().getWidth(), new CatUserData(Constants.CAT_WIDTH, Constants.CAT_HEIGHT).getWidth());
    }

    /**
     * Test isHit returns initially false, then after a hit returns true.
     *
     * @throws Exception if fails
     */
    @Test
    public void testIsHit() throws Exception {
        assertFalse(cat.isHit());
        cat.hit();
        assertTrue(cat.isHit());
    }

    /**
     * Test updateRectangle returns 32 * n
     */
    @Test
    public void testUpdateRectangle() throws Exception {
        float n = 10f;
        assertEquals(cat.transformToScreen(n), Constants.WORLD_TO_SCREEN * n);
    }

}