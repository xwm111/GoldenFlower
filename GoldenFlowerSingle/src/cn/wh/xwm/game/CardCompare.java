package cn.wh.xwm.game;

import java.util.Comparator;

public class CardCompare implements Comparator<Card> {

	@Override
	public int compare(Card o1, Card o2) {
		if(o1.getNumber()<o2.getNumber()){
			return 1;
		}else if(o1.getNumber()>o2.getNumber()){
			return -1;
		}else{
			return 0;
		}
	}

}
