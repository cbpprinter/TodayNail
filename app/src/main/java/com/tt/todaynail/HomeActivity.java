package com.tt.todaynail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.TabHost;

import com.tt.todaynail.tab1.ImageGridAdapter;

public class HomeActivity extends AppCompatActivity {

    private TabHost tabHost;

    private int[] mThumbIds = new int[] { R.drawable.view01,
            R.drawable.view02, R.drawable.view03,
            R.drawable.view04, R.drawable.view05,
            R.drawable.view06, R.drawable.view07
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec tab1 = tabHost.newTabSpec("tab1");
        tab1.setContent(R.id.tab1);
        tab1.setIndicator(getString(R.string.tab1));

        GridView gridViewImages = (GridView)findViewById(R.id.gridView1);
        ImageGridAdapter imageGridAdapter = new ImageGridAdapter(this, mThumbIds);
        gridViewImages.setAdapter(imageGridAdapter);

        TabHost.TabSpec tab2 = tabHost.newTabSpec("tab2");
        tab2.setContent(R.id.tab2);
        tab2.setIndicator(getString(R.string.tab2));

        TabHost.TabSpec tab3 = tabHost.newTabSpec("tab3");
        tab3.setContent(R.id.tab3);
        tab3.setIndicator(getString(R.string.tab3));

        tabHost.addTab(tab1);
        tabHost.addTab(tab2);
        tabHost.addTab(tab3);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.btn_camera){
            Intent intent = new Intent(this, MainActivity.class);
            this.startActivity(intent);

            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}
