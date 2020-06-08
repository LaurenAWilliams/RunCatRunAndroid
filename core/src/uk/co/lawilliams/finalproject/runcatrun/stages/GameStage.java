package uk.co.lawilliams.finalproject.runcatrun.stages;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;

import uk.co.lawilliams.finalproject.runcatrun.actors.Cat;
import uk.co.lawilliams.finalproject.runcatrun.actors.Enemy;
import uk.co.lawilliams.finalproject.runcatrun.actors.FailOverlay;
import uk.co.lawilliams.finalproject.runcatrun.actors.Floor;
import uk.co.lawilliams.finalproject.runcatrun.actors.GameBackground;
import uk.co.lawilliams.finalproject.runcatrun.actors.ScoreText;
import uk.co.lawilliams.finalproject.runcatrun.actors.UIElements.LeaderboardButton;
import uk.co.lawilliams.finalproject.runcatrun.actors.UIElements.RetryButton;
import uk.co.lawilliams.finalproject.runcatrun.actors.UIElements.ShopButton;
import uk.co.lawilliams.finalproject.runcatrun.utils.AudioManager;
import uk.co.lawilliams.finalproject.runcatrun.utils.BodyUtils;
import uk.co.lawilliams.finalproject.runcatrun.utils.Constants;
import uk.co.lawilliams.finalproject.runcatrun.utils.GameManager;
import uk.co.lawilliams.finalproject.runcatrun.utils.WorldUtils;

/**
 * @author Lauren Williams, using tutorial by William Mora
 * @see [William Mora](http://williammora.com/a-running-game-with-libgdx-part-1)
 * <p>
 * Stage handling the game
 */

public class GameStage extends Stage implements ContactListener {

    private static final int VIEWPORT_WIDTH = Constants.APP_WIDTH;
    private static final int VIEWPORT_HEIGHT = Constants.APP_HEIGHT;
    private World world;
    private Cat cat;
    private float accumulator = 0f;

    private Vector3 touchPoint;

    private GameBackground gameBackground = new GameBackground();

    private int jumpSuccessCount = 0;
    private boolean freeContinue = false;
    private int difficultyMod = 5;

