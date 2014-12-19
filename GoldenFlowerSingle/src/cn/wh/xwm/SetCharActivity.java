package cn.wh.xwm;

import cn.wh.xwm.R;
import cn.wh.xwm.entity.UserEntity;
import cn.wh.xwm.util.Constants;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class SetCharActivity extends Activity {
	/** Called when the activity is first created. */
	private UserEntity userEntity = new UserEntity();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setchar);
		
		final EditText editText = (EditText)findViewById(R.id.editText1);
		
		ImageView image_mana = (ImageView)findViewById(R.id.imageView_mana);
		ImageView image_manb = (ImageView)findViewById(R.id.imageView_manb);
		ImageView image_womana = (ImageView)findViewById(R.id.imageView_womana);
		ImageView image_womanb = (ImageView)findViewById(R.id.imageView_womanb);
		final ImageView image_user = (ImageView)findViewById(R.id.imageView_user);
		
		
		image_mana.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				userEntity.setUserFace("mana");
				image_user.setImageResource(R.drawable.mana);
			}
		});
		image_manb.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				userEntity.setUserFace("manb");
				image_user.setImageResource(R.drawable.manb);
			}
		});
		image_womana.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				userEntity.setUserFace("womana");
				image_user.setImageResource(R.drawable.womana);
			}
		});
		image_womanb.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				userEntity.setUserFace("womanb");
				image_user.setImageResource(R.drawable.womanb);
			}
		});
		
		
		Button button_startgame = (Button) findViewById(R.id.startgame);
		button_startgame.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				userEntity.setUserName(editText.getText().toString());
				if(userEntity.getUserName()==null){
					userEntity.setUserName("明");
				}
				if(userEntity.getUserFace()==null){
					userEntity.setUserFace("mana");
				}
				Log.i("test","username: "+userEntity.getUserName());
				Log.i("test","userface:  "+userEntity.getUserFace());
				Intent intent = new Intent();
				intent.setClass(SetCharActivity.this, ChooseFighterActivity.class);
				Bundle bundle = new Bundle();
				bundle.putSerializable(Constants.KEY_USER, userEntity);
				startActivity(intent);
			}
		});
	}

}