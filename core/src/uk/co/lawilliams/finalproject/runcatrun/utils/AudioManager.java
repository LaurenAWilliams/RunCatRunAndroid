package uk.co.lawilliams.finalproject.runcatrun.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

/**
 * @author Lauren Williams
 *         <p>
 *         Singleton class that loads and handles audio.
 *         <p>
 *         Sources:
 * @see [music.wav] (https://www.dl-sounds.com/royalty-free/urban-loop2-97/)
 * @see [hit.mp3] (http://soundbible.com/1952-Punch-Or-Whack.html)
 * @see [jump.wav] (https://opengameart.org/content/platformer-jumping-sounds)
 */

public class AudioManager {

    private static AudioManager instance = new AudioManager();
    private static Music music;
    private static Sound jumpSound;
    private static Sound hitSound;

    /**
     * Constructor
     */
    private AudioManager() {

    }

    /**
     * @return instance of audio manager
     */
    public static AudioManager getInstance() {
        return instance;
    }

    /**
     * Dispose of music and sounds
     */
    public static void dispose() {
        music.dispose();
        jumpSound.dispose();
        hitSound.dispose();
    }

    /**
     * Load in music and sounds. Also play music.
     */
    public void load() {
        music = Gdx.audio.newMusic(Gdx.files.internal(Constants.MUSIC_PATH));
        music.setLooping(true);
        music.play();
        jumpSound = Gdx.audio.newSound(Gdx.files.internal(Constants.JUMP_SOUND_PATH));
        hitSound = Gdx.audio.newSound(Gdx.files.internal(Constants.HIT_SOUND_PATH));
    }

    /**
     * Play hit.mp3
     */
    public void playHitSound() {
        hitSound.play();
    }

    /**
     * Play jump.wav
     */
    public void playJumpSound() {
        jumpSound.play();
    }

    /**
     * Mutes the music if playing, else plays the music
     */
    public void muteMusic() {
        if (music.isPlaying()) {
            music.setLooping(false);
            music.stop();
        } else {
            music.setLooping(true);
            music.play();
        }
    }
}
