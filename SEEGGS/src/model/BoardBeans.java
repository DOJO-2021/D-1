package model;
import java.io.Serializable;

public class BoardBeans implements Serializable {
private int m_number;
private int type;
private String contents;

//引数のあるコンストラクタ
public BoardBeans(int m_number, int type, String contents) {
	super();
	this.m_number = m_number;
	this.type = type;
	this.contents = contents;
}

//引数のないコンストラクタ
public BoardBeans() {
	super();
	this.m_number= 0;
	this.type=0;
	this.contents = "";


}

public int getM_number() {
	return m_number;
}

public void setM_number(int m_number) {
	this.m_number = m_number;
}

public int getType() {
	return type;
}

public void setType(int type) {
	this.type = type;
}

public String getContents() {
	return contents;
}

public void setContents(String contents) {
	this.contents = contents;
}



}
