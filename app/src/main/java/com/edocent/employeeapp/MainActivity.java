package com.edocent.employeeapp;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.edocent.employeeapp.data.EmployeeDetailFragment;
import com.edocent.employeeapp.data.EmployeeListFragment;

public class MainActivity extends AppCompatActivity implements EmployeeListFragment.EmployeeListFragmentInterface{

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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


    @Override
    public void callEmployeeDetail(long employeeIndex) {
        Log.v(TAG, "In Main Activity got the following index "+employeeIndex);

        //Check if the FrameLayout is being used

        View frameLayoutView = findViewById(R.id.detailFragmentId);
        if(frameLayoutView != null){
            //Create the detail Fragment Object
            EmployeeDetailFragment employeeDetailFragment = new EmployeeDetailFragment();
            employeeDetailFragment.setEmployeeIndex(employeeIndex);

            //Start Fragment Transaction
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.detailFragmentId, employeeDetailFragment);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }else{
            //Call Detail Activity
        }

    }
}
