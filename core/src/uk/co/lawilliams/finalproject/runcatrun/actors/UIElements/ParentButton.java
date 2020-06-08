package uk.co.lawilliams.finalproject.runcatrun.actors.UIElements;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import uk.co.lawilliams.finalproject.runcatrun.utils.Constants;

/**
 * @author Lauren Williams
 *
 * Parent class of all buttons
 */

abstract class ParentButton extends Button {

    private Skin skin;

    /**
     * Constructor for ParentButton, with style to change look of button when pressed.
     *
     * @param shape bounds of the button
     */
    ParentButton(Rectangle shape) {
        setWidth(shape.width);
        setHeight(shape.height);
        setBounds(shape.x, shape.y, shape.width, shape.height);
        TextureAtlas buttonsAtlas = new TextureAtlas(Constants.BUTTONS_ATLAS_PATH);
        skin = new Skin();
        skin.addRegions(buttonsAtlas);
        ButtonStyle style = new ButtonStyle();
        style.up = skin.getDrawable(getRegionName());
        setStyle(style);

        addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                onTouch();
                ButtonStyle style = new ButtonStyle();
                style.up = skin.getDrawable(getPressedRegionName());
                setStyle(style);
                return true;
            }
        });
    }

    /**
     *
     * @return texture region name when hasn't been pressed
     */
    protected abstract String getRegionName();

    /**
     * When button is pressed
     */
    public abstract void onTouch();

    /**
     *
     * @return texture region name when has been pressed
     */
    protected abstract String getPressedRegionName();

}
