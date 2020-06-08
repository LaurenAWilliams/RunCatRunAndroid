package uk.co.lawilliams.finalproject.runcatrun.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

import uk.co.lawilliams.finalproject.runcatrun.utils.AssetsManager;
import uk.co.lawilliams.finalproject.runcatrun.utils.Constants;
import uk.co.lawilliams.finalproject.runcatrun.utils.GameManager;

/**
 * @author Lauren Williams
 *         <p>
 *         Displays score over GameStage
 */

public class ScoreText extends Actor {

    private int score;
    private GameManager gm;

    /**
     * Constructor for ScoreText
     */
    public ScoreText() {
        this.gm = GameManager.getInstance();
        this.score = gm.getScore();
    }

    /**
     * Called every time parent (i.e the gamestage) calls it to act
     *
     * @param delta time since last frame
     */
    @Override
    public void act(float delta) {
        super.act(delta);
        score = gm.getScore();
    }

    /**
     * Draws the font
     *
     * @param batch batch of drawing commands
     * @param parentAlpha time since parent's last frame
     */
    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        AssetsManager.getBigFont().draw(batch, "" + score, Constants.APP_WIDTH - 60, Constants.APP_HEIGHT - 20);
    }
}
