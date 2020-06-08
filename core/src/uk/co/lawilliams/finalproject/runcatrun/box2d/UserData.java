package uk.co.lawilliams.finalproject.runcatrun.box2d;

import uk.co.lawilliams.finalproject.runcatrun.enums.UserDataType;

/**
 * @author Lauren Williams, using tutorial by William Mora
 * @see [William Mora](http://williammora.com/a-running-game-with-libgdx-part-1)
 * <p>
 * UserData holding basic attributes.
 */

public class UserData {

    protected float width;
    protected float height;
    UserDataType userDataType;

    /**
     * Constructor for UserData
     *
     * @param width the width
     * @param height the height
     */
    public UserData(float width, float height) {
        this.width = width;
        this.height = height;
    }

    /**
     * @return user data type of user data
     */
    public UserDataType getUserDataType() {
        return userDataType;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

}
