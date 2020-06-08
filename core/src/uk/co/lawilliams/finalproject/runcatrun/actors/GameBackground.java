package uk.co.lawilliams.finalproject.runcatrun.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

import uk.co.lawilliams.finalproject.runcatrun.utils.AssetsManager;
import uk.co.lawilliams.finalproject.runcatrun.utils.Constants;

/**
 * @author Lauren Williams, using tutorial by William Mora
 * @see [William Mora](http://williammora.com/a-running-game-with-libgdx-part-1)
 * <p>
 * Background used during game, has parallax effect
 */

public class GameBackground extends Actor {

    private final TextureRegion TEXTUREREGION_1;
    private final TextureRegion TEXTUREREGION_2;
    private final TextureRegion TEXTUREREGION_3;
    private final TextureRegion TEXTUREREGION_4;
    private Rectangle textureRegionBounds1_1;
    private Rectangle textureRegionBounds2_1;
    private Rectangle textureRegionBounds1_2;
    private Rectangle textureRegionBounds2_2;
    private Rectangle textureRegionBounds1_3;
    private Rectangle textureRegionBounds2_3;
    private int speed_1 = 200;
    private int speed_2 = 120;
    private int speed_3 = 160;

    /**
     * Constructor for GameBackground, initialising textures and texture rectangles
     */
    public GameBackground() {
        TEXTUREREGION_1 = AssetsManager.getTexture(Constants.BACKGROUND_1_TEXTURE_KEY);
        TEXTUREREGION_2 = AssetsManager.getTexture(Constants.BACKGROUND_2_TEXTURE_KEY);
        TEXTUREREGION_3 = AssetsManager.getTexture(Constants.BACKGROUND_3_TEXTURE_KEY);
        TEXTUREREGION_4 = AssetsManager.getTexture(Constants.BACKGROUND_4_TEXTURE_KEY);
        textureRegionBounds1_1 = new Rectangle(0 - Constants.APP_WIDTH / 2, 0, Constants.APP_WIDTH, Constants.APP_HEIGHT);
        textureRegionBounds2_1 = new Rectangle(Constants.APP_WIDTH / 2, 0, Constants.APP_WIDTH, Constants.APP_HEIGHT);
        textureRegionBounds1_2 = new Rectangle(0 - Constants.APP_WIDTH / 2, 0, Constants.APP_WIDTH, Constants.APP_HEIGHT);
        textureRegionBounds2_2 = new Rectangle(Constants.APP_WIDTH / 2, 0, Constants.APP_WIDTH, Constants.APP_HEIGHT);
        textureRegionBounds1_3 = new Rectangle(0 - Constants.APP_WIDTH / 2, 0, Constants.APP_WIDTH, Constants.APP_HEIGHT);
        textureRegionBounds2_3 = new Rectangle(Constants.APP_WIDTH / 2, 0, Constants.APP_WIDTH, Constants.APP_HEIGHT);

    }

    /**
     * If left bound of any of the background images is reached, reset the image so it starts at the
     * beginning again
     *
     * @param delta time since last frame
     */
    @Override
    public void act(float delta) {
        if (leftBoundsReached_1(delta)) {
            resetBounds_1();
        } else if (leftBoundsReached_2(delta)) {
            resetBounds_2();
        } else if (leftBoundsReached_3(delta)) {
            resetBounds_3();
        } else {
            updateXBounds_1(-delta);
            updateXBounds_2(-delta);
            updateXBounds_3(-delta);
        }
    }

