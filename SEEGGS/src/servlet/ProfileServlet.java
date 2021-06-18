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
import model.ResultBeans;
import model.UserBeans;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("LoginServlet");
			return;
		}

		// リクエストパラメータを取得する
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

		// 更新を行う
		UserDAO uDao = new UserDAO();
		if (request.getParameter("SUBMIT").equals("更新")) {
			if (uDao.update(new UserBeans(id, password, photo, name, company, nickname, birthplace, thisisme, hobby, future, word))) {	// 更新成功
				request.setAttribute("result",
				new ResultBeans("データを更新しました。", "HomeServlet"));
			}
			else {												// 更新失敗
				request.setAttribute("result",
				new ResultBeans("データを更新できませんでした。", "HomeServlet"));
			}
		}

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("HomeServlet");
		dispatcher.forward(request, response);
	}
}