    /**
     * Constructor for the game stage
     */
    public GameStage() {
        super(new ScalingViewport(Scaling.stretch, VIEWPORT_WIDTH, VIEWPORT_HEIGHT,
                new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT)));
        GameManager.getInstance().setDifficulty(1);
        setUpWorld();
        resetItems();
        checkItems();
        setUpCamera();
        setUpTouchControlAreas();
    }

    /**
     * reset the items effects to their default values
     */
    private void resetItems() {
        freeContinue = false;
        cat.getUserData().setJumpingLinearImpulse(Constants.CAT_JUMPING_LINEAR_IMPULSE);
        difficultyMod = 5;
    }

    /**
     * check to see if we can consume an item and give user a powerup
     * Priority: free continue > higher jump > slow difficulty
     */
    private void checkItems() {
        GameManager gm = GameManager.getInstance();
        if (gm.useFreeContinue()) {
            freeContinue = true;
        } else {
            if (gm.useHigherJump()) {
                cat.getUserData().setJumpingLinearImpulse(Constants.CAT_JUMPING_LINEAR_IMPULSE_HIGHER);
            } else {
                if (gm.useSlowDifficulty()) {
                    difficultyMod = 7;
                }
            }
        }

    }

    /**
     * Set up the areas for touch controls
     */
    private void setUpTouchControlAreas() {
        touchPoint = new Vector3();
        Gdx.input.setInputProcessor(this);
    }

    /**
     * If cat and enemy have collided then we want to show the fail screen.
     * If cat and floor have collided then we know the cat has landed.
     *
     * @param contact the contact between two objects
     */
    @Override
    public void beginContact(Contact contact) {

        Body a = contact.getFixtureA().getBody();
        Body b = contact.getFixtureB().getBody();

        if ((BodyUtils.bodyIsCat(a) && BodyUtils.bodyIsEnemy(b)) ||
                (BodyUtils.bodyIsEnemy(a) && BodyUtils.bodyIsCat(b))) {
            AudioManager.getInstance().playHitSound();
            cat.hit();
            onFail();
        } else if ((BodyUtils.bodyIsCat(a) && BodyUtils.bodyIsFloor(b)) ||
                (BodyUtils.bodyIsFloor(a) && BodyUtils.bodyIsCat(b))) {
            cat.landed();
        }

    }

    /**
     * Screen shown when cat collides with enemy, and resetting of values.
     */
    private void onFail() {
        gameBackground.setSpeed(0);
        GameManager.getInstance().saveScoreAndCoins(jumpSuccessCount);
        GameManager.getInstance().setScore(jumpSuccessCount);
        addActor(new FailOverlay());
        Rectangle retryButtonShape = new Rectangle((VIEWPORT_WIDTH / 16) * 3, (VIEWPORT_HEIGHT / 16) * 3, 100, 100);
        addActor(new RetryButton(retryButtonShape, new GameRetryButtonListener()));
        Rectangle shopButtonShape = new Rectangle((VIEWPORT_WIDTH / 16) * 7, (VIEWPORT_HEIGHT / 16) * 3, 100, 100);
        addActor(new ShopButton(shopButtonShape, new GameShopButtonListener()));
        Rectangle leaderboardButtonShape = new Rectangle((VIEWPORT_WIDTH / 16) * 11, (VIEWPORT_HEIGHT / 16) * 3, 100, 100);
        addActor(new LeaderboardButton(leaderboardButtonShape, new GameLeaderboardButtonListener()));
    }


    /**
     * Set up world and physics objects.
     */
    private void setUpWorld() {
        world = WorldUtils.createWorld();
        world.setContactListener(this);
        setUpGameBackground();
        setUpFloor();
        setUpCat();
        setUpScoreText();
        createEnemy();
    }

    private void setUpScoreText() {
        ScoreText scoreText = new ScoreText();
        addActor(scoreText);
    }

    /**
     * Set up the floor.
     */
    private void setUpFloor() {
        Floor floor = new Floor(WorldUtils.createFloor(world));
        addActor(floor);
    }

    /**
     * Set up the cat.
     */
    private void setUpCat() {
        cat = new Cat(WorldUtils.createCat(world));
        addActor(cat);
    }

    /**
     * Set up the camera.
     */
    private void setUpCamera() {
        OrthographicCamera camera = new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0f);
        camera.update();
    }

    /**
     * Set up the background of the game.
     */
    private void setUpGameBackground() {
        addActor(gameBackground);
    }

    /**
     * Calls act on all actors in stage.
     *
     * @param delta time in seconds since last frame.
     */
    @Override
    public void act(float delta) {
        super.act(delta);

        Array<Body> bodies = new Array<Body>(world.getBodyCount());
        world.getBodies(bodies);

        for (Body body : bodies) {
            update(body);
        }

        accumulator += delta;

        while (accumulator >= delta) {
            float TIME_STEP = 1 / 300f;
            world.step(TIME_STEP, 6, 2);
            accumulator -= TIME_STEP;
        }
    }

    /**
     * Update the body within the stage, also increases difficulty after
     * diffcultyMod jumps.
     *
     * @param body physics object being updated
     */
    private void update(Body body) {
        if (!BodyUtils.bodyInBounds(body)) {
            if (BodyUtils.bodyIsEnemy(body) && !cat.isHit()) {
                createEnemy();
                jumpSuccessCount++;
                GameManager.getInstance().setScore(jumpSuccessCount);

                if (jumpSuccessCount % difficultyMod == 0) {
                    GameManager.getInstance().increaseDifficulty();

                    if (GameManager.getInstance().getDifficulty() <= 15) {
                        gameBackground.increaseSpeed(30);
                    }

                }

            }
            world.destroyBody(body);
        }
    }

    /**
     * Create a new enemy, add it to world and stage
     */
    private void createEnemy() {
        Enemy enemy = new Enemy(WorldUtils.createEnemy(world));
        enemy.getUserData().setLinearVelocity(GameManager.getInstance().getEnemyDifficultySpeed());
        addActor(enemy);
    }

    /**
     * Override when screen is touched to instruct cat actor to jump
     *
     * @param x x
     * @param y y
     * @param pointer pointer
     * @param button button
     * @return return true if touched
     */
    @Override
    public boolean touchDown(int x, int y, int pointer, int button) {
        translateScreenToWorldCoordinates(x, y);
        cat.jump();
        return super.touchDown(x, y, pointer, button);
    }


    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }

    private void translateScreenToWorldCoordinates(int x, int y) {
        getCamera().unproject(touchPoint.set(x, y, 0));
    }

    /**
     * Listener for retry button
     */
    private class GameRetryButtonListener implements RetryButton.RetryButtonListener {
        @Override
        public void onRetry() {
            GameManager.getInstance().setDifficulty(1);
            if (!freeContinue) {
                GameManager.getInstance().setScore(0);
                jumpSuccessCount = 0;
            }
            gameBackground.resetSpeed();
            clear();
            setUpWorld();
            resetItems();
            checkItems();
            setUpCamera();
            setUpTouchControlAreas();
        }

    }

    /**
     * Listener for shop button
     */
    private class GameShopButtonListener implements ShopButton.ShopButtonListener {
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
            }
        }
    }

    /**
     * Leaderboard button listener
     */
    private class GameLeaderboardButtonListener implements LeaderboardButton.LeaderboardButtonListener {
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
            }
        }
    }

}

