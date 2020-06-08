package uk.co.lawilliams.finalproject.runcatrun.enums;

import org.junit.Before;
import org.junit.Test;

import uk.co.lawilliams.finalproject.runcatrun.GameTest;
import uk.co.lawilliams.finalproject.runcatrun.utils.Constants;

import static junit.framework.TestCase.assertEquals;

/**
 * @author Lauren Williams
 *         <p>
 *         Unit testing for enum enemy type
 */
public class EnemyTypeTest extends GameTest {

    private EnemyType testEnemyType;

    /**
     * Set up test enemy type
     *
     * @throws Exception if fails
     */
    @Before
    public void setUp() throws Exception {
        testEnemyType = EnemyType.BOX_ENEMY;
    }

    /**
     * Test getWidth returns 1.5f
     *
     * @throws Exception if fails
     */
    @Test
    public void testGetWidth() throws Exception {
        assertEquals(testEnemyType.getWidth(), 1.5f);
    }

    /**
     * Test getHeight returns 1.5
     *
     * @throws Exception if fails
     */
    @Test
    public void testGetHeight() throws Exception {
        assertEquals(testEnemyType.getHeight(), 1.5f);
    }

    /**
     * Test getX returns 25f
     *
     * @throws Exception if fails
     */
    @Test
    public void testGetX() throws Exception {
        assertEquals(testEnemyType.getX(), Constants.ENEMY_X);
    }

    /**
     * Test getY returns 1.5f
     *
     * @throws Exception if fails
     */
    @Test
    public void testGetY() throws Exception {
        assertEquals(testEnemyType.getY(), Constants.RUNNING_SHORT_ENEMY_Y - 0.5f);
    }

    /**
     * Test getDensity returns 0.5f
     *
     * @throws Exception if fails
     */
    @Test
    public void testGetDensity() throws Exception {
        assertEquals(testEnemyType.getDensity(), Constants.ENEMY_DENSITY);
    }

    /**
     * Test getAnimationKey returns "BoxEnemyAnimation"
     *
     * @throws Exception if fails
     */
    @Test
    public void testGetAnimationKey() throws Exception {
        assertEquals(testEnemyType.getAnimationKey(), Constants.ENEMY_BOX_ANIMATION_KEY);
    }

}