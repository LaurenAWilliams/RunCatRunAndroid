package uk.co.lawilliams.finalproject.runcatrun.actors.UIElements;

import com.badlogic.gdx.math.Rectangle;

import uk.co.lawilliams.finalproject.runcatrun.utils.Constants;

/**
 * @author Lauren Williams
 *         <p>
 *         Tutorial button shown on main menu to navigate to tutorial
 */
public class TutorialButton extends ParentButton {

    /**
     * Interface for tutorial button listener
     */
    public interface TutorialButtonListener {
        void onTutorial();
    }

    private TutorialButtonListener listener;

    /**
     * Constructor for the tutorial button inheriting from parent button
     *
     * @param shape    bounds for button
     * @param listener listener for button
     */
    public TutorialButton(Rectangle shape, TutorialButtonListener listener) {
        super(shape);
        this.listener = listener;
    }

    /**
     * @return region name for atlas when hasn't been pressed
     */
    @Override
    protected String getRegionName() {
        return Constants.TUTORIAL_BUTTON_REGION_NAME;
    }

    /**
     * when onTouch is called, call listener
     */
    @Override
    public void onTouch() {
        listener.onTutorial();
    }

    /**
     * @return region name for atlas when has been pressed
     */
    @Override
    protected String getPressedRegionName() {
        return Constants.TUTORIAL_BUTTON_PRESSED_REGION_NAME;
    }

}
