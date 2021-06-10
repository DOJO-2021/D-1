package model;
import java.io.Serializable;

public class LoginBeans implements Serializable{
//idとpwのフィールドの生成
	private String id;
	private String pw;

	//引数のあるコンストラクタ
	public LoginBeans(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}

	//引数のないコンストラクタ
	public LoginBeans() {
		this.id = "";
		this.pw = "";

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
}
