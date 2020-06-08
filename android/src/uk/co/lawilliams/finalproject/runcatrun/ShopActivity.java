package uk.co.lawilliams.finalproject.runcatrun;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import uk.co.lawilliams.finalproject.runcatrun.utils.GameManager;

/**
 * @author Lauren Williams
 *         <p>
 *         Shop Activity that allows user to buy power ups that are automatically used when starting the
 *         game. Shows how many the user currently have, and how many coins the user has.
 */

public class ShopActivity extends Activity {

    TextView coinsText;
    TextView infoText;
    TextView sdiCountText;
    TextView jhCountText;
    TextView fcCountText;
    Button freeContinueButton;
    Button difficultyButton;
    Button highJumpButton;

    /**
     * Called when activity created.
     *
     * @param savedInstanceState state from previous activity. Null if first activity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        coinsText = (TextView) findViewById(R.id.coinsText);
        infoText = (TextView) findViewById(R.id.infoText);
        sdiCountText = (TextView) findViewById(R.id.sdiCountText);
        jhCountText = (TextView) findViewById(R.id.jhCountText);
        fcCountText = (TextView) findViewById(R.id.fcCountText);

        freeContinueButton = (Button) findViewById(R.id.freeContinueButton);
        difficultyButton = (Button) findViewById(R.id.difficultyButton);
        highJumpButton = (Button) findViewById(R.id.jumpButton);

        freeContinueButton.setOnClickListener(clickListener);
        difficultyButton.setOnClickListener(clickListener);
        highJumpButton.setOnClickListener(clickListener);

        updateItemAndCoinsText();
    }

    private void updateItemAndCoinsText() {
        int coins = loadCoins();
        int continues = loadFreeContinue();
        int difficulties = loadSlowDifficulties();
        int higherJumps = loadHigherJumps();
        coinsText.setText("Coins: " + coins);
        sdiCountText.setText("Have: " + difficulties);
        fcCountText.setText("Have: " + continues);
        jhCountText.setText("Have: " + higherJumps);

    }

    /**
     * @return number of coins user has accumulated.
     */
    private int loadCoins() {
        return GameManager.getInstance().loadCoins();
    }

    /**
     * @param coins coins left after a transaction
     */
    private void saveCoins(int coins) {
        GameManager.getInstance().saveCoins(coins);
    }

    /**
     * @return load number of continue power ups user has.
     */
    private int loadFreeContinue() {
        GameManager gm = GameManager.getInstance();
        return gm.loadFreeContinue();
    }

    /**
     * @return load number of higher jump power ups user has.
     */
    private int loadHigherJumps() {
        GameManager gm = GameManager.getInstance();
        return gm.loadHigherJump();
    }

    /**
     * @return load number of slower difficulty power ups user has.
     */
    private int loadSlowDifficulties() {
        GameManager gm = GameManager.getInstance();
        return gm.loadSlowerDifficulty();
    }

    /**
     * load number of free continues, add one then save them
     */
    private void purchasedFreeContinue() {
        GameManager gm = GameManager.getInstance();
        int continues = gm.loadFreeContinue();
        gm.saveFreeContinue(continues + 1);
    }

    /**
     * load number of slow difficulties, add one then save them
     */
    private void purchasedSlowDifficulty() {
        GameManager gm = GameManager.getInstance();
        int slows = gm.loadSlowerDifficulty();
        gm.saveSlowerDifficulty(slows + 1);
    }

    /**
     * load number of higher jumps, add one then save them
     */
    private void purchasedHigherJump() {
        GameManager gm = GameManager.getInstance();
        int highs = gm.loadHigherJump();
        gm.saveHigherJump(highs + 1);
    }

    /**
     * Click listener for the different buttons, preventing user from buying an item they don't have
     * money for. Updates coin number and power ups number after every transaction.
     */
    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int coins;
            switch (v.getId()) {
                case R.id.freeContinueButton:
                    if (loadCoins() >= 10) {
                        coins = loadCoins() - 10;
                        saveCoins(coins);
                        purchasedFreeContinue();
                        infoText.setText("Free Continue purchased!");
                        updateItemAndCoinsText();
                    } else {
                        infoText.setText("Need " + (10 - loadCoins()) + " more coins.");
                    }
                    break;
                case R.id.difficultyButton:
                    if (loadCoins() >= 15) {
                        coins = loadCoins() - 15;
                        saveCoins(coins);
                        purchasedSlowDifficulty();
                        infoText.setText("Slower Difficulty Increase purchased!");
                        updateItemAndCoinsText();
                    } else {
                        infoText.setText("Need " + (15 - loadCoins()) + " more coins.");
                    }
                    break;
                case R.id.jumpButton:
                    if (loadCoins() >= 5) {
                        coins = loadCoins() - 5;
                        saveCoins(coins);
                        purchasedHigherJump();
                        infoText.setText("Jump Higher purchased!");
                        updateItemAndCoinsText();
                    } else {
                        infoText.setText("Need " + (5 - loadCoins()) + " more coins.");
                    }
                    break;
                default:
                    break;
            }
            updateItemAndCoinsText();
        }
    };

}
