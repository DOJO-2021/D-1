package test;
import java.util.List;

import dao.UserUpdateDeleteDAO;
import model.UserBeans;
public class UserUpdateDeleteDAOTest {
	public static void main(String[] args) {
		UserUpdateDeleteDAO dao = new UserUpdateDeleteDAO();

		// select()のテスト
		System.out.println("---------- select()のテスト ----------");
		List<UserBeans> userList = dao.select(new UserBeans(1, "", "", "", "", "", "", "", "", ""));
		for (UserBeans card : userList) {
			System.out.println(card.getU_number());
			System.out.println(card.getPhoto());
			System.out.println(card.getName());
			System.out.println(card.getCompany());
			System.out.println(card.getNickname());
			System.out.println(card.getBirthplace());
			System.out.println(card.getThisisme());
			System.out.println(card.getHobby());
			System.out.println(card.getFuture());
			System.out.println(card.getWord());
			System.out.println();
			System.out.println();
		}

		// insert()のテスト
		System.out.println("---------- insert()のテスト ----------");
		UserBeans insRec = new UserBeans(0, "TEST", "TEST", "TEST","TEST", "TEST", "一", "TEST", "TEST", "TEST");
		if (dao.insert(insRec)) {
			System.out.println("登録成功！");
		}
		else {
			System.out.println("登録失敗！");
		}

		//挿入したレコードIDを取得する
		int insU_Number = dao.select(insRec).get(0).getU_number();
		// update()のテスト
		System.out.println("---------- update()のテスト ----------");
		UserBeans upRec = new UserBeans(insU_Number, "update.png", "更新太郎", "更新社", "コウシン君", "トランプタワー", "更", "更新", "全世界を更新するよ", "更新は任せてくれ");
		if (dao.update(upRec)) {
			System.out.println("更新成功！");
		}
		else {
			System.out.println("更新失敗！");
		}
		// delete()のテスト
		System.out.println("---------- delete()のテスト ----------");
		if (dao.delete(insU_Number)) {
		System.out.println("削除成功！");
		}
		else {
		System.out.println("削除失敗！");
		}
	}
}

