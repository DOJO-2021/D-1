package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//変更有
public class UserDAO {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<personal> select(personal param) {
		Connection conn = null;
		List<personal> personalList = new ArrayList<personal>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-1/SEEGGS", "sa", "");

			// SQL文を準備する(変更有・？)
			String sql = "select number, name , company, nickname, birthplace, thisisme, hobby,"
					+ " future, word, from personal where number like ? and company like ? and nickname like? "
					+ "and birthplace like? and thisisme like? and hobby like? and future like? and word like?" ;
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる(変更有)
			if (param.getnumber() != null) {
				pStmt.setString(1, "%" + param.getNumber() + "%");
			}
			else {
				pStmt.setString(1, "%");
			}
			if (param.getname() != null) {
				pStmt.setString(2, "%" + param.getName() + "%");
			}
			else {
				pStmt.setString(2, "%");
			}
			if (param.getcompany() != null) {
				pStmt.setString(3, "%" + param.getCompany() + "%");
			}
			else {
				pStmt.setString(3, "%");
			}
			if (param.getnickname() != null) {
				pStmt.setString(4, "%" + param.getNickname() + "%");
			}
			else {
				pStmt.setString(4, "%");
			}
			if (param.getbirthplace() != null) {
				pStmt.setString(5, "%" + param.getBirthplace() + "%");
			}
			else {
				pStmt.setString(5, "%");
			}
			if (param.getthisisme() != null) {
				pStmt.setString(6, "%" + param.getThisisme() + "%");
			}
			else {
				pStmt.setString(6, "%");
			}
			if (param.gethobby() != null) {
				pStmt.setString(7, "%" + param.getHobby() + "%");
			}
			else {
				pStmt.setString(7, "%");
			}
			if (param.getfuture() != null) {
				pStmt.setString(8, "%" + param.getFuture() + "%");
			}
			else {
				pStmt.setString(8, "%");
			}
			if (param.getword() != null) {
				pStmt.setString(9, "%" + param.getWord() + "%");
			}
			else {
				pStmt.setString(9, "%");
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする (変更有)
			while (rs.next()) {
				personal = new personal(
				rs.getInt("number"),
				rs.getInt("name"),
				rs.getString("company"),
				rs.getString("nickname"),
				rs.getString("birthplace"),
				rs.getString("thisisme"),
				rs.getString("hobby"),
				rs.getString("future"),
				rs.getString("word")
				);
				personal.add(List);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			personalList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			personalList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					personalList = null;
				}
			}
		}

		// 結果を返す
		return personalList;
	}
}