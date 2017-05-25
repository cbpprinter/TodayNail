package com.tt.todaynail;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TabHost;

import com.tt.todaynail.tab1.ImageActivity;
import com.tt.todaynail.tab1.ImageGridAdapter;
import com.tt.todaynail.tab2.CompanyAdapter;
import com.tt.todaynail.tab2.company;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private TabHost tabHost;

    private ListView listView;
    ArrayList<company> h_info_list;
    CompanyAdapter myadapter;
    company myHuman1,myHuman2;


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

        listView = (ListView)findViewById(R.id.listView2);
        myHuman1 = new company("오늘네일1", "경기도", BitmapFactory.decodeResource(getResources(), R.drawable.view01));
        myHuman2 = new company("네일2", "서울특별시", BitmapFactory.decodeResource(getResources(), R.drawable.view02));
        h_info_list = new ArrayList<company>();
        h_info_list.add(myHuman1);
        h_info_list.add(myHuman2);
        h_info_list.add(myHuman1);
        h_info_list.add(myHuman2);
        h_info_list.add(myHuman1);
        h_info_list.add(myHuman2);

        myadapter = new CompanyAdapter(getApplicationContext(),R.layout.activity_tab2, h_info_list);
        listView.setAdapter(myadapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), ImageActivity.class); // 다음넘어갈 화면
                Bitmap sendBitmap = h_info_list.get(position).image;

                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                sendBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                byte[] byteArray = stream.toByteArray();

                intent.putExtra("image",byteArray);
                startActivity(intent);
            }
        });


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
