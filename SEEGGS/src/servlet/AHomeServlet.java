package servlet;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class HomeServlet
 */
@WebServlet("/AHomeServlet")//変更有
public class AHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/SEEGGS/LoginServlet");
			return;//リダイレクトとフォワードをおなじServlet内で同時に起こさないための処理
		}else {
			// リクエストパラメータを取得する
			request.setCharacterEncoding("UTF-8");
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			String photo = request.getParameter("photo");
			String name = request.getParameter("name");
			String company = request.getParameter("company");
			String nickname = request.getParameter("nickname");
			String birthplace = request.getParameter("birthplace");
			String thisisme = request.getParameter("thisisme");
			String hobby = request.getParameter("hobby");
			String future = request.getParameter("future");
			String word = request.getParameter("word");

			// 検索処理を行う
			UserDAO uDao = new UserDAO();
			List<UserBeans> UserList = uDao.select1(new UserBeans(id,password,photo, name, company, nickname, birthplace, thisisme, hobby, future, word));

			// 検索結果をリクエストスコープに格納する
			request.setAttribute("UserList", UserList);

			// 初回ログイン時はログイン中のユーザー情報をセッションに格納する
			// （厳密ではないが、取得できたUserListの件数が1件、
			// かつ、その１件のIDと、セッションにすでにあるログインIDとが一致していればという判定で代用）

			if(UserList.size() == 1) {
				String uid = UserList.get(0).getId();
				LoginBeans login = (LoginBeans)session.getAttribute("id");
				String sid = login.getId();

				if(id.equals(sid)) {
					session.setAttribute("User", UserList);
				}
			}
		}

		//Homeページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/AHome.jsp");
		dispatcher.forward(request, response);
	}
}