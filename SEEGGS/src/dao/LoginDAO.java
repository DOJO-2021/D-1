package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//ログインの判定
public class LoginDAO {
	public boolean isLoginOK(String id, String password) {
		Connection conn = null;
		boolean loginResult = false;

		try {
			//JDBCドライブを読み込む
			Class.forName("org.h2.Driver");

			//データベースへ接続
			//要修正
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-1/SEEGGS", "sa", "");

			//select文を準備する
			String sql = "select count(*) from USER where Id = ? and Password = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id);
			pStmt.setString(2, password);

			//SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			//ユーザidとパスワードが一致するユーザがいたかどうかチェックする
			rs.next();
			if (rs.getInt("count(*)") == 1) {
				loginResult = true;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			loginResult = false;
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
			loginResult = false;
		}
		finally {
			//データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					loginResult = false;
				}
			}
		}
		return loginResult;
	}
}
