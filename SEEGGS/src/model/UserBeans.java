package model;
import java.io.Serializable;

public class UserBeans implements Serializable {
	private int u_number ;
	private String photo;
	private String name;
	private String company;
	private String nickname;
	private String birthplace;
	private String thisisme;
	private String hobby;
	private String future;
	private String word;

	//BCクラスの引数のあるコンストラクタ
	public UserBeans(int u_number, String photo, String name, String company, String nickname, String birthplace, String thisisme,
			String hobby, String future, String word) {
		super();
		this.u_number = u_number;
		this.photo = photo;
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
	public UserBeans() {
		super();
		this.u_number =0;
		this.photo = "";
		this.name = "";
		this.company = "";
		this.nickname = "";
		this.birthplace = "";
		this.thisisme = "";
		this.hobby = "";
		this.future = "";
		this.word = "";
	}

	public int getU_number() {
		return u_number;
	}
	public void setU_number(int u_number) {
		this.u_number = u_number;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
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