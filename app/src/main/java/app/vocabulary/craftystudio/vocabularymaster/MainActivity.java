package app.vocabulary.craftystudio.vocabularymaster;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

import utils.ClickListener;
import utils.FirebaseHandler;
import utils.Level;
import utils.LevelAdapter;
import utils.Word;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ArrayList<Level> levelnameList = new ArrayList<>();
    private RecyclerView recyclerView;
    private LevelAdapter mAdapter;

    Level mLevel, mLevel1, mLevel2, mLevel3;

    // Access a Cloud Firestore instance from your Activity

    FirebaseFirestore db = FirebaseFirestore.getInstance();

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

                Word word = new Word();
                word.setWordMeaning("meaning");
                word.setWordExample("example is this");
                word.setWordSynonyms("synonyms");
                word.setWordAntonyms("antonym is this");
                word.setWordName("word");
                word.setOptionA("m");
                word.setOptionB("b");
                word.setOptionC("meaning");
                word.setOptionD("d");
                word.setWordLevel(1);

                FirebaseHandler firebaseHandler = new FirebaseHandler(MainActivity.this);
                firebaseHandler.uploadWord(word);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        recyclerView = (RecyclerView) findViewById(R.id.level_recycler_view);

        //Dummy level code to recyclerview

        mLevel = new Level();
        mLevel.setLevelName("Hello");

        mLevel1 = new Level();
        mLevel1.setLevelName("Mona");

        mLevel2 = new Level();
        mLevel2.setLevelName("IM ia");

        mLevel3 = new Level();
        mLevel3.setLevelName("loadjj");

        levelnameList.add(0, mLevel);
        levelnameList.add(1, mLevel1);
        levelnameList.add(2, mLevel2);
        levelnameList.add(3, mLevel3);


        mAdapter = new LevelAdapter(this, new ClickListener() {
            @Override
            public void onItemCLickListener(View view, int position) {

                openWordLearnActivity(position);
                Toast.makeText(getApplicationContext(), "Item Clicked" + levelnameList.get(position).getLevelName(), Toast.LENGTH_SHORT).show();
            }
        }, levelnameList);

        //  mAdapter.notifyDataSetChanged();

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);


    }

    private void openWordLearnActivity(int position) {
        Intent intent = new Intent(MainActivity.this, WordLearnActivity.class);
        intent.putExtra("Level", levelnameList.get(position).getLevelName());
        startActivity(intent);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {

            FirebaseHandler firebaseHandler = new FirebaseHandler(MainActivity.this);
            firebaseHandler.downloadWordByLevel(1);
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            FirebaseHandler firebaseHandler = new FirebaseHandler(MainActivity.this);
            firebaseHandler.downloadWordByName("WordName");

        } else if (id == R.id.nav_slideshow) {
            Intent intent = new Intent(MainActivity.this, WordReviseActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_manage) {
            Intent intent = new Intent(MainActivity.this, WordTestActivity.class);
            startActivity(intent);


        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
