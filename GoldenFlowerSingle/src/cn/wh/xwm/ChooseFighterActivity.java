package cn.wh.xwm;

import cn.wh.xwm.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

public class ChooseFighterActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choosefighter);
        ImageButton imageButton_caocao = (ImageButton)findViewById(R.id.ImageButton_caocao);
        ImageButton imageButton_daqiao = (ImageButton)findViewById(R.id.ImageButton_daqiao);
        ImageButton imageButton_simayi = (ImageButton)findViewById(R.id.ImageButton_simayi);
        ImageButton imageButton_zhangfei = (ImageButton)findViewById(R.id.ImageButton_zhangfei);
        ImageButton imageButton_zhaoyun = (ImageButton)findViewById(R.id.ImageButton_zhaoyun);
        ImageButton imageButton_zhugeliang = (ImageButton)findViewById(R.id.imageButton_zhugeliang);
        
        imageButton_zhangfei.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
	            intent.setClass(ChooseFighterActivity.this, FighterIntroActivity.class);
	            startActivity(intent);
			}
		});
        imageButton_caocao.setOnClickListener(new OnClickListener() {
        	@Override
        	public void onClick(View v) {
        		Intent intent = new Intent();
        		intent.setClass(ChooseFighterActivity.this, FighterIntroActivity.class);
        		startActivity(intent);
        	}
        });
        imageButton_daqiao.setOnClickListener(new OnClickListener() {
        	@Override
        	public void onClick(View v) {
        		Intent intent = new Intent();
        		intent.setClass(ChooseFighterActivity.this, FighterIntroActivity.class);
        		startActivity(intent);
        	}
        });
        imageButton_simayi.setOnClickListener(new OnClickListener() {
        	@Override
        	public void onClick(View v) {
        		Intent intent = new Intent();
        		intent.setClass(ChooseFighterActivity.this, FighterIntroActivity.class);
        		startActivity(intent);
        	}
        });
        imageButton_zhaoyun.setOnClickListener(new OnClickListener() {
        	@Override
        	public void onClick(View v) {
        		Intent intent = new Intent();
        		intent.setClass(ChooseFighterActivity.this, FighterIntroActivity.class);
        		startActivity(intent);
        	}
        });
        imageButton_zhugeliang.setOnClickListener(new OnClickListener() {
        	@Override
        	public void onClick(View v) {
        		Intent intent = new Intent();
        		intent.setClass(ChooseFighterActivity.this, FighterIntroActivity.class);
        		startActivity(intent);
        	}
        });
    }

}