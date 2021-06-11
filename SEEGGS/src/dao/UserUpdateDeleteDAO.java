package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.UserBeans;

public class UserUpdateDeleteDAO {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<UserBeans> select(UserBeans param) {
		Connection conn = null;
		List<UserBeans> userList = new ArrayList<UserBeans>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-1/SEEGGS", "sa", "");

			// SQL文を準備する(変更有・？)
			String sql = "select * from PERSONAL where U_number like ? and Name like ? and Company like ? and Nickname like ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる(変更有)
			if (param.getU_number() != 0) {
				pStmt.setString(1, "%" + param.getU_number() + "%");
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
			if (param.getCompany() != null) {
				pStmt.setString(3, "%" + param.getCompany() + "%");
			}
			else {
				pStmt.setString(3, "%");
			}
			if (param.getNickname() != null) {
				pStmt.setString(4, "%" + param.getNickname() + "%");
			}
			else {
				pStmt.setString(4, "%");
			}


			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする (変更有)
			while (rs.next()) {
				UserBeans ucard = new UserBeans(
				rs.getInt("u_number"),
				rs.getString("photo"),
				rs.getString("name"),
				rs.getString("company"),
				rs.getString("nickname"),
				rs.getString("birthplace"),
				rs.getString("thisisme"),
				rs.getString("hobby"),
				rs.getString("future"),
				rs.getString("word")
				);
				userList.add(ucard);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			userList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			userList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					userList = null;
				}
			}
		}

		// 結果を返す
		return userList;
	}

	// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
		public boolean insert(UserBeans ucard) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-1/SEEGGS", "sa", "");

				// SQL文を準備する
				String sql = "insert into Personal values (null, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (ucard.getPhoto() != null) {
					pStmt.setString(1, ucard.getPhoto());
				}
				else {
					pStmt.setString(1, "null");
				}
				if (ucard.getName() != null) {
					pStmt.setString(2, ucard.getName());
				}
				else {
					pStmt.setString(2, "null");
				}
				if (ucard.getCompany() != null) {
					pStmt.setString(3, ucard.getCompany());
				}
				else {
					pStmt.setString(3, "null");
				}
				if (ucard.getNickname() != null) {
					pStmt.setString(4, ucard.getNickname());
				}
				else {
					pStmt.setString(4, "null");
				}
				if (ucard.getBirthplace() != null) {
					pStmt.setString(5, ucard.getBirthplace());
				}
				else {
					pStmt.setString(5, "null");
				}
				if (ucard.getThisisme() != null) {
					pStmt.setString(6, ucard.getThisisme());
				}
				else {
					pStmt.setString(6, "null");
				}
				if (ucard.getHobby() != null) {
					pStmt.setString(7, ucard.getHobby());
				}
				else {
					pStmt.setString(7, "null");
				}
				if (ucard.getFuture() != null) {
					pStmt.setString(8, ucard.getFuture());
				}
				else {
					pStmt.setString(8, "null");
				}
				if (ucard.getWord() != null) {
					pStmt.setString(9, ucard.getWord());
				}
				else {
					pStmt.setString(9, "null");
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

		// 引数cardで指定されたレコードを更新し、成功したらtrueを返す
		public boolean update(UserBeans ucard) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-1/SEEGGS", "sa", "");

				// SQL文を準備する
				String sql = "update Personal set Photo =?, Name = ?, Company = ?, Nickname = ?, Birthplace = ?, Thisisme = ?, Hobby = ?, Future = ?, Word = ? where U_number = ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (ucard.getPhoto() != null) {
					pStmt.setString(1, ucard.getPhoto());
				}
				else {
					pStmt.setString(1, "null");
				}
				if (ucard.getName() != null) {
					pStmt.setString(2,ucard.getName());
				}
				else {
					pStmt.setString(2, "null");
				}
				if (ucard.getCompany() != null) {
					pStmt.setString(3, ucard.getCompany());
				}
				else {
					pStmt.setString(3, "null");
				}
				if (ucard.getNickname() != null) {
					pStmt.setString(4, ucard.getNickname());
				}
				else {
					pStmt.setString(4, "null");
				}
				if (ucard.getBirthplace() != null) {
					pStmt.setString(5, ucard.getBirthplace());
				}
				else {
					pStmt.setString(5, "null");
				}
				if (ucard.getThisisme() != null) {
					pStmt.setString(6, ucard.getThisisme());
				}
				else {
					pStmt.setString(6, "null");
				}
				if (ucard.getHobby() != null) {
					pStmt.setString(7, ucard.getHobby());
				}
				else {
					pStmt.setString(7, "null");
				}
				if (ucard.getFuture() != null) {
					pStmt.setString(8, ucard.getFuture());
				}
				else {
					pStmt.setString(8, "null");
				}
				if (ucard.getWord() != null) {
					pStmt.setString(9, ucard.getWord());
				}
				else {
					pStmt.setString(9, "null");
				}
				pStmt.setInt(10, ucard.getU_number());

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
		public boolean delete(int U_number) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-1/SEEGGS", "sa", "");

				// SQL文を準備する
				String sql = "delete from Personal where u_number=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				pStmt.setInt(1, U_number);

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