package uk.co.lawilliams.finalproject.runcatrun.box2d;

import com.badlogic.gdx.math.Vector2;

import uk.co.lawilliams.finalproject.runcatrun.enums.UserDataType;
import uk.co.lawilliams.finalproject.runcatrun.utils.Constants;

/**
 * @author Lauren Williams, using tutorial by William Mora
 * @see [William Mora](http://williammora.com/a-running-game-with-libgdx-part-1)
 * <p>
 * EnemyUserData holding basic attributes, and setting UserDataType
 */

public class EnemyUserData extends UserData {

    private Vector2 linearVelocity;
    private String animationKey;

    /**
     * Constructor for enemy user data
     *
     * @param width        width of enemy
     * @param height       height of enemy
     * @param animationKey key for animation from AssetsManager
     */
    public EnemyUserData(float width, float height, String animationKey) {
        super(width, height);
        userDataType = UserDataType.ENEMY;
        linearVelocity = Constants.ENEMY_LINEAR_VELOCITY;
        this.animationKey = animationKey;
    }

    /**
     * @param linearVelocity speed of enemy
     */
    public void setLinearVelocity(Vector2 linearVelocity) {
        this.linearVelocity = linearVelocity;
    }

    /**
     * @return speed of enemy
     */
    public Vector2 getLinearVelocity() {
        return linearVelocity;
    }

    /**
     * @return key to retrieve animation from AssetsManager
     */
    public String getAnimationKey() {
        return animationKey;
    }

}
