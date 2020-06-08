package uk.co.lawilliams.finalproject.runcatrun.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

import uk.co.lawilliams.finalproject.runcatrun.stages.MenuStage;

/**
 * @author Lauren Williams
 *         <p>
 *         Screen for the menu, sets the stage to be MenuStage
 */

public class MenuScreen implements Screen {

    private MenuStage menuStage;

    /**
     * Constructor for menu screen
     *
     * @param game RunCatRun game
     */
    public MenuScreen(Game game) {
        menuStage = new MenuStage(game);
    }

    /**
     * Draws menustage and calls act on it
     *
     * @param delta time since last frame
     */
    @Override
    public void render(float delta) {
        //Clear the screen
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //Update the stage
        menuStage.draw();
        menuStage.act(delta);
    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {
    }

    /**
     * dispose of menustage
     */
    @Override
    public void dispose() {
        menuStage.dispose();
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

