package uk.co.lawilliams.finalproject.runcatrun;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * @author Lauren Williams
 *         <p>
 *         Tutorial showing enemy animations
 */
public class TutorialActivityEnemies extends Activity {

    private AnimationDrawable dogAnimation;
    private AnimationDrawable carAnimation;
    private AnimationDrawable planeAnimation;
    private View view;

    /**
     * Called when activity is created
     *
     * @param savedInstanceState state from previous activity. Null if first activity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_enemies);
        view = this.findViewById(android.R.id.content);

        /**
         * When screen is swiped left or right..
         */
        view.setOnTouchListener(new OnSwipeTouchListener(this) {
            @Override
            public void onSwipeLeft() {
                rightGesture();
            }

            @Override
            public void onSwipeRight() {
                leftGesture();
            }
        });

        /**
         * Set up of animations
         */
        ImageView dogImage = (ImageView) findViewById(R.id.imageDog);
        dogImage.setBackgroundResource(R.drawable.dog_animation);
        dogAnimation = (AnimationDrawable) dogImage.getBackground();

        ImageView carImage = (ImageView) findViewById(R.id.imageCar);
        carImage.setBackgroundResource(R.drawable.car_animation);
        carAnimation = (AnimationDrawable) carImage.getBackground();

        ImageView planeImage = (ImageView) findViewById(R.id.imagePlane);
        planeImage.setBackgroundResource(R.drawable.plane_animation);
        planeAnimation = (AnimationDrawable) planeImage.getBackground();
    }

    private void rightGesture() {
    }

    /**
     * Pop activity from activity stack to return to previous activity
     */
    private void leftGesture() {
        onBackPressed();
    }

    /**
     * Called when activity is paused or stopped.
     */
    private void stopAnimations() {
        dogAnimation.stop();
        planeAnimation.stop();
        carAnimation.stop();
    }

    /**
     * Called when activity is resumed or the window has focus
     */
    private void startAnimations() {
        dogAnimation.start();
        planeAnimation.start();
        carAnimation.start();
    }

    /**
     * Called when window is loaded in. Ensures start isn't called before animations have loaded.
     *
     * @param hasFocus
     */
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        startAnimations();
    }

    /**
     * When onPause is called by activity lifecycle, stop animations
     */
    @Override
    protected void onPause() {
        super.onPause();
        stopAnimations();
    }

    /**
     * When onResume is called by activity lifecycle, start animations
     */
    @Override
    protected void onResume() {
        super.onResume();
        startAnimations();
    }

    /**
     * When onStop is called by activity lifecycle, stop animations
     */
    @Override
    protected void onStop() {
        super.onStop();
        stopAnimations();
    }
}
