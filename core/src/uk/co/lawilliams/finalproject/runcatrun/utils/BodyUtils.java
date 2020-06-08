package uk.co.lawilliams.finalproject.runcatrun.utils;

import com.badlogic.gdx.physics.box2d.Body;

import uk.co.lawilliams.finalproject.runcatrun.box2d.UserData;
import uk.co.lawilliams.finalproject.runcatrun.enums.UserDataType;

/**
 * @author Lauren Williams, using tutorial by William Mora
 * @see [William Mora](http://williammora.com/a-running-game-with-libgdx-part-1)
 * <p>
 * Allows checks to be performed on bodies
 */

public class BodyUtils {

    /**
     * @param body physics object being checked
     * @return true if enemy is still in bounds or body is cat
     */
    public static boolean bodyInBounds(Body body) {
        UserData userData = (UserData) body.getUserData();

        switch (userData.getUserDataType()) {
            case CAT:
            case ENEMY:
                return body.getPosition().x + userData.getWidth() / 2 > 0;
        }

        return true;
    }

    /**
     * @param body physics object being checked
     * @return true if body is an enemy and is not null, else false
     */
    public static boolean bodyIsEnemy(Body body) {
        UserData userData = (UserData) body.getUserData();

        return userData != null && userData.getUserDataType() == UserDataType.ENEMY;
    }

    /**
     * @param body physics object being checked
     * @return true if body is cat and is not null, else false
     */
    public static boolean bodyIsCat(Body body) {
        UserData userData = (UserData) body.getUserData();

        return userData != null && userData.getUserDataType() == UserDataType.CAT;
    }

    /**
     * @param body physics object being checked
     * @return true if body is ground and is not null, else false
     */
    public static boolean bodyIsFloor(Body body) {
        UserData userData = (UserData) body.getUserData();

        return userData != null && userData.getUserDataType() == UserDataType.FLOOR;
    }


}
