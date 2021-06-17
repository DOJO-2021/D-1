package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BoardUpdateDeleteDAO;

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
		int m_number = Integer.parseInt(request.getParameter("m_number"));
//		int type = Integer.parseInt(request.getParameter("type"));
//		String contents = request.getParameter("contents");

		// 削除を行う
		BoardUpdateDeleteDAO budDao = new BoardUpdateDeleteDAO();
		if (request.getParameter("SUBMIT").equals("削除")) {
			if (budDao.delete (m_number)) {

		//AThreadServletにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("AThreadServlet");
			dispatcher.forward(request, response);

			}
		}
	}
}