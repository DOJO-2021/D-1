package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.FavorDAO;
import model.FavorBeans;
import model.ResultBeans;

/**
 * Servlet implementation class UpdateDeleteServlet
 */
@WebServlet("/ThreadUpdateDeleteServlet")
public class ThreadUpdateDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/SEEGGS/LoginServlet");
			return;
		}

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		int u_number = Integer.parseInt(request.getParameter("U_NUMBER"));
		int m_number = Integer.parseInt(request.getParameter("M_NUMBER"));

		// 更新または削除を行う
		FavorDAO fDao = new FavorDAO();
		if (request.getParameter("SUBMIT").equals("更新")) {
			if (fDao.update(new FavorBeans(u_number, m_number))) {	// 更新成功
				request.setAttribute("result",
				new ResultBeans("データを更新しました。", "/SEEGGS/AHomeServlet"));
			}
			else {												// 更新失敗
				request.setAttribute("result",
				new ResultBeans("データを更新できませんでした。", "/SEEGGS/AHomeServlet"));
			}
		}
		else {
			if (fDao.delete(u_number)) {	// 削除成功
				request.setAttribute("result",
				new ResultBeans("ユーザーを削除しました。", "/SEEGGS/AHomeServlet"));
			}
			else {						// 削除失敗
				request.setAttribute("result",
				new ResultBeans("ユーザーを削除できませんでした。", "/SEEGGS/AHomeServlet"));
			}
		}

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/AResult.jsp");
		dispatcher.forward(request, response);
	}
}

