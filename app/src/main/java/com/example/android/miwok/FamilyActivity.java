package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //Declare an ArrayList for the Family
        ArrayList<Word> words = new ArrayList<Word>();

        //Modify Element into the ArrayList
        words.add(new Word("father", "ǝpǝ", R.drawable.family_father));
        words.add(new Word("mother", "ǝța", R.drawable.family_mother));
        words.add(new Word("son", "angsi", R.drawable.family_son));
        words.add(new Word("daughter", "tune", R.drawable.family_daughter));
        words.add(new Word("older brother", "taachi", R.drawable.family_older_brother));
        words.add(new Word("younger brother", "chalitti", R.drawable.family_younger_brother));
        words.add(new Word("older sister", "tețe", R.drawable.family_older_sister));
        words.add(new Word("younger sister", "kolliti", R.drawable.family_younger_sister));
        words.add(new Word("grandmother", "ama", R.drawable.family_grandmother));
        words.add(new Word("grandfather", "paapa", R.drawable.family_grandfather));


        //Create new WordAdapter Object that presents pair of words in the new defined layout
        //called list_item
        WordAdapter adapter =
                new WordAdapter(this, words);

        //Capture of ListView listview with ID list
        ListView listView = (ListView) findViewById(R.id.list);

        //Define text to show int the ListView according to the list_item layour managed by the
        //object WordAdapter
        listView.setAdapter(adapter);
    }
}