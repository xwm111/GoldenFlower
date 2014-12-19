package cn.wh.xwm;

import cn.wh.xwm.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class FighterIntroActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_zhangfei);
        
        Button gotogame = (Button)findViewById(R.id.button_gotogame);
        gotogame.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
	            intent.setClass(FighterIntroActivity.this, GamePlayActivity.class);
	            startActivity(intent);
			}
		});
    }

}