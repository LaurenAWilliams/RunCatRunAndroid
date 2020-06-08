package uk.co.lawilliams.finalproject.runcatrun.box2d;

import uk.co.lawilliams.finalproject.runcatrun.enums.UserDataType;

/**
 * @author Lauren Williams, using tutorial by William Mora
 * @see [William Mora](http://williammora.com/a-running-game-with-libgdx-part-1)
 * <p>
 * FloorUserData holding basic attributes, and setting UserDataType
 */

public class FloorUserData extends UserData {

    /**
     * Constructor for floor user data
     * @param width the width
     * @param height the height
     */
    public FloorUserData(float width, float height) {
        super(width, height);
        userDataType = UserDataType.FLOOR;
    }
}
