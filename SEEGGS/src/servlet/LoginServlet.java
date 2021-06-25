package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDAO;
import model.LoginBeans;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ログインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("password");

		// ログイン処理を行う(ユーザー)
		LoginDAO iDao = new LoginDAO();
		if (iDao.isLoginOK(id, pw)) { // ログイン成功
			// セッションスコープにIDを格納する(変更有)
			HttpSession session = request.getSession();
			session.setAttribute("id", new LoginBeans(id, pw));

			if (!id.equals("admin")) {
				// ホームサーブレットにリダイレクトする(変更有)
				RequestDispatcher dispatcher = request.getRequestDispatcher("/HomeServlet");
				dispatcher.forward(request, response);

			} else {
				// 管理者用のホームサーブレットへ
				response.sendRedirect("/SEEGGS/AHomeServlet");
			}
		}
	}
}