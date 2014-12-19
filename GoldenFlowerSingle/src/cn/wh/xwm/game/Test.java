package cn.wh.xwm.game;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Random;

import org.xmlpull.v1.XmlSerializer;

import cn.wh.xwm.game.Card;
import cn.wh.xwm.game.CardCompare;
import cn.wh.xwm.game.Hand;
import cn.wh.xwm.game.Rule;

import android.util.Log;
import android.util.Xml;


public class Test {
	public static void main(String[] args) throws Exception {
		Card a = new Card();
		a.setNumber(12);
		a.setFlower(1);
		Card b = new Card();
		b.setNumber(12);
		b.setFlower(2);
		Card c = new Card();
		c.setNumber(12);
		c.setFlower(31);
		ArrayList<Card> list = new ArrayList<Card>();
		list.add(a);
		list.add(b);
		list.add(c);
		Rule.sortCards(list);
		Hand h = new Hand(list);
//		for(Card card : h.getHand()){
//			System.out.println(card.getNumber());
//		}
//		System.out.println(h.getHandKind());
		
		Rule r = new Rule();
		r.refreshPoker();
		for(Card card : r.getPoker()){
			System.out.print(card.getNumber()+"@"+card.getFlower());
			System.out.println();
		}
		int n = 6;
		ArrayList<Card> temp =null;
		for(int j=0;j<n;j++){
			temp = new ArrayList<Card>(3);
			for(int i=0;i<3;i++){
				temp.add(r.getPoker().get(i+j*3));
			}
			Hand h1 = new Hand(temp);
			System.out.println(changeName((j+1))+"家的牌是:"+h1.toString());
		}
	}

	private static String changeName(int i) {
		switch (i) {
		case 1:
			return  "吴哲";
		case 2:
			return "撇撇";
		case 3:
			return "猴子";
		case 4:
			return "田勇";
		case 5:
			return "澎湃";
		case 6:
			return "星星";
		}
		return null;
	}

}
