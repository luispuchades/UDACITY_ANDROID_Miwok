package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import static android.R.attr.id;

public class ColorsActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    /**
     * Declaration of AudioManager Object
     */
    private AudioManager mAudioManager;


    /**
     * Definition of onAudioFocusChangeListener method
     * Definition of procedures depending on event passed by OnAucioFocusChangeListener
     */
    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {

                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {

                mMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {

                releaseMediaPlayer();
            }
        }
    };

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;

            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }

    //Async method callback to define when MediaPlayer has finished
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //Declaration of audioManager context
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);


        //Declare an ArrayList for the colors
        final ArrayList<Word> words = new ArrayList<Word>();

        //Modify Element into the ArrayList
        words.add(new Word("red", "wețețți", R.drawable.color_red, R.raw.color_red));
        words.add(new Word("green", "chokokki", R.drawable.color_green, R.raw.color_green));
        words.add(new Word("brown", "țakaakki", R.drawable.color_brown, R.raw.color_brown));
        words.add(new Word("grey", "țopooppi", R.drawable.color_gray, R.raw.color_gray));
        words.add(new Word("black", "kululli", R.drawable.color_black, R.raw.color_black));
        words.add(new Word("white", "kelelli", R.drawable.color_white, R.raw.color_white));
        words.add(new Word("dusty yellow", "țopiisǝ", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        words.add(new Word("mustard yellow", "chiwiitǝ", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));


        //Create new WordAdapter Object that presents pair of words in the new defined layout
        //called list_item
        WordAdapter adapter =
                new WordAdapter(this, words, R.color.category_colors);

        //Capture of ListView listview with ID list
        ListView listView = (ListView) findViewById(R.id.list);

        //Define text to show int the ListView according to the list_item layour managed by the
        //object WordAdapter
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                // Release the media player if it currently exists because we are about to
                // play a different sound file
                releaseMediaPlayer();

                // Get the position variable
                Word word = words.get(position);


                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {


                    mMediaPlayer = MediaPlayer.create(ColorsActivity.this,
                            word.getAudioResourceID());
                    // no need to call prepare(); create() does that for you
                    mMediaPlayer.start();
                    // Setup a listener on the media player , so that we can stop and release the
                    // media player once the soundshas finsihed playing
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        // When the activity is stopped, release the media player resources because we won't
        // be playing any more sounds.
        releaseMediaPlayer();
    }

}
