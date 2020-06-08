package uk.co.lawilliams.finalproject.runcatrun.actors.UIElements;

import com.badlogic.gdx.math.Rectangle;

import uk.co.lawilliams.finalproject.runcatrun.utils.Constants;

/**
 * @author Lauren Williams
 *         <p>
 *         Leaderboard button shown on main menu that changes activity to leaderboard
 */
public class LeaderboardButton extends ParentButton {

    /**
     * Interface for leaderboard listener
     */
    public interface LeaderboardButtonListener {
        void onLeaderboard();
    }

    private LeaderboardButtonListener listener;

    /**
     * Constructor for leaderboard button, inheriting from parent button
     *
     * @param shape    bounds of the button
     * @param listener listener for the button
     */
    public LeaderboardButton(Rectangle shape, LeaderboardButtonListener listener) {
        super(shape);
        this.listener = listener;
    }

    /**
     * @return region name for atlas when button is not pressed
     */
    @Override
    protected String getRegionName() {
        return Constants.LEADERBOARD_BUTTON_REGION_NAME;
    }

    /**
     * Calls onLeaderboard on listener when button is pressed
     */
    @Override
    public void onTouch() {
        listener.onLeaderboard();
    }

    /**
     * @return region name for atlas when button is pressed
     */
    @Override
    protected String getPressedRegionName() {
        return Constants.LEADERBOARD_BUTTON_PRESSED_REGION_NAME;
    }

}
