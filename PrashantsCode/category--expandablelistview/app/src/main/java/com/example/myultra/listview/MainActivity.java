package com.example.myultra.listview;

import android.app.Activity;
import android.app.ExpandableListActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    HashMap<String, List<String>> Jobs_Category;
    List<String> Jobs_List;
    ExpandableListView Exp_list;
    JobsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Exp_list = (ExpandableListView) findViewById(R.id.exp_list);
        //getting data from dataprovider java class
        Jobs_Category = DataProvider.getInfo();
        // placing data in arraylist
        Jobs_List = new ArrayList<String>(Jobs_Category.keySet());
        // using that arraylist in adapter class
        adapter = new JobsAdapter(this, Jobs_Category, Jobs_List);
        //setting the adapter
        Exp_list.setAdapter(adapter);
        //On the click of any expandable list view , this will work
        Exp_list.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                // Here you can place any funtion to work , here i have placed a toast to show that onChild click funtion is working 
                Toast.makeText(MainActivity.this, "hi ", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
