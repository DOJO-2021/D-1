package test;

import java.util.List;

import dao.BoardUpdateDeleteDAO;
import model.BoardBeans;

public class BoardUpdatedeleteDAOTest {
	public static void main(String[] args) {
		BoardUpdateDeleteDAO dao = new dao.BoardUpdateDeleteDAO();

		//select文のtest
		System.out.println("----------select文テスト----------");
		List<BoardBeans> BoardList = dao.select(new BoardBeans("saburou", 1, 1, ""));
		for(BoardBeans Ccard : BoardList) {
			System.out.println(Ccard.getId());
			System.out.println(Ccard.getM_number());
			System.out.println(Ccard.getType());
			System.out.println(Ccard.getContents());
			System.out.println();
		}

		//insert()のテスト
		System.out.println("---------- insert()のテスト ----------");
		BoardBeans insRec = new BoardBeans("asaa", 0, 3,"にほんごooo");
		if (dao.insert(insRec)) {
			System.out.println("登録成功！");
		}
		else {
			System.out.println("登録失敗！");
		}

				//挿入したレコードIDを取得する
		int insM_number = 3; //dao.select(insRec).get(0).getM_number();

		// delete()のテスト
		System.out.println("---------- delete()のテスト ----------");
		if (dao.delete(insM_number)) {
		System.out.println("削除成功！");
		}
		else {
		System.out.println("削除失敗！");
		}
	}
}
