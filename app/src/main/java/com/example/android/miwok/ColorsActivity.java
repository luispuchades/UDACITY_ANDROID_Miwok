package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //Declare an ArrayList for the colors
        ArrayList<Word> words = new ArrayList<Word>();

        //Modify Element into the ArrayList
        words.add(new Word("red", "wețețți", R.drawable.color_red));
        words.add(new Word("green", "chokokki", R.drawable.color_green));
        words.add(new Word("brown", "țakaakki", R.drawable.color_brown));
        words.add(new Word("grey", "țopooppi", R.drawable.color_gray));
        words.add(new Word("black", "kululli", R.drawable.color_black));
        words.add(new Word("white", "kelelli", R.drawable.color_white));
        words.add(new Word("dusty yellow", "țopiisǝ", R.drawable.color_dusty_yellow));
        words.add(new Word("mustard yellow", "chiwiitǝ", R.drawable.color_mustard_yellow));


        //Create new WordAdapter Object that presents pair of words in the new defined layout
        //called list_item
        WordAdapter adapter =
                new WordAdapter(this, words, R.color.category_colors);

        //Capture of ListView listview with ID list
        ListView listView = (ListView) findViewById(R.id.list);

        //Define text to show int the ListView according to the list_item layour managed by the
        //object WordAdapter
        listView.setAdapter(adapter);
    }
}
