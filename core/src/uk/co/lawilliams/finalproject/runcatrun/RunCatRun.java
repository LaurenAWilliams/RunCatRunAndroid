package uk.co.lawilliams.finalproject.runcatrun;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Timer;

import uk.co.lawilliams.finalproject.runcatrun.screens.MenuScreen;
import uk.co.lawilliams.finalproject.runcatrun.screens.SplashScreen;
import uk.co.lawilliams.finalproject.runcatrun.utils.AndroidInterface;
import uk.co.lawilliams.finalproject.runcatrun.utils.AssetsManager;
import uk.co.lawilliams.finalproject.runcatrun.utils.AudioManager;
import uk.co.lawilliams.finalproject.runcatrun.utils.GameManager;

/**
 * @author Lauren Williams
 *         <p>
 *         Sets up interface between LibGDX modules and AndroidLauncher. Loads the assets and
 *         shows splash screen.
 */
class RunCatRun extends Game {

    private final static long SPLASH_TIME_LENGTH = 2000L;
    private Game game;
    /**
     * Constructor for RunCatRun game
     *
     * @param androidInterface interface needed by AndroidLauncher
     */
    RunCatRun(AndroidInterface androidInterface) {
        GameManager.getInstance().setAndroidInterface(androidInterface);
    }

    /**
     * Create the game, load assets and show splash screen.
     */
    @Override
    public void create() {
        game = this;
        AssetsManager.load();
        AudioManager.getInstance().load();
        showSplashAndContinue();
    }

    /**
     * Show splash screen and then change to menu.
     */
    private void showSplashAndContinue() {
        setScreen(new SplashScreen());

        final long splash_starting_time = System.currentTimeMillis();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Gdx.app.postRunnable(new Runnable() {
                    @Override
                    public void run() {
                        long splash_elapsed_time = System.currentTimeMillis() - splash_starting_time;

                        if (splash_elapsed_time < RunCatRun.SPLASH_TIME_LENGTH) {
                            Timer.schedule(
                                    new Timer.Task() {
                                        @Override
                                        public void run() {
                                            RunCatRun.this.setScreen(new MenuScreen(game));
                                        }
                                    }, (float) (RunCatRun.SPLASH_TIME_LENGTH - splash_elapsed_time) / 1000f);
                        } else {
                            RunCatRun.this.setScreen(new MenuScreen(game));
                        }
                    }
                });
            }
        }).start();
    }

    /**
     * Dispose of AssetsManager assets.
     */
    @Override
    public void dispose() {
        super.dispose();
        AudioManager.dispose();
        AssetsManager.dispose();
    }

}