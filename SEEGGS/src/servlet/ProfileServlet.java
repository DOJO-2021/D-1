package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import model.LoginBeans;
import model.UserBeans;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("LoginServlet");
			return;
		}
		// プロフィールページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Profile.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		LoginBeans login = (LoginBeans)session.getAttribute("id");

		if (login == null) {
			response.sendRedirect("LoginServlet");
			return;
		}

		// セッションからログイン中のユーザーIDを取得する（パスワードも念のため）
		String id = login.getId();
		String password = login.getPw();

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String photo = request.getParameter("photo");
		String name = request.getParameter("name");
		String company = request.getParameter("company");
		String nickname = request.getParameter("nickname");
		String birthplace = request.getParameter("birthplace");
		String thisisme = request.getParameter("thisisme");
		String hobby = request.getParameter("hobby");
		String future = request.getParameter("future");
		String word = request.getParameter("word");
		UserBeans user = new UserBeans(id, password, photo, name, company, nickname, birthplace, thisisme, hobby, future, word);

		// 更新を行う
		UserDAO uDao = new UserDAO();
		if (request.getParameter("SUBMIT").equals("更新")) {
			if (uDao.update(user)) { // 更新成功
				session.setAttribute("User", user);
				//				new ResultBeans("データを更新しました。", "HomeServlet"));
				//			}
				//			else {												// 更新失敗
				//				request.setAttribute("result",
				//				new ResultBeans("データを更新できませんでした。", "HomeServlet"));
			}
		}

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("HomeServlet");
		dispatcher.forward(request, response);
	}
}