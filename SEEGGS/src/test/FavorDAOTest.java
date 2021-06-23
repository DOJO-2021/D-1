package test;

import java.util.List;

import dao.FavorDAO;
import model.FavorBeans;

public class FavorDAOTest {
	public static void main(String[] args) {
		FavorDAO dao = new FavorDAO();

	//select文のテスト
	System.out.println("-----------select---------");
	List<FavorBeans> FavorList = dao.select(new FavorBeans("ichirou", 0,""));
	for(FavorBeans Fcard: FavorList) {
		System.out.println(Fcard.getId());
		System.out.println(Fcard.getM_number());
		System.out.println(Fcard.getContents());
		System.out.println();
	}

	//insertのテスト
	System.out.println("---------insert--------");
		FavorBeans insRec = new FavorBeans("jirou", 20, "ニホンノスバラシサシリマシタ？");
		if(dao.insert(insRec)) {
			System.out.println("登録成功しました");
		}
		else
		{
			System.out.println("登録失敗しました");
		}

		//挿入したレコードIDを取得する
		String insId = dao.select(insRec).get(0).getId();

		// delete()のテスト
		System.out.println("---------- delete()のテスト ----------");
		if (dao.delete(insId)) {
		System.out.println("削除成功！");
		}
		else {
		System.out.println("削除失敗！");
		}
	}
}
