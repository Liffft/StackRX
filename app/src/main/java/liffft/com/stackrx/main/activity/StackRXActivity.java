package liffft.com.stackrx.main.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;

import com.google.inject.Inject;

import liffft.com.stackrx.R;
import liffft.com.stackrx.main.widget.NavigationDrawerFragment;
import roboguice.RoboGuice;
import roboguice.activity.RoboActionBarActivity;
import roboguice.inject.ContentView;

@ContentView(R.layout.stack_rx_activity)
public class StackRXActivity extends RoboActionBarActivity {

    //region INJECTED CLASSES ----------------------------------------------------------------------
    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    @Inject
    private NavigationDrawerFragment mNavigationDrawerFragment;

    //endregion

    //region INJECTED VIEWS ------------------------------------------------------------------------
    //endregion

    //region LOCAL CONSTANTS -----------------------------------------------------------------------
    //endregion

    //region CLASS VARIABLES -----------------------------------------------------------------------
    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    //endregion

    //region CONSTRUCTOR ---------------------------------------------------------------------------
    public StackRXActivity() {
    }

    //endregion

    //region LIFE CYCLE METHODS --------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        RoboGuice.setUseAnnotationDatabases(false);
        super.onCreate(savedInstanceState);
        mTitle = getTitle();
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));


    }

    //endregion

    //region WIDGET --------------------------------------------------------------------------------
    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.stack_rx, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
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
    //endregion

    //region LISTENERS -----------------------------------------------------------------------------
    //endregion

    //region EVENTS --------------------------------------------------------------------------------
    //endregion

    //region LOCAL METHODS -------------------------------------------------------------------------
    //endregion

    //region SUBSCRIBERS ---------------------------------------------------------------------------
    //endregion

    //region ACCESSORS -----------------------------------------------------------------------------
    //endregion

    //region INNER CLASSES -------------------------------------------------------------------------
    //endregion

    //region CLASS METHODS -------------------------------------------------------------------------
    //endregion

}
