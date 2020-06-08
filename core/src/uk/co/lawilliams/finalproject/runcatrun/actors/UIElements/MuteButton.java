package uk.co.lawilliams.finalproject.runcatrun.actors.UIElements;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import uk.co.lawilliams.finalproject.runcatrun.utils.Constants;

/**
 * @author Lauren Williams
 *         <p>
 *         Button shown on main menu that mutes audio when pressed
 */

public class MuteButton extends ParentButton {

    private boolean buttonPressed = true;
    private MuteButtonListener listener;

    /**
     * Constructor for ParentButton, with style to change look of button when pressed.
     *
     * @param shape bounds of the button
     */
    public MuteButton(Rectangle shape, MuteButtonListener listener) {
        super(shape);
        this.listener = listener;

        addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Skin skin = new Skin();
                TextureAtlas buttonsAtlas = new TextureAtlas(Constants.BUTTONS_ATLAS_PATH);
                skin.addRegions(buttonsAtlas);
                ButtonStyle style = new ButtonStyle();

                if (buttonPressed) {
                    buttonPressed = false;
                    style.up = skin.getDrawable(getPressedRegionName());
                } else {
                    buttonPressed = true;
                    style.up = skin.getDrawable(getRegionName());
                }

                setStyle(style);
                return true;
            }
        });
    }

    /**
     * @return the region name of the texture
     */
    @Override
    protected String getRegionName() {
        return Constants.SOUND_ON_BUTTON_REGION_NAME;
    }

    /**
     * When the button is touched..
     */
    @Override
    public void onTouch() {
        listener.onMute();
    }

    /**
     *
     * @return the region name of the texture when pressed
     */
    @Override
    protected String getPressedRegionName() {
        return Constants.SOUND_OFF_BUTTON_REGION_NAME;
    }

    /**
     * interface for mute button
     */
    public interface MuteButtonListener {
        void onMute();
    }
}
