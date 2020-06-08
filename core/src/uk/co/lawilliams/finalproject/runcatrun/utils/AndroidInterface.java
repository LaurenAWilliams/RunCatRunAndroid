package uk.co.lawilliams.finalproject.runcatrun.utils;

/**
 * @author Lauren Williams
 *         <p>
 *         Allows LibGDX module to call methods from AndroidLauncher
 */

public interface AndroidInterface {

    /**
     * Allows LibGDX module to call showTutorial from AndroidLauncher
     */
    void showTutorial();

    /**
     * Allows LibGDX module to call showLeaderboard from AndroidLauncher
     */
    void showLeaderboards();

    /**
     * Allows LibGDX module to call showShop from AndroidLauncher
     */
    void showShop();

    /**
     * Able to call login for Google Play Services
     */
    void loginGPGS();

    /**
     * Able to submit score for Google Play Services
     *
     * @param score score to be submitted
     */
    void submitScoreGPGS(int score);

    /**
     * Check if user is signed in
     *
     * @return true if user signed in, else false
     */
    boolean getSignedInGPGS();

    /**
     * Get leaderboard for google play services
     */
    void getLeaderboardGPGS();

}
