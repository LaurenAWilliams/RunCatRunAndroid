package uk.co.lawilliams.finalproject.runcatrun.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;

import uk.co.lawilliams.finalproject.runcatrun.box2d.FloorUserData;
import uk.co.lawilliams.finalproject.runcatrun.utils.AssetsManager;
import uk.co.lawilliams.finalproject.runcatrun.utils.Constants;

/**
 * @author Lauren Williams, using tutorial by William Mora
 * @see [William Mora](http://williammora.com/a-running-game-with-libgdx-part-1)
 * <p>
 * Child of GameActor, is the floor shown at bottom of screen
 */
public class Floor extends GameActor {

    private final TextureRegion TEXTUREREGION;
    private Rectangle textureRegionBounds_1;
    private Rectangle textureRegionBounds_2;
    private int speed = 10;

    /**
     * Constructor of floor, containing two rectangles for bounds of texture, so floor appears
     * continuous
     *
     * @param body physics entity for floor
     */
    public Floor(Body body) {
        super(body);
        TEXTUREREGION = AssetsManager.getTexture(Constants.FLOOR_TEXTURE_KEY);
        textureRegionBounds_1 = new Rectangle(0 - getUserData().getWidth() / 2, 0, getUserData().getWidth(),
                getUserData().getHeight());
        textureRegionBounds_2 = new Rectangle(getUserData().getWidth() / 2, 0, getUserData().getWidth(),
                getUserData().getHeight());
    }

    /**
     * @return UserData for Floor
     */
    @Override
    public FloorUserData getUserData() {
        return (FloorUserData) userData;
    }

    /**
     * If left bound of rectangle reached, reset the bounds, else update the xbounds
     *
     * @param delta time since last frame
     */
    @Override
    public void act(float delta) {
        super.act(delta);
        if (leftBoundsReached(delta)) {
            resetBounds();
        } else {
            updateXBounds(-delta);
        }
    }

    /**
     * Draw both floor textures
     *
     * @param batch       rectangular reference to texture
     * @param parentAlpha parent's time since last frame
     */
    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(TEXTUREREGION, textureRegionBounds_1.x, screenRectangle.y, screenRectangle.getWidth(),
                screenRectangle.getHeight());
        batch.draw(TEXTUREREGION, textureRegionBounds_2.x, screenRectangle.y, screenRectangle.getWidth(),
                screenRectangle.getHeight());
    }

    /**
     * @param delta time since last frame
     * @return true if left bounds reached
     */
    private boolean leftBoundsReached(float delta) {
        return (textureRegionBounds_2.x - transformToScreen(delta * speed)) <= 0;
    }

    /**
     * Update xbounds of both texture bounds
     *
     * @param delta time since last frame
     */
    private void updateXBounds(float delta) {
        textureRegionBounds_1.x += transformToScreen(delta * speed);
        textureRegionBounds_2.x += transformToScreen(delta * speed);
    }


    /**
     * Reset bounds of second texture region bounds, set first texture bounds to have same value as
     * second texture bounds.
     */
    private void resetBounds() {
        textureRegionBounds_1 = textureRegionBounds_2;
        textureRegionBounds_2 = new Rectangle(textureRegionBounds_1.x + screenRectangle.width, 0, screenRectangle.width,
                screenRectangle.height);
    }
}
