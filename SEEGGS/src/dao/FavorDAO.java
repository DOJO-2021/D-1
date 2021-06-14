package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.FavorBeans;
public class FavorDAO {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<FavorBeans> select(FavorBeans param) {                     //「-」は【メソッド】をたたんで広げている。
		Connection conn = null;
		List<FavorBeans> cardList = new ArrayList<FavorBeans>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-1/SEEGGS", "sa", "");

			// SQL文を準備する　あいまい検索　会社名　氏名　住所
			String sql = "select ";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる　前後にあいまい検索
			if (param.getCompany() != null) {
				pStmt.setString(1, "%" + param.getCompany() + "%"); //番号はSQL文のWhere句の？順番通りWHERE １NUMBER LIKE ? AND ２NAME LIKE ? AND ３ADDRESS LIKE ?
			}
			else {
				pStmt.setString(1, "%");
			}
			if (param.getName() != null) {
				pStmt.setString(2, "%" + param.getName() + "%");
			}
			else {
				pStmt.setString(2, "%");
			}
			if (param.getAddress() != null) {
				pStmt.setString(3, "%" + param.getAddress() + "%");
			}
			else {
				pStmt.setString(3, "%");
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				favorite card = new favorite(
				rs.getInt("u_number"),

				);
				cardList.add(card);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			cardList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			cardList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					cardList = null;
				}
			}
		}

		// 結果を返す
		return cardList;
	}


}
