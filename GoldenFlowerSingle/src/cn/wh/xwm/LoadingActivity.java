package cn.wh.xwm;

import cn.wh.xwm.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

public class LoadingActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading);
    }
    
    @Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
    	switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			Intent intent = new Intent();
            intent.setClass(LoadingActivity.this, IndexActivity.class);
            startActivity(intent);
            finish();
			break;

		default:
			break;
		}
    	
		return super.onTouchEvent(event);
	}
}