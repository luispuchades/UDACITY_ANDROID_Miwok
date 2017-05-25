/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        //Capture of buttons activity
        TextView numbers = (TextView) findViewById(R.id.numbers);
        TextView phrases = (TextView) findViewById(R.id.phrases);
        TextView family = (TextView) findViewById(R.id.family);
        TextView colors = (TextView) findViewById(R.id.colors);

        // Action defined if numbers button is pushed
        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Define new intent object with the new class NumbersActivity which contains
                // word_list.xmlersActivity.java
                Intent numbersList = new Intent(MainActivity.this, NumbersActivity.class);
                // Start new activity
                startActivity(numbersList);
            }
        });

        // Action defined if phrases button is pushed
        phrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Define new intent object with the new class PhrasesActivity which contains
                // activity_phrases.xml + PhrasesActivity.java
                Intent phrasesList = new Intent(MainActivity.this, PhrasesActivity.class);
                // Start new activity
                startActivity(phrasesList);
            }
        });

        // Action defined if family button is pushed
        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Define new intent object with the new class FamilyActivity which contains
                // activity_family.xml + familyActivity.java
                Intent familyList = new Intent(MainActivity.this, FamilyActivity.class);
                // Start new activity
                startActivity(familyList);
            }
        });

        // Action defined if colors button is pushed
        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Define new intent object with the new class ColorsActivity which contains
                // activity_colors.xml + colorsActivity.java
                Intent colorsList = new Intent(MainActivity.this, ColorsActivity.class);
                // Start new activity
                startActivity(colorsList);
            }
        });
    }
}
