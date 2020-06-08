package uk.co.lawilliams.finalproject.runcatrun.box2d;

import org.junit.Before;
import org.junit.Test;

import uk.co.lawilliams.finalproject.runcatrun.GameTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Lauren Williams
 *         <p>
 *         Unit testing for UserData class
 */
public class UserDataTest extends GameTest {

    private UserData userData;

    /**
     * Set up user data
     *
     * @throws Exception if fails
     */
    @Before
    public void setUp() throws Exception {
        userData = new UserData(100f, 150f);
    }

    /**
     * Check user data is null
     *
     * @throws Exception if fails
     */
    @Test
    public void testGetUserDataType() throws Exception {
        assertNull(userData.getUserDataType());
    }

    /**
     * Check width is 100f
     *
     * @throws Exception if fails
     */
    @Test
    public void testGetWidth() throws Exception {
        assertEquals(userData.getWidth(), 100f, 0);
    }

    /**
     * Check height is 150f
     *
     * @throws Exception if fails
     */
    @Test
    public void testGetHeight() throws Exception {
        assertEquals(userData.getHeight(), 150f, 0);
    }

}