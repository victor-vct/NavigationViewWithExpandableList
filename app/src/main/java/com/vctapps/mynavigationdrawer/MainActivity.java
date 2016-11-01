package com.vctapps.mynavigationdrawer;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ExpandableListView mExpandableListView;
    private ExpandableListAdapter mExpandableListAdapter;
    private List<String> mListDataHeader;
    private HashMap<String, List<String>> mListDataChild;
    private View menuItem;

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

        //Carrega os dados nas listas que serão os títulos dos menus e submenus
        prepareLists();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mExpandableListView = (ExpandableListView) findViewById(R.id.expanded_menu_navigation);
        mExpandableListAdapter = new ExpandableListAdapter(this, mListDataHeader, mListDataChild);

        mExpandableListView.setAdapter(mExpandableListAdapter);

        mExpandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                //Altera o background do item para saber qual está selecionado
                if(menuItem != null) menuItem.setBackgroundColor(Color.parseColor("#ffffff"));
                menuItem = v;
                menuItem.setBackgroundColor(Color.parseColor("#DDDDDD"));

                //Fecha o menu
                closeMenuDrawer();

                return false;
            }
        });

        mExpandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {

                return false;
            }
        });
    }

    //Fecha menu lateral
    private void closeMenuDrawer(){
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawers();
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

    //Carrega a lista com menus e submenus
    private void prepareLists(){
        mListDataChild = new HashMap<>();
        mListDataHeader = new ArrayList<>();

        //Itens de menu
        mListDataHeader.add("Item 1");
        mListDataHeader.add("Item 2");
        mListDataHeader.add("Item 3");
        mListDataHeader.add("Item 4");
        mListDataHeader.add("Item 5");
        mListDataHeader.add("Item 6");
        mListDataHeader.add("Item 7");

        //Sub menus
        List<String> subMenu1 = new ArrayList<>();
        subMenu1.add("Submenu 1");
        subMenu1.add("Submenu 2");
        subMenu1.add("Submenu 3");
        subMenu1.add("Submenu 4");

        List<String> subMenu2 = new ArrayList<>();
        subMenu2.add("Submenu 1");
        subMenu2.add("Submenu 2");
        subMenu2.add("Submenu 3");
        subMenu2.add("Submenu 4");

        List<String> subMenu3 = new ArrayList<>();
        subMenu3.add("Submenu 1");
        subMenu3.add("Submenu 2");
        subMenu3.add("Submenu 3");
        subMenu3.add("Submenu 4");

        List<String> subMenu4 = new ArrayList<>();
        subMenu4.add("Submenu 1");
        subMenu4.add("Submenu 2");
        subMenu4.add("Submenu 3");
        subMenu4.add("Submenu 4");

        List<String> subMenu5 = new ArrayList<>();
        subMenu5.add("Submenu 1");
        subMenu5.add("Submenu 2");
        subMenu5.add("Submenu 3");
        subMenu5.add("Submenu 4");

        List<String> subMenu6 = new ArrayList<>();
        subMenu6.add("Submenu 1");
        subMenu6.add("Submenu 2");
        subMenu6.add("Submenu 3");
        subMenu6.add("Submenu 4");
        subMenu6.add("Submenu 5");
        subMenu6.add("Submenu 6");
        subMenu6.add("Submenu 7");
        subMenu6.add("Submenu 8");

        List<String> subMenu7 = new ArrayList<>();
        subMenu7.add("Submenu 1");
        subMenu7.add("Submenu 2");
        subMenu7.add("Submenu 3");
        subMenu7.add("Submenu 4");
        subMenu7.add("Submenu 5");

        mListDataChild.put(mListDataHeader.get(0), subMenu1);
        mListDataChild.put(mListDataHeader.get(1), subMenu2);
        mListDataChild.put(mListDataHeader.get(2), subMenu3);
        mListDataChild.put(mListDataHeader.get(3), subMenu4);
        mListDataChild.put(mListDataHeader.get(4), subMenu5);
        mListDataChild.put(mListDataHeader.get(5), subMenu6);
        mListDataChild.put(mListDataHeader.get(6), subMenu7);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
