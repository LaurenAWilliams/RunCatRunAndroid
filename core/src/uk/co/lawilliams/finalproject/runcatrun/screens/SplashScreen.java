package uk.co.lawilliams.finalproject.runcatrun.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * @author Lauren Williams
 *         <p>
 *         Splash screen shown on start up. Displays RHUL logo and then changes screen to menu.
 */

public class SplashScreen implements Screen {

    private SpriteBatch spriteBatch;
    private Texture splash;

    /**
     * Constructor for splashscreen
     *
     */
    public SplashScreen() {
    }

    /**
     * Render spriteBatches
     *
     * @param delta time since last frame
     */
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        spriteBatch.begin();
        spriteBatch.draw(splash, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        spriteBatch.end();

    }

    /**
     * Load in splash screen texture.
     */
    @Override
    public void show() {
        spriteBatch = new SpriteBatch();
        splash = new Texture(Gdx.files.internal("splash.png"));
    }

    @Override
    public void hide() {
    }

    /**
     * Dispose of sprite batch and the splash texture
     */
    @Override
    public void dispose() {
        spriteBatch.dispose();
        splash.dispose();
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void resize(int width, int height) {
    }


}
