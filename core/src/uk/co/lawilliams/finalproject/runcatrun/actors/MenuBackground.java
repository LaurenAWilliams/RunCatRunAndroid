package uk.co.lawilliams.finalproject.runcatrun.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

import uk.co.lawilliams.finalproject.runcatrun.utils.AssetsManager;
import uk.co.lawilliams.finalproject.runcatrun.utils.Constants;

/**
 * @author Lauren Williams
 *         <p>
 *         Background shown on menu stage
 */

public class MenuBackground extends Actor {

    private final TextureRegion TEXTUREREGION;
    private final Rectangle TEXTUREREGIONBOUNDS;
    private Animation catAnimation;
    private float animationTime;

    /**
     * Constructor for Menu Background
     */
    public MenuBackground() {
        TEXTUREREGION = AssetsManager.getTexture(Constants.MENU_BACKGROUND_TEXTURE_KEY);
        TEXTUREREGIONBOUNDS = new Rectangle(0, 0, Constants.APP_WIDTH, Constants.APP_HEIGHT);

        catAnimation = AssetsManager.getAnimation(Constants.CAT_RUNNING_ANIMATION_KEY);
        animationTime = 0f;
    }

    /**
     * Draw background and cat animation
     *
     * @param batch       2D rectangles that reference a texture
     * @param parentAlpha parent's time since last frame
     */
    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(TEXTUREREGION, TEXTUREREGIONBOUNDS.x, TEXTUREREGIONBOUNDS.y, TEXTUREREGIONBOUNDS.width,
                TEXTUREREGIONBOUNDS.height);

        animationTime += Gdx.graphics.getDeltaTime();
        TextureRegion tex = (TextureRegion) catAnimation.getKeyFrame(animationTime, true);
        batch.draw(tex, Constants.APP_WIDTH / 2 - (tex.getRegionWidth() / 2), Constants.APP_HEIGHT / 2 - (tex.getRegionHeight() / 2),
                tex.getRegionWidth(), tex.getRegionHeight());
    }

}
