package uk.co.lawilliams.finalproject.runcatrun.enums;

import uk.co.lawilliams.finalproject.runcatrun.utils.Constants;

/**
 * @author Lauren Williams, using tutorial by William Mora
 * @see [William Mora](http://williammora.com/a-running-game-with-libgdx-part-1)
 * <p>
 * EnemyType enums, determining their physics attributes and animations
 */

public enum EnemyType {

    /**
     * The following enums are flagged as not being used by the IDE but they are used
     * by RandomUtils, and am therefore suppressing the warnings.
     */

    @SuppressWarnings("unused")
    BOX_ENEMY(1.5f, 1.5f, Constants.ENEMY_X, Constants.RUNNING_SHORT_ENEMY_Y - 0.5f, Constants.ENEMY_DENSITY,
            Constants.ENEMY_BOX_ANIMATION_KEY),
    @SuppressWarnings("unused")
    DOG_ENEMY(2.0f, 2.0f, Constants.ENEMY_X, Constants.RUNNING_SHORT_ENEMY_Y, Constants.ENEMY_DENSITY,
                Constants.ENEMY_DOG_ANIMATION_KEY),
    @SuppressWarnings("unused")
    CAR_ENEMY(2.0f, 2.26f, Constants.ENEMY_X, Constants.RUNNING_SHORT_ENEMY_Y, Constants.ENEMY_DENSITY,
            Constants.ENEMY_CAR_ANIMATION_KEY),
    @SuppressWarnings("unused")
    PLANE_ENEMY(3.0f, 3.0f, Constants.ENEMY_X, Constants.FLYING_ENEMY_Y, Constants.ENEMY_DENSITY,
              Constants.ENEMY_PLANE_ANIMATION_KEY);


    private float width;
    private float height;
    private float x;
    private float y;
    private float density;
    private String animationKey;

    EnemyType(float width, float height, float x, float y, float density, String animationKey) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.density = density;
        this.animationKey = animationKey;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getDensity() {
        return density;
    }

    public String getAnimationKey() {
        return animationKey;
    }


}
