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
 *         Unit testing for shop button class
 */
public class ShopButtonTest extends GameTest {
    ShopButton shopButton;

    /**
     * Set up shop button for testing
     *
     * @throws Exception if fails
     */
    @Before
    public void setUp() throws Exception {
        shopButton = new ShopButton(new Rectangle(100, 100, 100, 100), new ShopButton.ShopButtonListener() {
            @Override
            public void onShop() {

            }
        });
    }

    /**
     * Get region name for non pressed texture
     *
     * @throws Exception if fails
     */
    @Test
    public void testGetRegionName() throws Exception {
        assertEquals(shopButton.getRegionName(), Constants.SHOP_BUTTON_REGION_NAME);
    }

    /**
     * Get region name for pressed texture
     *
     * @throws Exception if fails
     */
    @Test
    public void testGetPressedRegionName() throws Exception {
        assertEquals(shopButton.getPressedRegionName(), Constants.SHOP_BUTTON_PRESSED_REGION_NAME);
    }

}