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
import model.UserBeans;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")//変更有
public class HomeServlet extends HttpServlet {
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
			List<UserBeans> UserList = uDao.select(new UserBeans(id,password,photo, name, company, nickname, birthplace, thisisme, hobby, future, word));

			// 検索結果をリクエストスコープに格納する
			request.setAttribute("UserList", UserList);
		}
		/*
		//セッションスコープにインスタンスを保存
		session.setAttribute("id", id);*/

		/*// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("ID");
		String password = request.getParameter("PASSWORD");*/

		//Homeページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Home.jsp");
		dispatcher.forward(request, response);
	}
}