package com.example.phonexpc.dictionaryawesome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class DictionaryActivity extends AppCompatActivity {

    private static final String[] WORDS = {
            "descry", "to catch sight of",
            "clew", "a ball of thread, yarn, or cord",
            "apodictic", "expressing or of the nature of necessary truth or absolute certainty",
            "alfresco", "taking place or located in the open air",
            "slapdash", "done or made without careful planning"
    };

    private Map<String, String> dictionary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);

        dictionary = new HashMap<>();

        for (int i = 0; i < WORDS.length; i += 2){
            dictionary.put(WORDS[i], WORDS[i+1]);
        }

        ListView list = findViewById(R.id.word_list);

        ArrayAdapter <String> adapter = new ArrayAdapter<>(
             this,
                android.R.layout.simple_list_item_1,
                new ArrayList<String>(dictionary.keySet())
        );

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String word = adapterView.getItemAtPosition(i).toString();
                String defn = dictionary.get(word);
                Toast.makeText(DictionaryActivity.this, defn, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
