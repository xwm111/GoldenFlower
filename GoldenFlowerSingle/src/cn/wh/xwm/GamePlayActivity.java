package cn.wh.xwm;

import java.util.ArrayList;

import cn.wh.xwm.R;
import cn.wh.xwm.entity.UserEntity;
import cn.wh.xwm.game.Card;
import cn.wh.xwm.game.Hand;
import cn.wh.xwm.game.Rule;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class GamePlayActivity extends Activity {
	private UserEntity userEntity = new UserEntity();
	private UserEntity computerEntity = new UserEntity();
	private int userState = 2;// 1.已经看牌 2.未看牌
	private int computerrState = 2;//
	private int gameover=0;//0游戏未结束，1游戏已经结束
	
	private int betcash = 5;
	private int betcash2 = 10;
	private int totalMoney = 10;
	private int current=1;//当前倍数 1  /2

	private Hand userHand;
	private Hand computerHand;
	
	private ImageView userImageView1;
	private ImageView userImageView2;
	private ImageView userImageView3;
	
	private ImageView computerImageView1;
	private ImageView computerImageView2;
	private ImageView computerImageView3;
	
	private TextView totalMoneyView;
	private TextView zhangfeiMoney;;
	private TextView userMoney;;

	/** Called when the activity is first created. */

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gameplay);
		userEntity.setUserName("明");
		userEntity.setCash(9995);
		computerEntity.setUserName("computer");
		computerEntity.setCash(9995);
		Button button_seecard = (Button) findViewById(R.id.button_seecard);// 看牌按钮
		Button button_opencard = (Button) findViewById(R.id.button_opencard);//开牌按钮
		Button button_bethalf = (Button) findViewById(R.id.button_bethalf);//闷半手按钮
		Button button_betall = (Button) findViewById(R.id.button_betall);//闷一手按钮
		Button button_follow = (Button) findViewById(R.id.button_follow);//跟牌按钮
		Button button_giveup = (Button) findViewById(R.id.button_giveup);//放弃按钮
		Button button_newgame = (Button) findViewById(R.id.button_newgame);//放弃按钮
		
		userImageView1 = (ImageView)findViewById(R.id.imageView_user1);
		userImageView2 = (ImageView)findViewById(R.id.imageView_user2);
		userImageView3 = (ImageView)findViewById(R.id.imageView_user3);
		computerImageView1 = (ImageView)findViewById(R.id.imageView_computer1);
		computerImageView2 = (ImageView)findViewById(R.id.imageView_computer2);
		computerImageView3 = (ImageView)findViewById(R.id.imageView_computer3);
		
		totalMoneyView = (TextView)findViewById(R.id.totalMoney);
		zhangfeiMoney = (TextView)findViewById(R.id.zhangfeimoney);
		userMoney = (TextView)findViewById(R.id.usermoney);
		
		button_seecard.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				userState=1;//用户状态该为已看牌
				if(gameover==1){
					Toast.makeText(getApplicationContext(), "游戏已经结束,请点击再来一局！", Toast.LENGTH_LONG).show();
					return;
				}
//				Log.i("asd", "显示玩家图片:"+userHand.getHand().get(0).getPicsrc()+"  "+getPackageName());
				int imgid = getResources().getIdentifier(userHand.getHand().get(0).getPicsrc(), "drawable", getPackageName()); 
//				Log.i("asd", "imgid:"+imgid);
				userImageView1.setImageResource(imgid);
