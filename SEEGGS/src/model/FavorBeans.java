package model;
import java.io.Serializable;

public class FavorBeans implements Serializable{
//フィールドの作成
private String id;
private int m_number;
private String contents;

//引数のあるコンストラクタ
public FavorBeans(String id, int m_number, String contents) {
	super();
	this.id= id;
	this.m_number= m_number;
	this.contents=contents;
}

//引数のないコンストラクタ
public FavorBeans() {
	super();
	this.id="";
	this.m_number=0;
	this.contents="";
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public int getM_number() {
	return m_number;
}

public void setM_number(int m_number) {
	this.m_number = m_number;
}

public String getContents() {
	return contents;
}

public void setContents(String contents) {
	this.contents = contents;
}

}
