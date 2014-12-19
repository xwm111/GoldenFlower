package cn.wh.xwm;

import cn.wh.xwm.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class IndexActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index);
        Button button_save = (Button)findViewById(R.id.button_save);
        Button button_quit = (Button)findViewById(R.id.button_quit);
		Button button_new = (Button)findViewById(R.id.button_new);
		
        button_save.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
	            intent.setClass(IndexActivity.this, SaveActivity.class);
	            startActivity(intent);
			}
		});
        
        button_new.setOnClickListener(new OnClickListener() {
        	
        	@Override
        	public void onClick(View v) {
        		Intent intent = new Intent();
        		intent.setClass(IndexActivity.this, SetCharActivity.class);
        		startActivity(intent);
        	}
        });
        
        button_quit.setOnClickListener(new OnClickListener() {
        	
        	@Override
        	public void onClick(View v) {
        		android.os.Process.killProcess(android.os.Process.myPid());
        	}
        });
    }

}