package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BoardDAO;
import model.BoardBeans;
import model.LoginBeans;


/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/SEEGGS/LoginServlet");
			return;
		}

		// スレッドページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Thread.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		LoginBeans login = (LoginBeans)session.getAttribute("id");

		if(login  == null) {
			response.sendRedirect("/SEEGGS/LoginServlet");
			return;
		}

		// セッションからログイン中のユーザーIDを取得する
		String id = login.getId();

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		int type = Integer.parseInt(request.getParameter("type"));
		String contents = request.getParameter("contents");


		// 登録処理を行う
		BoardDAO bDao = new BoardDAO();
		if (bDao.insert(new BoardBeans(id, 0, type, contents))) {	// 登録成功

			//typeの値を渡す
			request.setAttribute("type", type);

			// 元のページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("ThreadServlet");
			dispatcher.forward(request, response);

		}

	}
}
