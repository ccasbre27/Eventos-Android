package com.nansoft.msp.activity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.nansoft.msp.R;
import com.nansoft.msp.model.Event;

public class DetailsEventActivity extends ActionBarActivity
{
    String ID_EVENTO;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_event);

        Intent intent = getIntent();
        Event objEvent = (Event) intent.getExtras().getSerializable("obj");

        TextView txtvName = (TextView) findViewById(R.id.txtvName);
        txtvName.setText(objEvent.getName());

        ImageView imgvPicture = (ImageView) findViewById(R.id.imgvPicture);
        Glide.with(this)
                .load(objEvent.getPictureURL().trim())
                .asBitmap()
                .fitCenter()
                .placeholder(R.drawable.load_picture)
                .error(R.drawable.fail_picture)
                .into(imgvPicture);

        TextView txtvDate = (TextView) findViewById(R.id.txtvDate);
        txtvDate.setText(objEvent.getDate());

        TextView txtvHour = (TextView) findViewById(R.id.txtvHour);
        txtvHour.setText(objEvent.getHour());

        TextView txtvPrice = (TextView) findViewById(R.id.txtvPrice);
        txtvPrice.setText(objEvent.getPrice());

        TextView txtvDescription = (TextView) findViewById(R.id.txtvDescription);
        txtvDescription.setText(objEvent.getDescription());


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_details_event, menu);
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
}
