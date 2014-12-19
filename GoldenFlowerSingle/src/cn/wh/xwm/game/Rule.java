package cn.wh.xwm.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Rule {
	
	public ArrayList<Card> poker = new ArrayList<Card>(52);
	
	public static int HANDKIND_LEOPARD = 0; // 豹子
	public static int HANDKIND_SEQUENCE_GOLDENFLOWER = 1; // 顺金
	public static int HANDKIND_GOLDENFLOWER = 2; // 金花
	public static int HANDKIND_SEQUENCE = 3; // 顺子
	public static int HANDKIND_DOUBLE = 4; // 对子
	public static int HANDKIND_SINGLE = 5; // 单张
	public static int HANDKIND_235 = 6; // 235

	public Rule(){
		Card card = null;
		for(int i=2;i<15;i++){
			for(int j=1;j<5;j++){
				card = new Card();
				card.setNumber(i);
				card.setFlower(j);
				poker.add(card);
			}
		}
	}
	
	public void refreshPoker(){
		Random r = new Random(); 
		ArrayList<Card> temp = new ArrayList<Card>(52);
		for(int i=0;i<52;i++){
			int t = r.nextInt(52-i);
			temp.add(poker.get(t));
			poker.remove(t);
		}
		poker=temp;
	}
	
	/**
	 * 两副牌比大小
	 * @param hand1
	 * @param hand2
	 * @return
	 */
	public static boolean compare(Hand hand1, Hand hand2) {
		if(hand1.getHandKind()==0&&hand2.getHandKind()==6){
			return false;
		}else if(hand1.getHandKind()<hand2.getHandKind()){
			return true;
		}else if(hand1.getHandKind()==hand2.getHandKind()){
			return compareNumber(hand1,hand2);
		}else{
			return false;
		}
	}

	/**
	 * 牌型一样时候的比较
	 * @param hand1
	 * @param hand2
	 * @return
	 */
	private static boolean compareNumber(Hand hand1, Hand hand2) {
		switch (hand1.getHandKind()) {
		case 0:
			if(hand1.getHand().get(0).getNumber()>hand2.getHand().get(0).getNumber()){
				return true;
			}else{
				return false;
			}
		case 1:
			if(hand1.getHand().get(0).getNumber()>hand2.getHand().get(0).getNumber()){
				return true;
			}else if(hand1.getHand().get(0).getNumber()==14&&hand1.getHand().get(0).getNumber()==hand2.getHand().get(0).getNumber()){
				if(hand1.getHand().get(1).getNumber()>hand2.getHand().get(1).getNumber()){
					return true;
				}else{
					return false;
				}
			}else{
				return false;
			}
		case 2:
			if(hand1.getHand().get(0).getNumber()>hand2.getHand().get(0).getNumber()){
				return true;
			}else if(hand1.getHand().get(0).getNumber()==hand2.getHand().get(0).getNumber()){
				if(hand1.getHand().get(1).getNumber()>hand2.getHand().get(1).getNumber()){
					return true;
				}else if(hand1.getHand().get(1).getNumber()==hand2.getHand().get(1).getNumber()){
					if(hand1.getHand().get(2).getNumber()>hand2.getHand().get(2).getNumber()){
						return true;
					}else{
						return false;
					}
				}
			}else{
				return false;
			}
		case 3:
			if(hand1.getHand().get(0).getNumber()>hand2.getHand().get(0).getNumber()){
				return true;
			}else if(hand1.getHand().get(0).getNumber()==14&&hand1.getHand().get(0).getNumber()==hand2.getHand().get(0).getNumber()){
				if(hand1.getHand().get(1).getNumber()>hand2.getHand().get(1).getNumber()){
					return true;
				}else{
					return false;
				}
			}else{
				return false;
			}
		case 4://对子比较
			int p1 = getDoubleNumberFromHand(hand1);
			int p2 = getDoubleNumberFromHand(hand2);
			int s1 = getSingleNumberFromHand(hand1);
			int s2 = getSingleNumberFromHand(hand2);
			if(p1>p2){
				return true;
			}else if(p1==p2){
				if(s1>s2){
					return true;
				}else{
					return false;
				}
			}else{
				return false;
			}
		case 5:
			if(hand1.getHand().get(0).getNumber()>hand2.getHand().get(0).getNumber()){
				return true;
			}else{
				return false;
			}
		case 6:
			return false;
		default:
			break;
		}
		return false;
	}

	private static int getSingleNumberFromHand(Hand hand1) {
		Card c1 = hand1.getHand().get(0);
		Card c2 = hand1.getHand().get(1);
		Card c3 = hand1.getHand().get(2);
		return c1.getNumber()==c2.getNumber()?c3.getNumber():c1.getNumber();
	}

	private static int getDoubleNumberFromHand(Hand hand1) {
		Card c1 = hand1.getHand().get(0);
		Card c2 = hand1.getHand().get(1);
		Card c3 = hand1.getHand().get(2);
		return c1.getNumber()==c2.getNumber()?c1.getNumber():c3.getNumber();
	}

	/**
	 * 将发出的牌按大小排序
	 * @param cards
	 */
	public static void sortCards(ArrayList<Card> list) {
		CardCompare c = new CardCompare();
		Collections.sort(list, c);
	}

	public void analyse(Hand hand) {

	}

	public void deal() {

	}

	public ArrayList<Card> getPoker() {
		return poker;
	}

	public void setPoker(ArrayList<Card> poker) {
		this.poker = poker;
	}

}
