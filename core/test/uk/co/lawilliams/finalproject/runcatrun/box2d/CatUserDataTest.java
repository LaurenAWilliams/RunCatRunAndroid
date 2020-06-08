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
 *         Unit testing for CatUserData class.
 */
public class CatUserDataTest extends GameTest {

    private CatUserData catUserData;

    /**
     * Set up cat user data
     *
     * @throws Exception if fails
     */
    @Before
    public void setUp() throws Exception {
        catUserData = new CatUserData(100f, 150f);
    }

    /**
     * Test constructor sets jumping linear impulse correctly
     *
     * @throws Exception if fails
     */
    @Test
    public void testGetJumpingLinearImpulse() throws Exception {
        assertEquals(catUserData.getJumpingLinearImpulse(), Constants.CAT_JUMPING_LINEAR_IMPULSE);
    }

    /**
     * Test constructor sets hit angular impulse correctly
     *
     * @throws Exception if fails
     */
    @Test
    public void testGetHitAngularImpulse() throws Exception {
        assertEquals(catUserData.getHitAngularImpulse(), Constants.CAT_HIT_ANGULAR_IMPULSE);
    }

    /**
     * Test constructor sets user data type correctly
     *
     * @throws Exception if fails
     */
    @Test
    public void testGetUserDataType() throws Exception {
        assertEquals(catUserData.getUserDataType(), UserDataType.CAT);
    }

    /**
     * Test getWidth functions correctly
     *
     * @throws Exception if fails
     */
    @Test
    public void testGetWidth() throws Exception {
        assertEquals(catUserData.getWidth(), 100f);
    }

    /**
     * Test getHeight functions correctly
     *
     * @throws Exception if fails
     */
    @Test
    public void testGetHeight() throws Exception {
        assertEquals(catUserData.getHeight(), 150f);
    }

}