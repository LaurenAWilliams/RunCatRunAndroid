package uk.co.lawilliams.finalproject.runcatrun.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

import uk.co.lawilliams.finalproject.runcatrun.utils.AssetsManager;
import uk.co.lawilliams.finalproject.runcatrun.utils.Constants;
import uk.co.lawilliams.finalproject.runcatrun.utils.GameManager;

/**
 * @author Lauren Williams
 *         <p>
 *         Fail Overlay shown when cat hits enemy.
 */
public class FailOverlay extends Actor {

    private final TextureRegion TEXTUREREGION;
    private final Rectangle TEXTUREREGIONBOUNDS;
    private int score;
    private int coins;

    /**
     * Constructor for FailOverlay
     */
    public FailOverlay() {
        score = GameManager.getInstance().getScore();
        coins = GameManager.getInstance().loadCoins();
        TEXTUREREGION = AssetsManager.getTexture(Constants.FAIL_OVERLAY_TEXTURE_KEY);
        TEXTUREREGIONBOUNDS = new Rectangle((Constants.APP_WIDTH / 2 - TEXTUREREGION.getRegionWidth() / 2), (Constants.APP_HEIGHT / 2 - TEXTUREREGION.getRegionHeight() / 2), TEXTUREREGION.getRegionWidth(), TEXTUREREGION.getRegionHeight());
    }

    /**
     * Draw failoverlay.png and draw score
     *
     * @param batch       reference to texture
     * @param parentAlpha parent's time since last frame
     */
    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(TEXTUREREGION, TEXTUREREGIONBOUNDS.x, TEXTUREREGIONBOUNDS.y, TEXTUREREGIONBOUNDS.width,
                TEXTUREREGIONBOUNDS.height);
        AssetsManager.getBigFont().draw(batch, "Score: " + score, 200, 275);
        AssetsManager.getBigFont().draw(batch, "Coins: " + coins, 400, 275);
    }

}
