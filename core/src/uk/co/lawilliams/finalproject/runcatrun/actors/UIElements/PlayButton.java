package uk.co.lawilliams.finalproject.runcatrun.actors.UIElements;

import com.badlogic.gdx.math.Rectangle;

import uk.co.lawilliams.finalproject.runcatrun.utils.Constants;

/**
 * @author Lauren Williams
 *         <p>
 *         Button shown on main menu that starts game when pressed
 */
public class PlayButton extends ParentButton {

    /**
     * Interface for play button listener
     */
    public interface PlayButtonListener {
        void onPlay();
    }

    private PlayButtonListener listener;

    /**
     * Constructor for Play Button inheriting from Parent Button
     *
     * @param shape    bounds of the button
     * @param listener listener for the button
     */
    public PlayButton(Rectangle shape, PlayButtonListener listener) {
        super(shape);
        this.listener = listener;
    }

    /**
     * @return region name for atlas when button has not been pressed
     */
    @Override
    protected String getRegionName() {
        return Constants.PLAY_BUTTON_REGION_NAME;
    }

    /**
     * Calls onplay on listener when button is pressed
     */
    @Override
    public void onTouch() {
        listener.onPlay();
    }

    /**
     * @return region name for atlas when button has been pressed
     */
    @Override
    protected String getPressedRegionName() {
        return Constants.PLAY_BUTTON_PRESSED_REGION_NAME;
    }


}
