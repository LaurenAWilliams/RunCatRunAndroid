package uk.co.lawilliams.finalproject.runcatrun.utils;

import com.badlogic.gdx.math.Vector2;

/**
 * @author Lauren Williams, using tutorial by William Mora
 * @see [William Mora](http://williammora.com/a-running-game-with-libgdx-part-1)
 * <p>
 * Constants used by app to ensure no values are mistyped and are consistent
 */

public class Constants {

    //World and screen attributes
    public static final int APP_WIDTH = 800;
    public static final int APP_HEIGHT = 480;
    public static final float WORLD_TO_SCREEN = 32;
    public static final Vector2 WORLD_GRAVITY = new Vector2(0, -10);
    public static final float FLOOR_WIDTH = 41f;
    public static final float FLOOR_HEIGHT = 2f;
    public static final float CAT_WIDTH = 2.5f;
    public static final float CAT_HEIGHT = 2.5f;
    public static final Vector2 CAT_JUMPING_LINEAR_IMPULSE = new Vector2(0, 70f);
    public static final Vector2 CAT_JUMPING_LINEAR_IMPULSE_HIGHER = new Vector2(0, 100f);
    public static final float CAT_HIT_ANGULAR_IMPULSE = 10f;
    //Enemy physics attributes
    public static final float ENEMY_X = 25f;
    public static final float FLYING_ENEMY_Y = 6.0f;
    public static final Vector2 ENEMY_LINEAR_VELOCITY = new Vector2(-10f, 0);
    //Buttons region names
    public static final String BUTTONS_ATLAS_PATH = "buttons.txt";
    public static final String PLAY_BUTTON_REGION_NAME = "play_button";
    public static final String TUTORIAL_BUTTON_REGION_NAME = "tutorial_button";
    public static final String LEADERBOARD_BUTTON_REGION_NAME = "leaderboard_button";
    public static final String SHOP_BUTTON_REGION_NAME = "shop_button";
    public static final String RETRY_BUTTON_REGION_NAME = "retry_button";
    public static final String PLAY_BUTTON_PRESSED_REGION_NAME = "play_button_pressed";
    public static final String TUTORIAL_BUTTON_PRESSED_REGION_NAME = "tutorial_button_pressed";
    public static final String LEADERBOARD_BUTTON_PRESSED_REGION_NAME = "leaderboard_button_pressed";
    public static final String SHOP_BUTTON_PRESSED_REGION_NAME = "shop_button_pressed";
    public static final String RETRY_BUTTON_PRESSED_REGION_NAME = "retry_button_pressed";
    public static final String SOUND_OFF_BUTTON_REGION_NAME = "sound_off_button";
    public static final String SOUND_ON_BUTTON_REGION_NAME = "sound_on_button";
    //Texture Keys
    public static final String FAIL_OVERLAY_TEXTURE_KEY = "FailOverlayTexture";
    public static final String CAT_JUMPING_TEXTURE_KEY = "CatJumpingTexture";
    public static final String CAT_HIT_TEXTURE_KEY = "CatHitTexture";
    public static final String FLOOR_TEXTURE_KEY = "FloorTexture";
    public static final String BACKGROUND_1_TEXTURE_KEY = "Background1Texture";
    public static final String BACKGROUND_2_TEXTURE_KEY = "Background2Texture";
    public static final String BACKGROUND_3_TEXTURE_KEY = "Background3Texture";
    public static final String BACKGROUND_4_TEXTURE_KEY = "Background4Texture";
    public static final String MENU_BACKGROUND_TEXTURE_KEY = "MenuBackgroundTexture";
    //Animation Keys
    public static final String ENEMY_DOG_ANIMATION_KEY = "DogEnemyAnimation";
    public static final String ENEMY_CAR_ANIMATION_KEY = "CarEnemyAnimation";
    public static final String ENEMY_BOX_ANIMATION_KEY = "BoxEnemyAnimation";
    public static final String ENEMY_PLANE_ANIMATION_KEY = "PlaneEnemyAnimation";
    public static final String CAT_RUNNING_ANIMATION_KEY = "CatRunningAnimation";
    //Floor physics attributes
    static final float FLOOR_X = 0;
    static final float FLOOR_Y = 0;
    public static final float RUNNING_SHORT_ENEMY_Y = FLOOR_Y + FLOOR_HEIGHT;
    static final float FLOOR_DENSITY = 0f;
    //Cat physics attributes
    static final float CAT_X = 4;
    static final float CAT_Y = FLOOR_Y + FLOOR_HEIGHT;
    static final float CAT_GRAVITY_SCALE = 5f;
    //Texture paths
    static final String BACKGROUND_1_PATH = "back_1.png";
    static final String BACKGROUND_2_PATH = "back_2.png";
    static final String BACKGROUND_3_PATH = "back_3.png";
    static final String BACKGROUND_4_PATH = "back_4.png";
    static final String MENU_BACKGROUND_PATH = "menu_background.png";
    static final String FAIL_OVERLAY_PATH = "failoverlay.png";
    static final String FLOOR_PATH = "floor.png";
    //Font paths
    static final String FONT_PATH = "Quikhand.ttf";
    //Audio paths
    static final String MUSIC_PATH = "music.wav";
    static final String JUMP_SOUND_PATH = "jump.wav";
    static final String HIT_SOUND_PATH = "hit.mp3";
    //Cat atlas and region names
    static final String CAT_ATLAS_PATH = "cat.txt";
    static final String[] CAT_RUNNING_REGION_NAMES = new String[]{"cat_run (1)", "cat_run (2)", "cat_run (3)", "cat_run (4)", "cat_run (5)", "cat_run (6)", "cat_run (7)", "cat_run (8)"};
    static final String CAT_HIT_REGION_NAME = "cat_dead";
    static final String CAT_JUMPING_REGION_NAME = "cat_jump (1)";
    //Enemy atlas and region names
    static final String ENEMY_ATLAS_PATH = "enemies.txt";
    static final String[] ENEMY_BOX_REGION_NAME = new String[]{"box"};
    static final String[] ENEMY_CAR_REGION_NAME = new String[]{"car (1)", "car (2)"};
    static final String[] ENEMY_DOG_REGION_NAME = new String[]{"dog (1)", "dog (2)", "dog (3)", "dog (4)", "dog (5)", "dog (6)", "dog (7)", "dog (8)"};
    static final String[] ENEMY_PLANE_REGION_NAME = new String[]{"plane (1)", "plane (2)"};
    //Preferences
    static final String PREFERENCES_NAME = "user_preferences";
    static final String SCORE_PREFERENCE = "score";
    static final String COIN_PREFERENCE = "coin";
    static final String ITEM_HIGHERJUMP_PREFERENCE = "hjitem";
    static final String ITEM_FREECONTINUE_PREFERENCE = "fcitem";
    static final String ITEM_SLOWERDIFFICULTY_PREFERENCE = "sditem";
    static float CAT_DENSITY = 0.5f;
    public static final float ENEMY_DENSITY = CAT_DENSITY;

}
