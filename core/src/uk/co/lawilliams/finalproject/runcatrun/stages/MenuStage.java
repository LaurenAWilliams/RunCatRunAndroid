package uk.co.lawilliams.finalproject.runcatrun.stages;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;

import uk.co.lawilliams.finalproject.runcatrun.actors.MenuBackground;
import uk.co.lawilliams.finalproject.runcatrun.actors.UIElements.LeaderboardButton;
import uk.co.lawilliams.finalproject.runcatrun.actors.UIElements.MuteButton;
import uk.co.lawilliams.finalproject.runcatrun.actors.UIElements.PlayButton;
import uk.co.lawilliams.finalproject.runcatrun.actors.UIElements.ShopButton;
import uk.co.lawilliams.finalproject.runcatrun.actors.UIElements.TutorialButton;
import uk.co.lawilliams.finalproject.runcatrun.screens.GameScreen;
import uk.co.lawilliams.finalproject.runcatrun.utils.AssetsManager;
import uk.co.lawilliams.finalproject.runcatrun.utils.AudioManager;
import uk.co.lawilliams.finalproject.runcatrun.utils.Constants;
import uk.co.lawilliams.finalproject.runcatrun.utils.GameManager;

/**
 * @author Lauren Williams
 *         <p>
 *         Stage handling the main menu
 */

public class MenuStage extends Stage {

    private static final int VIEWPORT_WIDTH = Constants.APP_WIDTH;
    private static final int VIEWPORT_HEIGHT = Constants.APP_HEIGHT;
    private Stage stage = this;
    private Game game;

    /**
     * Constructor for MenuStage
     *
     * @param game RunCatRun game
     */
    public MenuStage(Game game) {
        super(new ScalingViewport(Scaling.stretch, VIEWPORT_WIDTH, VIEWPORT_HEIGHT,
                new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT)));
        this.game = game;
        Gdx.input.setInputProcessor(this);
        setUpCamera();
        setUpBackground();
        setUpButtons();
    }

    /**
     * set up the camera
     */
    private void setUpCamera() {
        OrthographicCamera camera = new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0f);
        camera.update();
    }

    /**
     * set up the background image
     */
    private void setUpBackground() {
        addActor(new MenuBackground());
    }

    /**
     * set up the main menu buttons
     */
    private void setUpButtons() {
        setUpPlay();
        setUpTutorial();
        setUpShop();
        setUpLeaderboard();
        setUpMute();
        setUpSign();

    }

    private void setUpSign() {
        TextButton.TextButtonStyle signStyle = new TextButton.TextButtonStyle();
        signStyle.font = AssetsManager.getSmallFont();
        TextButton signButton = new TextButton("Log in to Google Play", signStyle);
        signButton.setPosition(getCamera().viewportWidth / 8, getCamera().viewportWidth / 128);
        signButton.setSize(50, 50);
        signButton.addListener(new ChangeListener() {
            public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                GameManager.getInstance().loginGPGS();
            }
        });

        addActor(signButton);

        if (GameManager.getInstance().getSignedInGPGS()) {
            signButton.remove();
        }
    }

    /**
     * set up the play button and add it to the main menu
     */
    private void setUpPlay() {
        Rectangle playButtonShape = new Rectangle(getCamera().viewportWidth * 1 / 16,
                getCamera().viewportHeight / 8, getCamera().viewportWidth / 8,
                getCamera().viewportWidth / 8);
        PlayButton playButton = new PlayButton(playButtonShape, new MenuPlayButtonListener());
        addActor(playButton);
    }

    /**
     * set up the tutorial button and add it to the main menu
     */
    private void setUpTutorial() {
        Rectangle tutorialButtonShape = new Rectangle(getCamera().viewportWidth * 5 / 16,
                getCamera().viewportHeight / 8, getCamera().viewportWidth / 8,
                getCamera().viewportWidth / 8);
        TutorialButton tutorialButton = new TutorialButton(tutorialButtonShape, new MenuTutorialButtonListener());
        addActor(tutorialButton);
    }

    /**
     * set up the shop button and add it to the main menu
     */
    private void setUpShop() {
        Rectangle shopButtonShape = new Rectangle(getCamera().viewportWidth * 9 / 16,
                getCamera().viewportHeight / 8, getCamera().viewportWidth / 8,
                getCamera().viewportWidth / 8);
        ShopButton shopButton = new ShopButton(shopButtonShape, new MenuShopButtonListener());
        addActor(shopButton);
    }

    /**
     * set up the leaderboard and add it to the main menu
     */
    private void setUpLeaderboard() {
        Rectangle leaderboardButtonShape = new Rectangle(getCamera().viewportWidth * 13 / 16,
                getCamera().viewportHeight / 8, getCamera().viewportWidth / 8,
                getCamera().viewportWidth / 8);
        LeaderboardButton leaderboardButton = new LeaderboardButton(leaderboardButtonShape, new MenuLeaderboardButtonListener());
        addActor(leaderboardButton);
    }

    private void setUpMute() {
        Rectangle muteButtonShape = new Rectangle(getCamera().viewportWidth * 1 / 32,
                getCamera().viewportHeight / 8 * 7, getCamera().viewportWidth / 16,
                getCamera().viewportWidth / 16);
        MuteButton muteButton = new MuteButton(muteButtonShape, new MenuMuteButtonListener());
        addActor(muteButton);
    }

    private class MenuPlayButtonListener implements PlayButton.PlayButtonListener {
        @Override
        public void onPlay() {
            game.setScreen(new GameScreen());
        }
    }

    /**
     * The tutorial button listener
     */
    private class MenuTutorialButtonListener implements TutorialButton.TutorialButtonListener {
        @Override
        public void onTutorial() {
            if (Gdx.app.getType() == Application.ApplicationType.Android) {
                GameManager.getInstance().showTutorial();
            } else {
                Dialog dialog = new Dialog("Warning", new Skin(), "dialog") {
                    public void result(Object obj) {
                        System.out.println("result " + obj);
                    }
                };
                dialog.text("Tutorial not supported");
                dialog.button("OK", true);
                dialog.show(stage);
            }
        }
    }

    /**
     * the leaderboard button listener
     */
    private class MenuLeaderboardButtonListener implements LeaderboardButton.LeaderboardButtonListener {
        @Override
        public void onLeaderboard() {
            if (Gdx.app.getType() == Application.ApplicationType.Android) {
                GameManager.getInstance().showLeaderboards();
            } else {
                Dialog dialog = new Dialog("Warning", new Skin(), "dialog") {
                    public void result(Object obj) {
                        System.out.println("result " + obj);
                    }
                };
                dialog.text("Leaderboards not supported");
                dialog.button("OK", true);
                dialog.show(stage);
            }
        }
    }

    /**
     * The shop button listener
     */
    private class MenuShopButtonListener implements ShopButton.ShopButtonListener {
        @Override
        public void onShop() {
            if (Gdx.app.getType() == Application.ApplicationType.Android) {
                GameManager.getInstance().showShop();
            } else {
                Dialog dialog = new Dialog("Warning", new Skin(), "dialog") {
                    public void result(Object obj) {
                        System.out.println("result " + obj);
                    }
                };
                dialog.text("Shop not supported");
                dialog.button("OK", true);
                dialog.show(stage);
            }
        }
    }

    /**
     * The mute button listener
     */
    private class MenuMuteButtonListener implements MuteButton.MuteButtonListener {
        @Override
        public void onMute() {
            AudioManager.getInstance().muteMusic();
        }
    }

}
