package com.baf.musafir.bafphonebook.main;

import android.app.Activity;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.Context;
import android.content.Intent;
import android.content.OperationApplicationException;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.CommonDataKinds.StructuredName;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baf.musafir.bafphonebook.R;

import java.util.ArrayList;

public class NationalAnthemActivity extends Activity {
    String respones_results;
    TextView songTitle;
    Context context;
    Typeface face;

    MediaPlayer mPlayer;
    private TextView song_lyrics;
    private TextView topbar_text;
    private LinearLayout player_footer_bg;
    private String NATIONAL_ANTHOM = "";
    private String SENA_SONGIT = "";
    private String RONO_SONGIT = "";
    private String BEGMENT_SONG = "";
    private String SPEATCH = "";
    private String SONG_TYPE = "";

    /** Called when the activity is first created. */
    @SuppressWarnings("static-access")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.player);
        context = this;
        face = Typeface.createFromAsset(context.getAssets(), "SolaimanLipi.ttf");
        NATIONAL_ANTHOM = getString(R.string.national_anthem);

        song_lyrics = (TextView) findViewById(R.id.song_lyrics);
        topbar_text = (TextView) findViewById(R.id.topbar_text);


        song_lyrics.setText(Html.fromHtml(NATIONAL_ANTHOM));
        song_lyrics.setTypeface(face);
        topbar_text.setSelected(true);
        topbar_text.setText(getString(R.string.national_anthem_title));
        mPlayer = MediaPlayer.create(NationalAnthemActivity.this, R.raw.national);
    }

    public void PlayAgain(View v) {
        if (mPlayer.isPlaying()) {

        } else {
            mPlayer.start();

        }

    }

    public void Pouse(View v) {
        mPlayer.pause();

    }

    @Override
    public void onDestroy() {
        mPlayer.stop();
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        // this.finish();
        // stopAudio();
        super.onResume();
    }

}
