package uk.co.lawilliams.finalproject.runcatrun.box2d;


import org.junit.Before;
import org.junit.Test;

import uk.co.lawilliams.finalproject.runcatrun.GameTest;
import uk.co.lawilliams.finalproject.runcatrun.enums.UserDataType;
import uk.co.lawilliams.finalproject.runcatrun.utils.Constants;

import static junit.framework.TestCase.assertEquals;

/**
 * @author Lauren Williams
 *         <p>
 *         Unit testing for EnemyUserData class.
 */
public class EnemyUserDataTest extends GameTest {

    private EnemyUserData enemyUserData;

    @Before
    public void setUp() throws Exception {
        enemyUserData = new EnemyUserData(100f, 150f, Constants.ENEMY_CAR_ANIMATION_KEY);
    }

    @Test
    public void testGetLinearVelocity() throws Exception {
        assertEquals(enemyUserData.getLinearVelocity(), Constants.ENEMY_LINEAR_VELOCITY);
    }

    @Test
    public void testGetAnimationKey() throws Exception {
        assertEquals(enemyUserData.getAnimationKey(), Constants.ENEMY_CAR_ANIMATION_KEY);
    }

    @Test
    public void testGetUserDataType() throws Exception {
        assertEquals(enemyUserData.getUserDataType(), UserDataType.ENEMY);
    }

    @Test
    public void testGetWidth() throws Exception {
        assertEquals(enemyUserData.getWidth(), 100f);
    }

    @Test
    public void testGetHeight() throws Exception {
        assertEquals(enemyUserData.getHeight(), 150f);
    }

}