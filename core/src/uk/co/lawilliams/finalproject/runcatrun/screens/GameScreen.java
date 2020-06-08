package uk.co.lawilliams.finalproject.runcatrun.screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

import uk.co.lawilliams.finalproject.runcatrun.stages.GameStage;

/**
 * @author Lauren Williams, using tutorial by William Mora
 * @see [William Mora](http://williammora.com/a-running-game-with-libgdx-part-1)
 * <p>
 * Screen for the game, set the stage to be GameStage
 */

public class GameScreen implements Screen {

    private GameStage stage;

    /**
     * Constructor for GameScreen
     */
    public GameScreen() {
        stage = new GameStage();
    }

    /**
     * Draws the stage and calls it to act
     *
     * @param delta time since last frame
     */
    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.draw();
        stage.act(delta);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    /**
     * Dispose of the stage
     */
    @Override
    public void dispose() {
        stage.dispose();
    }

}
