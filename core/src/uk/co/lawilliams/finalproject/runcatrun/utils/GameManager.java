package uk.co.lawilliams.finalproject.runcatrun.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.math.Vector2;

/**
 * @author Lauren Williams
 *         <p>
 *         Singleton class handling miscellaneous utilities: handling coins, score
 *         and items.
 */

public class GameManager implements AndroidInterface {

    private static GameManager thisInstance;
    private int level;
    private int score;
    private boolean loginAttempted = false;

    private AndroidInterface androidInterface;

    private GameManager() {
    }

    /**
     * @return an instance of GameManager
     */
    public static GameManager getInstance() {
        if (thisInstance == null) {
            thisInstance = new GameManager();
        }
        return thisInstance;
    }

    /**
     * @return preferences stored locally on device
     */
    private Preferences getPreferences() {
        return Gdx.app.getPreferences(Constants.PREFERENCES_NAME);
    }

    /**
     * @param androidInterface interface for LibGDX module to use
     *                         AndroidLauncher
     */
    public void setAndroidInterface(AndroidInterface androidInterface) {
        this.androidInterface = androidInterface;
    }

    /**
     * @return the number of higher jump power ups left
     */
    public int loadHigherJump() {
        Preferences pref = getPreferences();
        int higherJumpCount = pref.getInteger(Constants.ITEM_HIGHERJUMP_PREFERENCE, 0);
        pref.flush();
        return higherJumpCount;
    }

    /**
     * @return the number of free continue power ups left
     */
    public int loadFreeContinue() {
        Preferences pref = getPreferences();
        int freeContinueCount = pref.getInteger(Constants.ITEM_FREECONTINUE_PREFERENCE, 0);
        pref.flush();
        return freeContinueCount;
    }

    /**
     * @return the number of slower difficulty increase power ups left
     */
    public int loadSlowerDifficulty() {
        Preferences pref = getPreferences();
        int slowDifficultyCount = pref.getInteger(Constants.ITEM_SLOWERDIFFICULTY_PREFERENCE, 0);
        pref.flush();
        return slowDifficultyCount;
    }

    /**
     * @param highJumpCount the number of higher jump power ups being saved locally
     */
    public void saveHigherJump(int highJumpCount) {
        Preferences pref = getPreferences();
        pref.putInteger(Constants.ITEM_HIGHERJUMP_PREFERENCE, highJumpCount);
        pref.flush();
    }

    /**
     * @param freeContinueCount the number of free continue power ups being saved locally
     */
    public void saveFreeContinue(int freeContinueCount) {
        Preferences pref = getPreferences();
        pref.putInteger(Constants.ITEM_FREECONTINUE_PREFERENCE, freeContinueCount);
        pref.flush();
    }

    /**
     * @param slowDifficultyCount the number of slower difficulty powers ups being saved
     */
    public void saveSlowerDifficulty(int slowDifficultyCount) {
        Preferences pref = getPreferences();
        pref.putInteger(Constants.ITEM_SLOWERDIFFICULTY_PREFERENCE, slowDifficultyCount);
        pref.flush();
    }

    /**
     * @return true if there is 1 or more higher jump power ups left, false if there isn't
     */
    public boolean useHigherJump() {
        int higherJumpCount = loadHigherJump();

        if (higherJumpCount > 0) {
            higherJumpCount = higherJumpCount - 1;
            saveHigherJump(higherJumpCount);
            return true;
        } else {
            return false;
        }

    }

    /**
     * @return true if there is 1 or more free continue power ups left, false if there isn't
     */
    public boolean useFreeContinue() {
        int freeContinueCount = loadFreeContinue();

        if (freeContinueCount > 0) {
            freeContinueCount = freeContinueCount - 1;
            saveFreeContinue(freeContinueCount);
            return true;
        } else {
            return false;
        }

    }

    /**
     * @return true if there is 1 or more slower difficulty power ups left, false if there is not
     */
    public boolean useSlowDifficulty() {
        int slowDifficultyCount = loadSlowerDifficulty();

        if (slowDifficultyCount > 0) {
            slowDifficultyCount = slowDifficultyCount - 1;
            saveSlowerDifficulty(slowDifficultyCount);
            return true;
        } else {
            return false;
        }

    }

    /**
     * @param score the score the user has achieved, and what will be saved before quiting.
     *              Coins are also calculated from score
     */
    public void saveScoreAndCoins(int score) {

        if (getSignedInGPGS()) {
            submitScoreGPGS(score);
        } else {
            if (!loginAttempted) {
                loginGPGS();
                submitScoreGPGS(score);
                loginAttempted = true;
            }
        }

        Preferences preferences = getPreferences();
        if (score > preferences.getInteger(Constants.SCORE_PREFERENCE, 0)) {
            preferences.putInteger(Constants.SCORE_PREFERENCE, score);
        }
        int coins = preferences.getInteger(Constants.COIN_PREFERENCE, 0) + Math.round(score / 10);
        preferences.putInteger(Constants.COIN_PREFERENCE, coins);
        preferences.flush();
    }

