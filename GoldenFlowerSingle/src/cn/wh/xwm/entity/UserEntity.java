package cn.wh.xwm.entity;

import java.io.Serializable;

public class UserEntity implements Serializable{
		private String userName;
		private String userFace;
		private int cash;
		public int getCash() {
			return cash;
		}
		public void setCash(int cash) {
			this.cash = cash;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getUserFace() {
			return userFace;
		}
		public void setUserFace(String userFace) {
			this.userFace = userFace;
		}
}
