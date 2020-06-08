package uk.co.lawilliams.finalproject.runcatrun.actors.UIElements;

import com.badlogic.gdx.math.Rectangle;

import uk.co.lawilliams.finalproject.runcatrun.utils.Constants;

/**
 * @author Lauren Williams
 *         <p>
 *         Retry button for fail overlay to restart game
 */
public class RetryButton extends ParentButton {

    /**
     * Interface for retry button listener
     */
    public interface RetryButtonListener {
        void onRetry();
    }

    private RetryButton.RetryButtonListener listener;

    /**
     * Constructor for retry button inheriting from parent button
     *
     * @param shape    bounds for retry button
     * @param listener listener for button
     */
    public RetryButton(Rectangle shape, RetryButton.RetryButtonListener listener) {
        super(shape);
        this.listener = listener;
    }

    /**
     * @return region name for atlas when button has not been pressed
     */
    @Override
    protected String getRegionName() {
        return Constants.RETRY_BUTTON_REGION_NAME;
    }

    /**
     * Calls retry on listener when pressed
     */
    @Override
    public void onTouch() {
        listener.onRetry();
    }

    /**
     * @return region name for atlas when button has been pressed
     */
    @Override
    protected String getPressedRegionName() {
        return Constants.RETRY_BUTTON_PRESSED_REGION_NAME;
    }

}
