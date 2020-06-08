package uk.co.lawilliams.finalproject.runcatrun.box2d;


import org.junit.Before;
import org.junit.Test;

import uk.co.lawilliams.finalproject.runcatrun.GameTest;
import uk.co.lawilliams.finalproject.runcatrun.enums.UserDataType;

import static junit.framework.TestCase.assertEquals;

/**
 * @author Lauren Williams
 *         <p>
 *         Unit testing for FloorUserData class.
 */
public class FloorUserDataTest extends GameTest {

    private FloorUserData floorUserData;

    /**
     * Set up floor user data
     *
     * @throws Exception if fails
     */
    @Before
    public void setUp() throws Exception {
        floorUserData = new FloorUserData(100f, 150f);
    }

    /**
     * Test getUserDataType returns floor user data type
     *
     * @throws Exception if fails
     */
    @Test
    public void testGetUserDataType() throws Exception {
        assertEquals(floorUserData.getUserDataType(), UserDataType.FLOOR);
    }

    /**
     * Test getWidth returns 100f
     *
     * @throws Exception if fails
     */
    @Test
    public void testGetWidth() throws Exception {
        assertEquals(floorUserData.getWidth(), 100f);
    }

    /**
     * Test getHeight returns 150f
     *
     * @throws Exception if fails
     */
    @Test
    public void testGetHeight() throws Exception {
        assertEquals(floorUserData.getHeight(), 150f);
    }

}