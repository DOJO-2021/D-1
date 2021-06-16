package test;
import java.util.List;

import dao.UserUpdateDeleteDAO;
import model.UserBeans;
public class UserUpdateDeleteDAOTest {
	public static void main(String[] args) {
		UserUpdateDeleteDAO dao = new UserUpdateDeleteDAO();

		// select()のテスト
		System.out.println("---------- select()のテスト ----------");
		List<UserBeans> userList = dao.select(new UserBeans("", "", "", "", "", "", "", "", "", "", ""));
		for (UserBeans card : userList) {
			System.out.println(card.getId());
			System.out.println(card.getPassword());
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
		UserBeans insRec = new UserBeans("tanzirou", "TEST", "TEST", "mr.chldren", "TEST","TEST", "TEST", "一", "TEST", "TEST", "TEST");
		if (dao.insert(insRec)) {
			System.out.println("登録成功！");
		}
		else {
			System.out.println("登録失敗！");
		}

		//挿入したレコードIDを取得する
		String insId = dao.select(insRec).get(0).getId();
		// update()のテスト
		System.out.println("---------- update()のテスト ----------");
		UserBeans upRec = new UserBeans(insId, "password", "update.png", "真更新太郎", "更新社", "コウシン君", "トランプタワー", "更", "更新", "全世界を更新するよ", "更新は任せてくれ");
		if (dao.update(upRec)) {
			System.out.println("更新成功！");
		}
		else {
			System.out.println("更新失敗！");
		}
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

