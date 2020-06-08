package uk.co.lawilliams.finalproject.runcatrun.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

import java.util.HashMap;

/**
 * @author Lauren Williams
 *         <p>
 *         Manages all assets by loading and allowing retrieval. Called when loading app once and only once
 *         to prevent slow-down during game.
 *         <p>
 *         Sources:
 * @see [enemies.png & cat.png] (https://www.gameart2d.com/freebies.html)
 * All other assets are produced by myself.
 */

public class AssetsManager {

    private static HashMap<String, TextureRegion> textures = new HashMap<String, TextureRegion>();
    private static HashMap<String, Animation> animations = new HashMap<String, Animation>();
    private static BitmapFont bigFont;
    private static BitmapFont smallFont;
    private static TextureAtlas enemyAtlas;
    private static TextureAtlas catAtlas;

    /**
     * constructor
     */
    private AssetsManager() {
    }

    /**
     * generate fonts, load atlas', load textures and load animations
     */
    public static void load() {
        enemyAtlas = new TextureAtlas(Constants.ENEMY_ATLAS_PATH);
        catAtlas = new TextureAtlas(Constants.CAT_ATLAS_PATH);

        generateFonts();
        loadTextures();
        loadAnimations();
    }

    /**
     * generate the font
     */
    private static void generateFonts() {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(Constants.FONT_PATH));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 48;
        bigFont = generator.generateFont(parameter);
        parameter.size = 22;
        smallFont = generator.generateFont(parameter);
        generator.dispose();
    }

    /**
     * @param atlas       atlas containing frames for the animation
     * @param regionNames region names of frames making up the desired animation
     * @return the new animation
     */
    private static Animation makeAnimation(TextureAtlas atlas, String[] regionNames) {

        TextureRegion[] frames = new TextureRegion[regionNames.length];
        for (int i = 0; i < regionNames.length; i++) {
            String path = regionNames[i];
            frames[i] = atlas.findRegion(path);
        }

        return new Animation<TextureRegion>(0.1f, frames);

    }

    /**
     * load the textures by inserting them into textures HashMap
     */
    private static void loadTextures() {
        //Fail Overlay texture
        textures.put(Constants.FAIL_OVERLAY_TEXTURE_KEY, new TextureRegion(new Texture(Gdx.files.internal(Constants.FAIL_OVERLAY_PATH))));

        //Cat
        textures.put(Constants.CAT_HIT_TEXTURE_KEY, catAtlas.findRegion(Constants.CAT_HIT_REGION_NAME));
        textures.put(Constants.CAT_JUMPING_TEXTURE_KEY, catAtlas.findRegion(Constants.CAT_JUMPING_REGION_NAME));

        //Floor
        textures.put(Constants.FLOOR_TEXTURE_KEY, new TextureRegion(new Texture(Gdx.files.internal(Constants.FLOOR_PATH))));

        //Game background
        textures.put(Constants.BACKGROUND_1_TEXTURE_KEY, new TextureRegion(new Texture(Gdx.files.internal(Constants.BACKGROUND_1_PATH))));
        textures.put(Constants.BACKGROUND_2_TEXTURE_KEY, new TextureRegion(new Texture(Gdx.files.internal(Constants.BACKGROUND_2_PATH))));
        textures.put(Constants.BACKGROUND_3_TEXTURE_KEY, new TextureRegion(new Texture(Gdx.files.internal(Constants.BACKGROUND_3_PATH))));
        textures.put(Constants.BACKGROUND_4_TEXTURE_KEY, new TextureRegion(new Texture(Gdx.files.internal(Constants.BACKGROUND_4_PATH))));

        //Menu background
        textures.put(Constants.MENU_BACKGROUND_TEXTURE_KEY, new TextureRegion(new Texture(Gdx.files.internal(Constants.MENU_BACKGROUND_PATH))));

    }

    /**
     * load animations by inserting them into animations HashMap
     */

    private static void loadAnimations() {

        /* Enemies */
        animations.put(Constants.ENEMY_DOG_ANIMATION_KEY, makeAnimation(enemyAtlas, Constants.ENEMY_DOG_REGION_NAME));
        animations.put(Constants.ENEMY_CAR_ANIMATION_KEY, makeAnimation(enemyAtlas, Constants.ENEMY_CAR_REGION_NAME));
        animations.put(Constants.ENEMY_BOX_ANIMATION_KEY, makeAnimation(enemyAtlas, Constants.ENEMY_BOX_REGION_NAME));
        animations.put(Constants.ENEMY_PLANE_ANIMATION_KEY, makeAnimation(enemyAtlas, Constants.ENEMY_PLANE_REGION_NAME));

        /* Cat */
        animations.put(Constants.CAT_RUNNING_ANIMATION_KEY, makeAnimation(catAtlas, Constants.CAT_RUNNING_REGION_NAMES));

    }

    /**
     * @param key required to retrieve texture from HashMap
     * @return texture retrieved using key
     */
    public static TextureRegion getTexture(String key) {
        return textures.get(key);
    }

    /**
     * @param key required to retrieve texture from HashMap
     * @return animation retrieved using key
     */
    public static Animation getAnimation(String key) {
        return animations.get(key);
    }

    /**
     * @return the big font previously generated
     */
    public static BitmapFont getBigFont() {
        return bigFont;
    }


    /**
     * @return the small font previously generated
     */
    public static BitmapFont getSmallFont() {
        return smallFont;
    }

    /**
     * dipose all resources created and maintained by AssetsManager
     */
    public static void dispose() {
        bigFont.dispose();
        smallFont.dispose();
        animations.clear();
        textures.clear();
    }

}
