package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//変更有(以下Personalの部分でエラー5箇所)
public class BoardDAO {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<Personal> select(Personal param) {
		Connection conn = null;
		List<Personal> PersonalList = new ArrayList<Personal>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-1/SEEGGS", "sa", "");

			// SQL文を準備する(変更有・？)
			String sql = "select , number, knowhow , error, problem, question, local, private, mark, "
					+ "from form where number like ? and know how like ? and error like? "
					+ "and problem like?  and question like?  and local like? and private like? and mark like?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる(変更有)
			if (param.getnumber() != null) {
				pStmt.setString(1, "%" + param.getNumber() + "%");
			}
			else {
				pStmt.setString(1, "%");
			}
			if (param.getknowhow() != null) {
				pStmt.setString(2, "%" + param.getKnowhow() + "%");
			}
			else {
				pStmt.setString(2, "%");
			}
			if (param.geterror() != null) {
				pStmt.setString(3, "%" + param.getError() + "%");
			}
			else {
				pStmt.setString(3, "%");
			}
			if (param.getproblem() != null) {
				pStmt.setString(4, "%" + param.getProblem() + "%");
			}
			else {
				pStmt.setString(4, "%");
			}
			if (param.getquestion() != null) {
				pStmt.setString(5, "%" + param.getQuestion() + "%");
			}
			else {
				pStmt.setString(5, "%");
			}
			if (param.getlocal() != null) {
				pStmt.setString(6, "%" + param.getLocal() + "%");
			}
			else {
				pStmt.setString(6, "%");
			}
			if (param.getprivate() != null) {
				pStmt.setString(7, "%" + param.getPrivate() + "%");
			}
			else {
				pStmt.setString(7, "%");
			}
			if (param.getmark() != null) {
				pStmt.setString(8, "%" + param.getMark() + "%");
			}
			else {
				pStmt.setString(8, "%");
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする (変更有)
			while (rs.next()) {
				Personal = new Personal(
				rs.getInt("number"),
				rs.getInt("knowhow"),
				rs.getString("error"),
				rs.getString("problem"),
				rs.getString("question"),
				rs.getString("local"),
				rs.getString("private"),
				rs.getString("mark")
				);
				Personal.add(List);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			PersonallList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			PersonalList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					PersonalList = null;
				}
			}
		}

		// 結果を返す
		return PersonalList;
	}
}