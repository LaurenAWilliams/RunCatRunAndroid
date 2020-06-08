package uk.co.lawilliams.finalproject.runcatrun.actors;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.Actor;

import uk.co.lawilliams.finalproject.runcatrun.box2d.UserData;
import uk.co.lawilliams.finalproject.runcatrun.utils.Constants;

/**
 * @author Lauren Williams, using tutorial by William Mora
 * @see [William Mora](http://williammora.com/a-running-game-with-libgdx-part-1)
 * <p>
 * Parent class of Cat, Enemy and Floor
 */
abstract class GameActor extends Actor {

    Body body;
    UserData userData;
    Rectangle screenRectangle;

    /**
     * Constructor for GameActor
     *
     * @param body physics entity of actor
     */
    GameActor(Body body) {
        this.body = body;
        this.userData = (UserData) body.getUserData();
        screenRectangle = new Rectangle();
    }

    /**
     * Act and update the rectangle
     *
     * @param delta time since last frame
     */
    @Override
    public void act(float delta) {
        super.act(delta);

        if (body.getUserData() != null) {
            updateRectangle();
        } else {
            remove();
        }

    }

    /**
     * @return user data of the GameActor
     */
    public abstract UserData getUserData();

    /**
     * Update the screen rectangle
     */
    private void updateRectangle() {
        screenRectangle.x = transformToScreen(body.getPosition().x - userData.getWidth() / 2);
        screenRectangle.y = transformToScreen(body.getPosition().y - userData.getHeight() / 2);
        screenRectangle.width = transformToScreen(userData.getWidth());
        screenRectangle.height = transformToScreen(userData.getHeight());
    }

    float transformToScreen(float n) {
        return Constants.WORLD_TO_SCREEN * n;
    }
}