    public void saveScore(int score) {
        Preferences preferences = getPreferences();
        if (score > preferences.getInteger(Constants.SCORE_PREFERENCE, 0)) {
            preferences.putInteger(Constants.SCORE_PREFERENCE, score);
        }
        preferences.flush();
    }

    /**
     * @return number of coins the user has accumulated.
     */
    public int loadCoins() {
        Preferences pref = getPreferences();
        int coins = pref.getInteger(Constants.COIN_PREFERENCE, 0);
        pref.flush();
        return coins;

    }

    /**
     * @param coins number of coins to be saved
     */
    public void saveCoins(int coins) {
        Preferences pref = getPreferences();
        pref.putInteger(Constants.COIN_PREFERENCE, coins);
        pref.flush();
    }

    /**
     * @return score - note this is temporary and not saved
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score temporary score achieved
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * get the current difficulty and increase it by 1
     */
    public void increaseDifficulty() {
        setDifficulty(getDifficulty() + 1);
    }

    /**
     * @return the speed of the enemy depending on what the current difficulty is
     */
    public Vector2 getEnemyDifficultySpeed() {
        Vector2 enemyDifficultySpeed;
        int difficulty = getDifficulty();

        switch (difficulty) {
            case 1:
                enemyDifficultySpeed = Constants.ENEMY_LINEAR_VELOCITY;
                break;
            case 2:
                enemyDifficultySpeed = new Vector2(-12f, 0f);
                break;
            case 3:
                enemyDifficultySpeed = new Vector2(-14f, 0f);
                break;
            case 4:
                enemyDifficultySpeed = new Vector2(-16f, 0f);
                break;
            case 5:
                enemyDifficultySpeed = new Vector2(-18f, 0f);
                break;
            case 6:
                enemyDifficultySpeed = new Vector2(-20f, 0f);
                break;
            case 7:
                enemyDifficultySpeed = new Vector2(-22f, 0f);
                break;
            case 8:
                enemyDifficultySpeed = new Vector2(-24f, 0f);
                break;
            case 9:
                enemyDifficultySpeed = new Vector2(-26f, 0f);
                break;
            case 10:
                enemyDifficultySpeed = new Vector2(-28f, 0f);
                break;
            case 11:
                enemyDifficultySpeed = new Vector2(-30f, 0f);
                break;
            case 12:
                enemyDifficultySpeed = new Vector2(-32f, 0f);
                break;
            case 13:
                enemyDifficultySpeed = new Vector2(-34f, 0f);
                break;
            case 14:
                enemyDifficultySpeed = new Vector2(-36f, 0f);
                break;
            case 15:
                enemyDifficultySpeed = new Vector2(-38f, 0f);
                break;
            default:
                enemyDifficultySpeed = Constants.ENEMY_LINEAR_VELOCITY;
                break;
        }
        return enemyDifficultySpeed;


    }

    /**
     * @return the current difficulty level
     */
    public int getDifficulty() {
        return this.level;
    }

    /**
     * @param level the difficulty level that we wish to change to. This level cannot be above 15
     *              and is caught in the body of this function.
     */
    public void setDifficulty(int level) {
        if (level <= 15) {
            this.level = level;
        }
    }

    /**
     * interfaces with AndroidLauncher to change activity to tutorial
     */
    @Override
    public void showTutorial() {
        androidInterface.showTutorial();
    }

    /**
     * interfaces with AndroidLauncher to change activity to leaderboard
     */
    @Override
    public void showLeaderboards() {
        androidInterface.showLeaderboards();
    }

    /**
     * interfaces with AndroidLauncher to change activity to shop
     */
    @Override
    public void showShop() {
        androidInterface.showShop();
    }

    /**
     * Interfaces with AndroidLauncher to login to Google Play Services
     */
    @Override
    public void loginGPGS() {
        androidInterface.loginGPGS();
    }

    /**
     * Submit score to Google Play services
     *
     * @param score score to be submitted
     */
    @Override
    public void submitScoreGPGS(int score) {
        androidInterface.submitScoreGPGS(score);
    }

    /**
     * Check if user is signed in
     *
     * @return true if user signed in, else false
     */
    @Override
    public boolean getSignedInGPGS() {
        return androidInterface.getSignedInGPGS();
    }

    /**
     * Gets leaderboard for Google Play Services
     */
    @Override
    public void getLeaderboardGPGS() {

    }

}
