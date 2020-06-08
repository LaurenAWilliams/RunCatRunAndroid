package uk.co.lawilliams.finalproject.runcatrun.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;

import uk.co.lawilliams.finalproject.runcatrun.box2d.EnemyUserData;
import uk.co.lawilliams.finalproject.runcatrun.utils.AssetsManager;

/**
 * @author Lauren Williams, using tutorial by William Mora
 * @see [William Mora](http://williammora.com/a-running-game-with-libgdx-part-1)
 * <p>
 * Child of GameActor, and represents Enemies shown on screen during Game
 */

public class Enemy extends GameActor {


    private Animation animation;
    private float stateTime;

    /**
     * Constructor for Enemy
     *
     * @param body physics entity for enemy
     */
    public Enemy(Body body) {
        super(body);
        animation = AssetsManager.getAnimation(getUserData().getAnimationKey());
        stateTime = 0f;
    }

    /**
     * @return UserData for EnemyUserData
     */
    @Override
    public EnemyUserData getUserData() {
        return (EnemyUserData) userData;
    }

    /**
     * Sets speed of enemy every time act is called
     *
     * @param delta time since last frame
     */
    @Override
    public void act(float delta) {
        super.act(delta);
        body.setLinearVelocity(getUserData().getLinearVelocity());
    }

    /**
     * Draw animation of enemy
     *
     * @param batch batch of drawing commands
     * @param parentAlpha time since parent's last frame
     */
    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        stateTime += Gdx.graphics.getDeltaTime();
        TextureRegion tex = (TextureRegion) animation.getKeyFrame(stateTime, true);
        batch.draw(tex, (screenRectangle.x - (screenRectangle.width * 0.1f)),
                screenRectangle.y, screenRectangle.width * 1.5f, screenRectangle.height * 1.5f);
    }


}
