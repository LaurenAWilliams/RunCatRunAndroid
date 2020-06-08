package uk.co.lawilliams.finalproject.runcatrun;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.VideoView;

/**
 * @author Lauren Williams
 *         <p>
 *         Tutorial showing video demonstrating how to jump
 */
public class TutorialActivityJump extends Activity {

    private VideoView videoView;
    private String uriPath;
    private View view;

    /**
     * Called when activity is created
     *
     * @param savedInstanceState state from previous activity. Null if first activity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_jump);
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

        startJumpTutorial();

    }

    /**
     * Start the jump tutorial (video) segment
     */
    private void startJumpTutorial() {

        /**
         * Usually functionality like below would require a worker thread, but setVideoURI already
         * natively utilises threading.
         */

        uriPath = "android.resource://" + getPackageName() + "/" + R.raw.jump_tutorial_vid;
        videoView = (VideoView) findViewById(R.id.video);
        Uri uri = Uri.parse(uriPath);
        videoView.setVideoURI(uri);
        videoView.setVisibility(View.VISIBLE);

        //Slight pause caused by buffering.
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
                videoView.start();
            }
        });

    }

    /**
     * When right gesture is made, stop playback of video and start next activity
     */
    private void rightGesture() {
        videoView.stopPlayback();
        Intent intent = new Intent(this, TutorialActivityEnemies.class);
        startActivity(intent);
    }

    /**
     * Pop last activity on stack
     */
    private void leftGesture() {
        onBackPressed();
    }

    /**
     * When onPause is called by activity lifecycle, stop the video
     */
    @Override
    protected void onPause() {
        super.onPause();
        videoView.stopPlayback();
    }

    /**
     * When onResume is called by activity lifecycle, start the video
     */
    @Override
    protected void onResume() {
        super.onResume();
        videoView.start();
    }

    /**
     * When onStop is called by activity lifecycle, stop the video
     */
    @Override
    protected void onStop() {
        super.onStop();
        videoView.stopPlayback();
    }

}
