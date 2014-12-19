package cn.wh.xwm.game;

public class Card {
		/**
		 * 牌大小 2-14 14为A
		 */
		private int number;
		/**
		 * 牌花色 1黑桃 2红心 3梅花 4方片 
		 */
		private int flower;
		
		public int getNumber() {
			return number;
		}
		public void setNumber(int number) {
			this.number = number;
		}
		public int getFlower() {
			return flower;
		}
		public void setFlower(int flower) {
			this.flower = flower;
		}
		@Override
		public String toString() {
			String f = "";
			switch (flower) {
			case 1:
				f="黑桃";
				break;
			case 2:
				f="红心";
				break;
			case 3:
				f="梅花";
				break;
			case 4:
				f="方片";
				break;
			default:
				break;
			}
			String temp = "";
			switch (number) {
			case 14:
				temp = "a";
				break;
			case 13:
				temp = "k";
				break;
			case 12:
				temp = "q";
				break;
			case 11:
				temp = "j";
				break;

			default:
				temp = String.valueOf(number);
				break;
			}
			
			return temp+"_"+f+"  ";
		}
		
		public String getPicsrc(){
			
			return "p_"+modifyNumber(number)+"_"+flower;
		}
		
		private String modifyNumber(int number2) {
			String temp = "";
			switch (number2) {
			case 14:
				temp = "a";
				break;
			case 13:
				temp = "k";
				break;
			case 12:
				temp = "q";
				break;
			case 11:
				temp = "j";
				break;

			default:
				temp = String.valueOf(number);
				break;
			}
			return temp;
		}
		
}
