package uk.co.lawilliams.finalproject.runcatrun.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;

import uk.co.lawilliams.finalproject.runcatrun.box2d.CatUserData;
import uk.co.lawilliams.finalproject.runcatrun.utils.AssetsManager;
import uk.co.lawilliams.finalproject.runcatrun.utils.AudioManager;
import uk.co.lawilliams.finalproject.runcatrun.utils.Constants;

/**
 * @author Lauren Williams, using tutorial by William Mora
 * @see [William Mora](http://williammora.com/a-running-game-with-libgdx-part-1)
 * <p>
 * Child of GameActor, and represents Cat shown on screen during Game
 */
public class Cat extends GameActor {

    private boolean jumping;
    private boolean hit;
    private Animation runningAnimation;
    private TextureRegion jumpingTexture;
    private TextureRegion hitTexture;
    private float stateTime;

    /**
     * Constructor for Cat
     *
     * @param body Physics entity of Cat
     */
    public Cat(Body body) {
        super(body);
        runningAnimation = AssetsManager.getAnimation(Constants.CAT_RUNNING_ANIMATION_KEY);
        hitTexture = AssetsManager.getTexture(Constants.CAT_HIT_TEXTURE_KEY);
        jumpingTexture = AssetsManager.getTexture(Constants.CAT_JUMPING_TEXTURE_KEY);
        stateTime = 0f;
    }

    /**
     * @return UserData for Cat
     */
    @Override
    public CatUserData getUserData() {
        return (CatUserData) userData;
    }

    /**
     * Applying jumping impulse if not already jumping or hit
     */
    public void jump() {

        if (!(jumping || hit)) {
            body.applyLinearImpulse(getUserData().getJumpingLinearImpulse(), body.getWorldCenter(), true);
            AudioManager.getInstance().playJumpSound();
            jumping = true;
        }

    }

    /**
     * Sets jumping to false
     */
    public void landed() {
        jumping = false;
    }

    /**
     * If cat is hit, make cat spin and set hit to true
     */
    public void hit() {
        body.applyAngularImpulse(getUserData().getHitAngularImpulse(), true);
        hit = true;
    }

    /**
     * @return true if hit() has been called, false if not
     */
    public boolean isHit() {
        return hit;
    }

    /**
     * draws different textures depending on whether the cat is hit, jumping or running
     *
     * @param batch drawing commands that are batched together
     * @param parentAlpha parent's time since last frame
     */
    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        if (hit) {
            batch.draw(hitTexture, screenRectangle.x, screenRectangle.y, screenRectangle.width * 0.5f,
                    screenRectangle.height * 0.5f, screenRectangle.width, screenRectangle.height, 1f, 1f,
                    (float) Math.toDegrees(body.getAngle()));
        } else if (jumping) {
            batch.draw(jumpingTexture, screenRectangle.x, screenRectangle.y, screenRectangle.width,
                    screenRectangle.height);
        } else {
            stateTime += Gdx.graphics.getDeltaTime();
            TextureRegion tex = (TextureRegion) runningAnimation.getKeyFrame(stateTime, true);
            batch.draw(tex, screenRectangle.x, screenRectangle.y,
                    screenRectangle.getWidth(), screenRectangle.getHeight());
        }
    }

}
