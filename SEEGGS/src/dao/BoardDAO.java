package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.BoardBeans;

//変更有(以下Personalの部分でエラー5箇所)
public class BoardDAO {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<BoardBeans> select(BoardBeans param) {
		Connection conn = null;
		List<BoardBeans> BoardList = new ArrayList<BoardBeans>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-1/SEEGGS", "sa", "");

			// SQL文を準備する(変更有・？)
			String sql = "select contents from Favorite where M_number like ?  and type like ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる(変更有)
			if (param.getM_number() != 0) {
				pStmt.setString(1, "%" + param.getM_number() + "%");
			}
			else {
				pStmt.setString(1, "%");
			}
			if (param.getType() != 0) {
				pStmt.setString(2, "%" + param.getType() + "%");
			}
			else {
				pStmt.setString(2, "%");
			}


			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする (変更有)
			while (rs.next()) {
				BoardBeans Ccard = new BoardBeans(
				rs.getInt("M_number"),
				rs.getInt("Type"),
				rs.getString("Contents")
				);
				BoardList.add(Ccard);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			BoardList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			BoardList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					BoardList = null;
				}
			}
		}

		// 結果を返す
		return BoardList;
	}
	//お気に入りの登録
			public boolean insert(BoardBeans bcard) {
				Connection conn = null;
				boolean result = false;

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-1/SEEGGS", "sa", "");

					// SQL文を準備する
					String sql = "insert into FORUM values (null, ?, ?)";
					PreparedStatement pStmt = conn.prepareStatement(sql);

					// SQL文を完成させる
					if (bcard.getType() != 0) {
						pStmt.setInt(1, bcard.getType());
					}
					else {
						pStmt.setString(1, "null");
					}
					if (bcard.getContents() != null) {
						pStmt.setString(2, bcard.getContents());
					}
					else {
						pStmt.setString(2, "null");
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
}