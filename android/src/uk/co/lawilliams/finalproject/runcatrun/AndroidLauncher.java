package uk.co.lawilliams.finalproject.runcatrun;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.google.android.gms.games.Games;
import com.google.example.games.basegameutils.GameHelper;

import uk.co.lawilliams.finalproject.runcatrun.utils.AndroidInterface;
import uk.co.lawilliams.finalproject.runcatrun.utils.GameManager;

/**
 * @author Lauren Williams, leaderboard functionality made using tutorial by TheInvader360
 * @see [TheInvader360] (http://theinvader360.blogspot.co.uk/2013/10/google-play-game-services-tutorial-example.html)
 * <p>
 * Starting activity that controls LibGDX modules
 */

public class AndroidLauncher extends AndroidApplication implements GameHelper.GameHelperListener, AndroidInterface {

    private GameHelper gameHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RelativeLayout layout = new RelativeLayout(this);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().clearFlags(
                WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);

        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();

        View gameView = initializeForView(new RunCatRun(this), config);
        layout.addView(gameView);

        setContentView(layout);

        gameHelper = new GameHelper(this, GameHelper.CLIENT_GAMES);
        gameHelper.enableDebugLog(true);
        gameHelper.setup(this);
        gameHelper.setMaxAutoSignInAttempts(0);
    }

    /**
     * Called when tutorial button pressed on menu of LibGDX module
     */
    @Override
    public void showTutorial() {
        Intent intent = new Intent(this, TutorialActivityJump.class);
        startActivity(intent);
    }

    /**
     * Called when leaderboard button pressed on menu of LibGDX module
     */
    @Override
    public void showLeaderboards() {
        if (getSignedInGPGS())
            getLeaderboardGPGS();
        else
            loginGPGS();
    }

    /**
     * Called when shop button pressed on menu of LibGDX module
     */
    @Override
    public void showShop() {
        Intent intent = new Intent(this, ShopActivity.class);
        startActivity(intent);
    }

    /**
     * Overridden method called by Activity Lifecycle, also calls onStart on gameHelper
     */
    @Override
    public void onStart() {
        super.onStart();
        gameHelper.onStart(this);
    }

    /**
     * Overridden method called by Activity Lifecycle, also calls onStop on gameHelper
     */
    @Override
    public void onStop() {
        super.onStop();
        gameHelper.onStop();
    }

    /**
     * Allows us to get result from next activity (in this case, the leaderboard)
     *
     * @param request
     * @param response
     * @param data
     */
    @Override
    public void onActivityResult(int request, int response, Intent data) {
        super.onActivityResult(request, response, data);
        gameHelper.onActivityResult(request, response, data);
    }

    /**
     * Login to google play services
     */
    @Override
    public void loginGPGS() {
        try {
            runOnUiThread(new Runnable() {
                public void run() {
                    gameHelper.beginUserInitiatedSignIn();
                }
            });
        } catch (final Exception ex) {
        }
    }

    /**
     * Submit score to google play services
     *
     * @param score score achieved
     */
    @Override
    public void submitScoreGPGS(int score) {
        if (gameHelper.isSignedIn()) {
            Games.Leaderboards.submitScore(gameHelper.getApiClient(),
                    getString(R.string.leaderboard_run_cat_run_leaderboard), score);
        } else {
            GameManager.getInstance().saveScore(score);
        }
    }

    /**
     * Gets the game's leaderboard from google play services
     */
    @Override
    public void getLeaderboardGPGS() {
        if (gameHelper.isSignedIn()) {
            startActivityForResult(Games.Leaderboards.getLeaderboardIntent(gameHelper.getApiClient(), getString(R.string.leaderboard_run_cat_run_leaderboard)), 100);
        } else if (!gameHelper.isConnecting()) {
            loginGPGS();
        }
    }

    /**
     *
     * @return true if user is signed into google play services, false if not
     */
    @Override
    public boolean getSignedInGPGS() {
        return gameHelper.isSignedIn();
    }

    @Override
    public void onSignInFailed() {

    }

    @Override
    public void onSignInSucceeded() {

    }

}