//				userImageView1.setBackgroundResource(imgid);
				imgid = getResources().getIdentifier(userHand.getHand().get(1).getPicsrc(), "drawable", "cn.wh.xwm"); 
				userImageView2.setImageResource(imgid);
				imgid = getResources().getIdentifier(userHand.getHand().get(2).getPicsrc(), "drawable", "cn.wh.xwm"); 
				userImageView3.setImageResource(imgid);
			}
		});
		
		button_opencard.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(gameover==1){
					Toast.makeText(getApplicationContext(), "游戏已经结束,请点击再来一局！", Toast.LENGTH_LONG).show();
					return;
				}
				int imgid = getResources().getIdentifier(userHand.getHand().get(0).getPicsrc(), "drawable", getPackageName()); 
				userImageView1.setImageResource(imgid);
				imgid = getResources().getIdentifier(userHand.getHand().get(1).getPicsrc(), "drawable", getPackageName()); 
				userImageView2.setImageResource(imgid);
				imgid = getResources().getIdentifier(userHand.getHand().get(2).getPicsrc(), "drawable", getPackageName()); 
				userImageView3.setImageResource(imgid);
				
				imgid = getResources().getIdentifier(computerHand.getHand().get(0).getPicsrc(), "drawable", getPackageName()); 
				computerImageView1.setImageResource(imgid);
				imgid = getResources().getIdentifier(computerHand.getHand().get(1).getPicsrc(), "drawable", getPackageName()); 
				computerImageView2.setImageResource(imgid);
				imgid = getResources().getIdentifier(computerHand.getHand().get(2).getPicsrc(), "drawable", getPackageName()); 
				computerImageView3.setImageResource(imgid);
				boolean winstate = Rule.compare(userHand, computerHand);
				calculateGame(winstate);
			}
		});
		
		
		button_bethalf.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(gameover==1){
					Toast.makeText(getApplicationContext(), "游戏已经结束,请点击再来一局！", Toast.LENGTH_LONG).show();
					return;
				}
				if(userState==1){
					Toast.makeText(getApplicationContext(), "你已经看过牌只能跟牌或者放弃！", Toast.LENGTH_LONG).show();
					return;
				}
				if(current==2){
					Toast.makeText(getApplicationContext(), "已经闷过一手，至少闷一手！", Toast.LENGTH_LONG).show();
					return;
				}
				userBet(betcash);
				computerBet(betcash);
			}
		});
		
		button_betall.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(gameover==1){
					Toast.makeText(getApplicationContext(), "游戏已经结束,请点击再来一局！", Toast.LENGTH_LONG).show();
					return;
				}
				if(userState==1){
					Toast.makeText(getApplicationContext(), "你已经看过牌只能跟牌或者放弃！", Toast.LENGTH_LONG).show();
					return;
				}
				current=2;
				userBet(betcash2);
				computerBet(betcash2);
			}
		});
		
		
		button_follow.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(userState==2){
					Toast.makeText(getApplicationContext(), "你还未看牌不能跟牌！", Toast.LENGTH_LONG).show();
					return;
				}
				if(gameover==1){
					Toast.makeText(getApplicationContext(), "游戏已经结束,请点击再来一局！", Toast.LENGTH_LONG).show();
					return;
				}
				if(current==1){
					userBet(betcash2);
					computerBet(betcash);
				}else{
					userBet(betcash2*2);
					computerBet(betcash2);
				}
			}
		});
		
		button_giveup.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(gameover==1){
					Toast.makeText(getApplicationContext(), "游戏已经结束,请点击再来一局！", Toast.LENGTH_LONG).show();
					return;
				}
				calculateGame(false);
			}
		});
		
		button_newgame.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(gameover==0){
					Toast.makeText(getApplicationContext(), "本局游戏还未结束！", Toast.LENGTH_LONG).show();
					return;
				}else{
					nextGame();
				}
			}
		});
		
		
		newRound();
	}

	private void newRound() {
		Rule r = new Rule();
		r.refreshPoker();
		ArrayList<Card> temp_user = new ArrayList<Card>(3);
		ArrayList<Card> temp_computer = new ArrayList<Card>(3);
		for (int i = 0; i < 3; i++) {
			temp_user.add(r.getPoker().get(i * 2));
			temp_computer.add(r.getPoker().get(i * 2 + 1));
		}
		userHand = new Hand(temp_user);
		computerHand = new Hand(temp_computer);
//		for (int i = 0; i < 3; i++) {
//			Log.i("test", "user的牌是" + userHand.getHand().get(i).getFlower()
//					+ ":" + userHand.getHand().get(i).getNumber());
//			Log.i("test", "computer的牌是"
//					+ computerHand.getHand().get(i).getFlower() + ":"
//					+ computerHand.getHand().get(i).getNumber());
//		}
	}
	
	public  void computerBet(int m){
		computerEntity.setCash(computerEntity.getCash()-m);
		totalMoney+=m;
		changeTotalMoneyView(totalMoney);
		zhangfeiMoney.setText(String.valueOf(computerEntity.getCash()-m));
	}
	
	public  void userBet(int m){
		userEntity.setCash(userEntity.getCash()-m);
		totalMoney+=m;
		changeTotalMoneyView(totalMoney);
		userMoney.setText(String.valueOf(userEntity.getCash()-m));
	}

	private void changeTotalMoneyView(int totalMoney2) {
		totalMoneyView.setText(String.valueOf(totalMoney2));
		
	}
	
	private void nextGame(){
		newRound();
		userImageView1.setImageResource(R.drawable.pukerback);
		userImageView2.setImageResource(R.drawable.pukerback);
		userImageView3.setImageResource(R.drawable.pukerback);
		computerImageView1.setImageResource(R.drawable.pukerback);
		computerImageView2.setImageResource(R.drawable.pukerback);
		computerImageView3.setImageResource(R.drawable.pukerback);
		betcash=5;
		current=1;
		totalMoney=10;
		userState=2;
		gameover=0;
		changeTotalMoneyView(totalMoney);
		userEntity.setCash(userEntity.getCash()-5);
		computerEntity.setCash(computerEntity.getCash()-5);
		zhangfeiMoney.setText(String.valueOf(computerEntity.getCash()));
		userMoney.setText(String.valueOf(userEntity.getCash()));
	}
	
	/**
	 * winstate true=玩家赢 false=电脑赢
	 * @param winstate
	 */
	private void calculateGame(boolean winstate){
		gameover=1;
		if(winstate==true){
			Toast.makeText(getApplicationContext(), "恭喜你赢了！", Toast.LENGTH_LONG).show();
			userEntity.setCash(userEntity.getCash()+totalMoney);
			
		}else{
			Toast.makeText(getApplicationContext(), "很遗憾你输了！", Toast.LENGTH_LONG).show();
			computerEntity.setCash(computerEntity.getCash()+totalMoney);
		}
			zhangfeiMoney.setText(String.valueOf(computerEntity.getCash()));
			userMoney.setText(String.valueOf(userEntity.getCash()));
	}
	
}