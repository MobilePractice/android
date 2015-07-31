package com.example.android.drinkapp;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;


public class StoreListActivity extends Activity {
    float scale = 1f;
    Matrix matrix = new Matrix();
    ImageView zoomImage;
    ScaleGestureDetector scaleGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_list);

//        ListView listView = (ListView)findViewById(R.id.storeList);
//        StoreListAdapter adapter = (StoreListAdapter)getIntent().getSerializableExtra("storeListAdapter");
//        listView.setAdapter(adapter);
//        listView.setDivider(new ColorDrawable(Color.LTGRAY));
//        listView.setDividerHeight(1);

//        zoomImage = (ImageView)findViewById(R.id.zoomImage);
        zoomImage = (ImageView)findViewById(R.id.zoomed_image);
        scaleGestureDetector = new ScaleGestureDetector(this,new ScaleGestureListener());
    }

    public boolean onTouchEvent(MotionEvent event){
        System.out.println("onTouchEvent() called");
        //scaleGestureDetector.onTouchEvent(event);
        onShowImageZoomOverlay();
        return true;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_store_list, menu);
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

    private class ScaleGestureListener extends ScaleGestureDetector.SimpleOnScaleGestureListener{

        public boolean onScale(ScaleGestureDetector detector){
            float scaleFactor = detector.getScaleFactor();
            System.out.println("onScale(): scaleFactor = " + scaleFactor);
            scale = scale * scaleFactor;
            System.out.println("onScale() scale = " + scale);
            scale = Math.max(0.1f, Math.min(scale, 5.0f));
            System.out.println("onScale() scale calc = " + scale);

            matrix.setScale(scale, scale);
            zoomImage.setImageMatrix(matrix);
            return true;
        }
    }

    public void onShowImageZoomOverlay(){
        System.out.println("onShowImageZoomOverlay()");
        final Dialog dialog = new Dialog(this);
        //dialog.setTitle("Hi");
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.image_zoom_layout);
        dialog.setCanceledOnTouchOutside(true);
        View overlayView = dialog.findViewById(R.id.image_zoom_view);
        zoomImage = (ImageView)dialog.findViewById(R.id.zoomed_image);
        overlayView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
