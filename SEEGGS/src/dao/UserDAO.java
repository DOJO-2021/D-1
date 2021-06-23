package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.UserBeans;

//変更有
public class UserDAO {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<UserBeans> select(UserBeans param) {
		Connection conn = null;
		List<UserBeans> UserList = new ArrayList<UserBeans>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-1/SEEGGS", "sa", "");

			// SQL文を準備する(変更有・？)
			String sql = "select * from User order by id DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる(変更有)
//			if (param.getId() != null) {
//				pStmt.setString(1, "%" + param.getId() + "%");
//			}
//			else {
//				pStmt.setString(1, "%");
//			}
//			if (param.getName() != null) {
//				pStmt.setString(2, "%" + param.getName() + "%");
//			}
//			else {
//				pStmt.setString(2, "%");
//			}
//			if (param.getCompany() != null) {
//				pStmt.setString(3, "%" + param.getCompany() + "%");
//			}
//			else {
//				pStmt.setString(3, "%");
//			}
//			if (param.getNickname() != null) {
//				pStmt.setString(4, "%" + param.getNickname() + "%");
//			}
//			else {
//				pStmt.setString(4, "%");
//			}


			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする (変更有)
			while (rs.next()) {
				UserBeans Ucard = new UserBeans(
				rs.getString("id"),
				rs.getString("password"),
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
				UserList.add(Ucard);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			UserList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			UserList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					UserList = null;
				}
			}
		}

		// 結果を返す
		return UserList;
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
				String sql = "insert into User values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (ucard.getId() != null) {
					pStmt.setString(1, ucard.getId());
				}
				else {
					pStmt.setString(1, "null");
				}
				if (ucard.getPassword() != null) {
					pStmt.setString(2, ucard.getPassword());
				}
				else {
					pStmt.setString(2, "null");
				}
				if (ucard.getPhoto() != null) {
					pStmt.setString(3, ucard.getPhoto());
				}
				else {
					pStmt.setString(3, "null");
				}
				if (ucard.getName() != null) {
					pStmt.setString(4, ucard.getName());
				}
				else {
					pStmt.setString(4, "null");
				}
				if (ucard.getCompany() != null) {
					pStmt.setString(5, ucard.getCompany());
				}
				else {
					pStmt.setString(5, "null");
				}
				if (ucard.getNickname() != null) {
					pStmt.setString(6, ucard.getNickname());
				}
				else {
					pStmt.setString(6, "null");
				}
				if (ucard.getBirthplace() != null) {
					pStmt.setString(7, ucard.getBirthplace());
				}
				else {
					pStmt.setString(7, "null");
				}
				if (ucard.getThisisme() != null) {
					pStmt.setString(8, ucard.getThisisme());
				}
				else {
					pStmt.setString(8, "null");
				}
				if (ucard.getHobby() != null) {
					pStmt.setString(9, ucard.getHobby());
				}
				else {
					pStmt.setString(9, "null");
				}
				if (ucard.getFuture() != null) {
					pStmt.setString(10, ucard.getFuture());
				}
				else {
					pStmt.setString(10, "null");
				}
				if (ucard.getWord() != null) {
					pStmt.setString(11, ucard.getWord());
				}
				else {
					pStmt.setString(11, "null");
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

		// homeServlet用　1件のみ取ってくる処理
		public List<UserBeans> select1(UserBeans param) {
			Connection conn = null;
			List<UserBeans> UserList = new ArrayList<UserBeans>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-1/SEEGGS", "sa", "");

				// SQL文を準備する(変更有・？)
				String sql = "select * from User where Id like  ? and Name like ? and Company like ? and Nickname like ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる(変更有)
				if (param.getId() != null) {
					pStmt.setString(1, "%" + param.getId() + "%");
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
					UserBeans Ucard = new UserBeans(
					rs.getString("id"),
					rs.getString("password"),
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
					UserList.add(Ucard);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				UserList = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				UserList = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						UserList = null;
					}
				}
			}

			// 結果を返す
			return UserList;
		}

		// 引数cardで指定されたレコードを更新し、成功したらtrueを返す
		public boolean update(UserBeans Ucard) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-1/SEEGGS", "sa", "");

				// SQL文を準備する
				String sql = "update User set Photo =?, Name = ?, Company = ?, Nickname = ?, Birthplace = ?, Thisisme = ?, Hobby = ?, Future = ?, Word = ? where Id = ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (Ucard.getPhoto() != null) {
					pStmt.setString(1, Ucard.getPhoto());
				}
				else {
					pStmt.setString(1, "null");
				}
				if (Ucard.getName() != null) {
					pStmt.setString(2,Ucard.getName());
				}
				else {
					pStmt.setString(2, "null");
				}
				if (Ucard.getCompany() != null) {
					pStmt.setString(3, Ucard.getCompany());
				}
				else {
					pStmt.setString(3, "null");
				}
				if (Ucard.getNickname() != null) {
					pStmt.setString(4, Ucard.getNickname());
				}
				else {
					pStmt.setString(4, "null");
				}
				if (Ucard.getBirthplace() != null) {
					pStmt.setString(5, Ucard.getBirthplace());
				}
				else {
					pStmt.setString(5, "null");
				}
				if (Ucard.getThisisme() != null) {
					pStmt.setString(6, Ucard.getThisisme());
				}
				else {
					pStmt.setString(6, "null");
				}
				if (Ucard.getHobby() != null) {
					pStmt.setString(7, Ucard.getHobby());
				}
				else {
					pStmt.setString(7, "null");
				}
				if (Ucard.getFuture() != null) {
					pStmt.setString(8, Ucard.getFuture());
				}
				else {
					pStmt.setString(8, "null");
				}
				if (Ucard.getWord() != null) {
					pStmt.setString(9, Ucard.getWord());
				}
				else {
					pStmt.setString(9, "null");
				}
				pStmt.setString(10, Ucard.getId());

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