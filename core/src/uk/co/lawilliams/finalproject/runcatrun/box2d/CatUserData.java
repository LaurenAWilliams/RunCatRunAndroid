package uk.co.lawilliams.finalproject.runcatrun.box2d;

import com.badlogic.gdx.math.Vector2;

import uk.co.lawilliams.finalproject.runcatrun.enums.UserDataType;
import uk.co.lawilliams.finalproject.runcatrun.utils.Constants;

/**
 * @author Lauren Williams, using tutorial by William Mora
 * @see [William Mora](http://williammora.com/a-running-game-with-libgdx-part-1)
 * <p>
 * CatUserData holding basic attributes, setting UserDataType and jumping height
 */

public class CatUserData extends UserData {

    private Vector2 jumpingLinearImpulse;

    /**
     * Constructor for CatUserData
     *
     * @param width  width of cat
     * @param height height of cat
     */
    public CatUserData(float width, float height) {
        super(width, height);
        jumpingLinearImpulse = Constants.CAT_JUMPING_LINEAR_IMPULSE;
        userDataType = UserDataType.CAT;
    }

    /**
     * @return jumping height
     */
    public Vector2 getJumpingLinearImpulse() {
        return jumpingLinearImpulse;
    }

    /**
     * @param jumpingLinearImpulse jumping height
     */
    public void setJumpingLinearImpulse(Vector2 jumpingLinearImpulse) {
        this.jumpingLinearImpulse = jumpingLinearImpulse;
    }

    /**
     * @return how much cat spins when hit
     */
    public float getHitAngularImpulse() {
        return Constants.CAT_HIT_ANGULAR_IMPULSE;
    }


}