    /**
     * draw the individual background images
     *
     * @param batch       2D rectangles that reference a texture
     * @param parentAlpha parent's time since last frame
     */
    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(TEXTUREREGION_1, textureRegionBounds1_1.x, textureRegionBounds1_1.y, Constants.APP_WIDTH,
                Constants.APP_HEIGHT);
        batch.draw(TEXTUREREGION_1, textureRegionBounds2_1.x, textureRegionBounds2_1.y, Constants.APP_WIDTH,
                Constants.APP_HEIGHT);
        batch.draw(TEXTUREREGION_2, textureRegionBounds1_2.x, textureRegionBounds1_2.y, Constants.APP_WIDTH,
                Constants.APP_HEIGHT);
        batch.draw(TEXTUREREGION_2, textureRegionBounds2_2.x, textureRegionBounds2_2.y, Constants.APP_WIDTH,
                Constants.APP_HEIGHT);
        batch.draw(TEXTUREREGION_3, textureRegionBounds1_3.x, textureRegionBounds1_3.y, Constants.APP_WIDTH,
                Constants.APP_HEIGHT);
        batch.draw(TEXTUREREGION_3, textureRegionBounds2_3.x, textureRegionBounds2_3.y, Constants.APP_WIDTH,
                Constants.APP_HEIGHT);
        batch.draw(TEXTUREREGION_4, textureRegionBounds1_1.x, textureRegionBounds1_1.y, Constants.APP_WIDTH,
                Constants.APP_HEIGHT);
        batch.draw(TEXTUREREGION_4, textureRegionBounds2_1.x, textureRegionBounds2_1.y, Constants.APP_WIDTH,
                Constants.APP_HEIGHT);
    }

    /**
     * Check if left bounds reached of background 1
     *
     * @param delta time since last frame
     * @return true if leftBoundsReached for background 1
     */
    private boolean leftBoundsReached_1(float delta) {
        return (textureRegionBounds2_1.x - (delta * speed_1)) <= 0;
    }

    /**
     * updateXBounds of background 1
     *
     * @param delta time since last frame
     */
    private void updateXBounds_1(float delta) {
        textureRegionBounds1_1.x += delta * speed_1;
        textureRegionBounds2_1.x += delta * speed_1;
    }

    /**
     * Reset the bounds of background 1
     */
    private void resetBounds_1() {
        textureRegionBounds1_1 = textureRegionBounds2_1;
        textureRegionBounds2_1 = new Rectangle(Constants.APP_WIDTH, 0, Constants.APP_WIDTH, Constants.APP_HEIGHT);
    }

    /**
     * Check if left bounds reached of background 2
     *
     * @param delta time since last frame
     * @return true if leftBoundsReached for background 2
     */
    private boolean leftBoundsReached_2(float delta) {
        return (textureRegionBounds2_2.x - (delta * speed_2)) <= 0;
    }

    /**
     * updateXBounds of background 2
     *
     * @param delta time since last frame
     */
    private void updateXBounds_2(float delta) {
        textureRegionBounds1_2.x += delta * speed_2;
        textureRegionBounds2_2.x += delta * speed_2;
    }

    /**
     * Reset the bounds of background 2
     */
    private void resetBounds_2() {
        textureRegionBounds1_2 = textureRegionBounds2_2;
        textureRegionBounds2_2 = new Rectangle(Constants.APP_WIDTH, 0, Constants.APP_WIDTH, Constants.APP_HEIGHT);
    }

    /**
     * Check if left bounds reached of background 3
     *
     * @param delta time since last frame
     * @return true if leftBoundsReached for background 3
     */
    private boolean leftBoundsReached_3(float delta) {
        return (textureRegionBounds2_3.x - (delta * speed_3)) <= 0;
    }

    /**
     * updateXBounds of background 3
     *
     * @param delta time since last frame
     */
    private void updateXBounds_3(float delta) {
        textureRegionBounds1_3.x += delta * speed_3;
        textureRegionBounds2_3.x += delta * speed_3;
    }

    /**
     * Reset the bounds of background 3
     */
    private void resetBounds_3() {
        textureRegionBounds1_3 = textureRegionBounds2_3;
        textureRegionBounds2_3 = new Rectangle(Constants.APP_WIDTH, 0, Constants.APP_WIDTH, Constants.APP_HEIGHT);
    }

    /**
     * Increase speed of backgrounds moving
     *
     * @param increase number to increase speed by
     */
    public void increaseSpeed(int increase) {
        speed_1 = speed_1 + increase;
        speed_2 = speed_2 + increase;
        speed_3 = speed_3 + increase;
    }

    /**
     * Reset backgrounds speed back to normal
     */
    public void resetSpeed() {
        speed_1 = 200;
        speed_2 = 120;
        speed_3 = 160;
    }

    /**
     * Set speed of background
     *
     * @param speed speed of background
     */
    public void setSpeed(int speed) {
        speed_1 = speed;
        speed_2 = speed;
        speed_3 = speed;
    }

}
