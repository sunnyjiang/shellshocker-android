package it.stefanobelli.shellshocker;

/**
 * Stefano Belli
 *
 * GitHub: <https://github.com/StefanoBelli>
 * EMail: <stefano9913@gmail.com>
 * Google+: <http://plus.google.com/+StefanoBelli>
 * WebSite: <http://www.inthebit.it>
 *
 * <(C) Copyleft, you can share this code modify and redistribuite.
 *
 * src/it/stefanobelli/shellshocker/MainActivity.java
 *
 * ShellShocker4Android
 */

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        if (id == R.id.action_warningInfo) {
            return true;
        } else if (id == R.id.action_infoDev){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
