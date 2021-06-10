package model;//変更済(全体)
import java.io.Serializable;

public class ResultBeans {
		private int number;
		private String name;
		private String company;
		private String nickname;
		private String birthplace;
		private String thisisme;
		private String hobby;
		private String future;
		private String word;

		//引数があるコンストラクタ
		public Personal(int number, String name, String company,
				String nickname, String birthplace, String thisisme,
				String hobby, String future, String word) {

			super();
			this.number = number;
			this.name = name;
			this.company = company;
			this.nickname = nickname;
			this.birthplace = birthplace;
			this.thisisme = thisisme;
			this.hobby = hobby;
			this.future = future;
			this.word = word;

		}

		//引数がないコンストラクタ
		public Personal() {
			super();
			this.number = 0;
			this.name = "";
			this.company = "";
			this.nickname = "";
			this.birthplace = "";
			this.thisisme = "";
			this.hobby = "";
			this.future = "";
			this.word = "";
		}

		public int getNumber() {
			return number;
		}

		public void setNumber(int number) {
			this.number = number;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getCompany() {
			return company;
		}

		public void setCompany(String company) {
			this.company = company;
		}

		public String getNickname() {
			return nickname;
		}

		public void setNickname(String nickname) {
			this.nickname = nickname;
		}

		public String getBirthplace() {
			return birthplace;
		}

		public void setBirthplace(String birthplace) {
			this.birthplace = birthplace;
		}

		public String getThisisme() {
			return thisisme;
		}

		public void setThisisme(String thisisme) {
			this.thisisme = thisisme;
		}

		public String getHobby() {
			return hobby;
		}

		public void setHobby(String hobby) {
			this.hobby = hobby;
		}

		public String getFuture() {
			return future;
		}

		public void setFuture(String future) {
			this.future = future;
		}

		public String getWord() {
			return word;
		}

		public void setWord(String word) {
			this.word = word;
		}
}
