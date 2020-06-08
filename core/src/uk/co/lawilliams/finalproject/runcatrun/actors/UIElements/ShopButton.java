package uk.co.lawilliams.finalproject.runcatrun.actors.UIElements;

import com.badlogic.gdx.math.Rectangle;

import uk.co.lawilliams.finalproject.runcatrun.utils.Constants;

/**
 * @author Lauren Williams
 *         <p>
 *         Shop button for main menu to navigate to shop activity
 */
public class ShopButton extends ParentButton {

    /**
     * Interface for shop button listener
     */
    public interface ShopButtonListener {
        void onShop();
    }

    private ShopButtonListener listener;

    /**
     * Constructor for shop button, inheriting from parent button
     *
     * @param shape    bounds of button
     * @param listener listener for button
     */
    public ShopButton(Rectangle shape, ShopButtonListener listener) {
        super(shape);
        this.listener = listener;
    }

    /**
     * @return region name for atlas when button has not been pressed
     */
    @Override
    public String getRegionName() {
        return Constants.SHOP_BUTTON_REGION_NAME;
    }

    /**
     * When button is pressed, call listenener onshop function
     */
    @Override
    public void onTouch() {
        listener.onShop();
    }

    /**
     * @return region name for atlas when button has been pressed
     */
    @Override
    protected String getPressedRegionName() {
        return Constants.SHOP_BUTTON_PRESSED_REGION_NAME;
    }

}
