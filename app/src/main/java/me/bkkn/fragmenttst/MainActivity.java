package me.bkkn.fragmenttst;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements SettingsFragment.OnFragmentInteractionListener,
        SearchFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {


            case R.id.settings:
                //launch settings fragment

                FragmentManager fragmentManager = getSupportFragmentManager();

                fragment = fragmentManager.findFragmentById(R.id.settings_fragment);
                if (fragment == null)
                    fragment = SettingsFragment.newInstance();
                fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
                Toast.makeText(this, R.string.settings, Toast.LENGTH_SHORT).show();
                break;
            case R.id.search:
                //launch search fragment

                fragmentManager = getSupportFragmentManager();
                fragment = fragmentManager.findFragmentById(R.id.search_fragment);
                if (fragment == null)
                    fragment = SearchFragment.newInstance();
                fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
                Toast.makeText(this, R.string.search, Toast.LENGTH_SHORT).show();
                break;
            case R.id.quit:
                //launch quit fragment
                Toast.makeText(this, R.string.quit, Toast.LENGTH_SHORT).show();
                this.finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
