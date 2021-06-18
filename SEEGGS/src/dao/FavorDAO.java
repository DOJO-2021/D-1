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
//プッシュ
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<FavorBeans> select(FavorBeans param) {                     //「-」は【メソッド】をたたんで広げている。
		Connection conn = null;
		List<FavorBeans> FavorList = new ArrayList<FavorBeans>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-1/SEEGGS", "sa", "");

			// SQL文を準備する　ログインIDと投稿管理番号による検索
			String sql = "select * from Favorite where Id like ? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる　前後にあいまい検索
			if (param.getId() != null) {
				pStmt.setString(1, "%" + param.getId() + "%");
				}
			else {
				pStmt.setString(1, "%");
			}




			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				FavorBeans Fcard = new FavorBeans(
				rs.getString("id"),
				rs.getInt("m_number"),
				rs.getString("contents")

				);
				FavorList.add(Fcard);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			FavorList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			FavorList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					FavorList = null;
				}
			}
		}

		// 結果を返す
		return FavorList;
	}

	public boolean insert(FavorBeans Fcard) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-1/SEEGGS", "sa", "");

			// SQL文を準備する
			String sql = "insert into Favorite values (?, ? , ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			if (Fcard.getId() != null) {
				pStmt.setString(1, Fcard.getId());
			}
			else {
				pStmt.setString(1, "null");
			}
			if (Fcard.getM_number() != 0) {
				pStmt.setInt(2, Fcard.getM_number());
			}
			else {
				pStmt.setString(2, "null");
			}
			if (Fcard.getContents() != null) {
				pStmt.setString(3, Fcard.getContents());
			}
			else {
				pStmt.setString(3, "null");
			}

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;
	}


	// 引数numberで指定されたレコードを削除し、成功したらtrueを返す
			public boolean delete(String Id) {
				Connection conn = null;
				boolean result = false;

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-1/SEEGGS", "sa", "");

					// SQL文を準備する
					String sql = "delete from Favorite where Id=?";
					PreparedStatement pStmt = conn.prepareStatement(sql);

					// SQL文を完成させる
					pStmt.setString(1, Id);

					// SQL文を実行する
					if (pStmt.executeUpdate() == 1) {
						result = true;
					}
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
				catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				finally {
					// データベースを切断
					if (conn != null) {
						try {
							conn.close();
						}
						catch (SQLException e) {
							e.printStackTrace();
						}
					}
				}

				// 結果を返す
				return result;
			}
}
