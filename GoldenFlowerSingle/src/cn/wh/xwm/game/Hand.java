package cn.wh.xwm.game;

import java.util.ArrayList;

public class Hand {
	/**
	 * 一手牌
	 */
	private ArrayList<Card> hand = new ArrayList<Card>(3);
	
	private int HandKind;
	
	public Hand(ArrayList<Card> cards){
		this.hand=cards;
		Rule.sortCards(hand);
		this.HandKind = analyseCards(cards);
	}

	/**
	 * 分析牌型
	 * @param cards
	 * @return
	 */
	private int analyseCards(ArrayList<Card> cards) {
		if(isLeopard(cards)){
			return Rule.HANDKIND_LEOPARD;
		}
		if(isSequenceGoldenFlower(cards)){
			return Rule.HANDKIND_SEQUENCE_GOLDENFLOWER;
		}
		if(isGoldenFlower(cards)){
			return Rule.HANDKIND_GOLDENFLOWER;
		}
		if(isSequence(cards)){
			return Rule.HANDKIND_SEQUENCE;
		}
		if(isDouble(cards)){
			return Rule.HANDKIND_DOUBLE;
		}
		if(is235(cards)){
			return Rule.HANDKIND_235;
		}
		return Rule.HANDKIND_SINGLE;
	}

	private boolean is235(ArrayList<Card> cards) {
		if(cards.get(0).getNumber()==5&&cards.get(1).getNumber()==3&&cards.get(2).getNumber()==2){
			return true;
		}else{
			return false;
		}
	}

	private boolean isDouble(ArrayList<Card> cards) {
		if(cards.get(0).getNumber()==cards.get(1).getNumber()){
			return true;
		}else if(cards.get(1).getNumber()==cards.get(2).getNumber()){
			return true;
		}else{
			return false;
		}
	}

	private boolean isGoldenFlower(ArrayList<Card> cards) {
		if(cards.get(0).getFlower()==cards.get(1).getFlower()&&cards.get(1).getFlower()==cards.get(2).getFlower()){
			return true;
		}else{
			return false;
		}
	}

	private boolean isSequenceGoldenFlower(ArrayList<Card> cards) {
		if(isGoldenFlower(cards)&&isSequence(cards)){
			return true;
		}else{
			return false;
		}
	}

	private boolean isLeopard(ArrayList<Card> cards) {
		if(cards.get(0).getNumber()==cards.get(2).getNumber()){
			return true;
		}else{
			return false;
		}
	}

	private boolean isSequence(ArrayList<Card> cards) {
		if((cards.get(0).getNumber()-1)==cards.get(1).getNumber()&&(cards.get(1).getNumber()-1)==cards.get(2).getNumber()){
			return true;
		}else if(cards.get(0).getNumber()==14&&cards.get(1).getNumber()==3&&cards.get(2).getNumber()==2){
			return true;
		}else{
			return false;
		}
	}

	public ArrayList<Card> getHand() {
		return hand;
	}

	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}

	public int getHandKind() {
		return HandKind;
	}

	public void setHandKind(int handKind) {
		HandKind = handKind;
	}

	@Override
	public String toString() {
		String tt="";
		switch (HandKind) {
		case 0:
			tt = "豹子";
			break;
		case 1:
			tt = "顺金";
			break;
		case 2:
			tt = "金花";
			break;
		case 3:
			tt = "顺子";
			break;
		case 4:
			tt = "对子";
			break;
		case 5:
			tt = "单张";
			break;
		case 6:
			tt = "235";
			break;

		default:
			break;
		}
		return hand.get(0).toString()+hand.get(1).toString()+hand.get(2).toString()+tt;
	}
	
	
}
