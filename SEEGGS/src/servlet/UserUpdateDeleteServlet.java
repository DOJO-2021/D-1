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
 * Servlet implementation class UpdateDeleteServlet
 */
@WebServlet("/UserUpdateDeleteServlet")
public class UserUpdateDeleteServlet extends HttpServlet {
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
		String photo = request.getParameter("PHOTO");
		String name = request.getParameter("NAME");
		String company = request.getParameter("COMPANY");
		String nickname = request.getParameter("NICKNAME");
		String birthplace = request.getParameter("BIRTHPLACE");
		String thisisme = request.getParameter("THISISME");
		String hobby = request.getParameter("HOBBY");
		String future = request.getParameter("FUTURE");
		String word = request.getParameter("WORD");

		// 更新または削除を行う
		UserDAO uDao = new UserDAO();
		if (request.getParameter("SUBMIT").equals("更新")) {
			if (uDao.update(new UserBeans(u_number, photo, name, company, nickname, birthplace, thisisme, hobby, future, word))) {	// 更新成功
				request.setAttribute("result",
				new ResultBeans("データを更新しました。", "/SEEGGS/AHomeServlet"));
			}
			else {												// 更新失敗
				request.setAttribute("result",
				new ResultBeans("データを更新できませんでした。", "/SEEGGS/AHomeServlet"));
			}
		}
		else {
			if (uDao.delete(u_number)) {	// 削除成功
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

