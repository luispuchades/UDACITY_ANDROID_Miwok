package com.example.android.miwok;

/**
 * Created by luisp on 20/05/2017.
 */


/**
 * {@link Word} represents a vocabulary word that the user wants to learn.
 * It contains a default translation and a Miwok translation for that word.
 */
public class Word {

    /** Default translation for the word */
    private String mDefaultTranslation;

    /** Miwok translation for the word */
    private String mMiwokTranslation;

    /** Image resource ID for the Word*/
    private int mImageResourceID = NO_IMAGE_PROVIDED;

    /** Constant value that represents no image was provided for this word*/
    private static final int NO_IMAGE_PROVIDED = -1;

    /** Sounf resource ID for the Word*/
    private int mAudioResourceID;

    /**
     * Create a new Word object.
     *
     * @param defaultTranslation is the word in a language that the user is already familiar with
     *                           (such as English)
     * @param miwokTranslation is the word in the Miwok language
     *
     * Constructor
     */
    public Word(String defaultTranslation, String miwokTranslation, int audioResourceID) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceID = audioResourceID;
    }

    public Word(String defaultTranslation, String miwokTranslation, int imageResourceID, int audioResourceID){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceID = imageResourceID;
        mAudioResourceID = audioResourceID;
    }


    /**
     * Get the default translation of the word.
     */
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    /**
     * Get the Miwok translation of the word.
     */
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    /**
     * Get the Image Resource ID
     */
    public int getImageResourceID() {
        return mImageResourceID;
    }

    /**
     * Returns whether or not there is an image for this word
     */

    public boolean hasImage(){
        return mImageResourceID != NO_IMAGE_PROVIDED;
    }

    /**
     * Get the Sound Resource ID
     */
    public int getAudioResourceID() {
        return mAudioResourceID;
    }

}