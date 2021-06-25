package servlet;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class UpdateDeleteServlet
 */
@WebServlet("/UserUpdateDeleteServlet")
public class UserUpdateDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("LoginServlet");
			return;
		}
		// プロフィールページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Auser.jsp");
		dispatcher.forward(request, response);
	}

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

		// リクエストパラメータを取得する　更新と削除の場合はIDが必ず必要（自動採番）なのでrequestでIDをクライアントから仕入れる。その仕入れた番号と照合

		request.setCharacterEncoding("UTF-8");
		ArrayList<UserBeans> userList =(ArrayList)session.getAttribute("User");
		UserBeans user = userList.get(0);
		String id = user.getId();
		String password = user.getPassword();

		String photo = request.getParameter("photo");
		String name = request.getParameter("name");
		String company = request.getParameter("company");
		String nickname = request.getParameter("nickname");
		String birthplace = request.getParameter("birthplace");
		String thisisme = request.getParameter("thisisme");
		String hobby = request.getParameter("hobby");
		String future = request.getParameter("future");
		String word = request.getParameter("word");
		user = new UserBeans(id, password, photo, name, company, nickname, birthplace, thisisme, hobby, future, word);

		// 更新または削除を行う
		UserDAO uDao = new UserDAO();
		if (request.getParameter("submit").equals("更新")) {
			//ここでのIDは自動採番が終わった後のIDであり、変数になる。→クライアントから入力された数字
			if (uDao.update(user)){	// 更新成功
				session.setAttribute("User",  user);

			}
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
//			dispatcher.forward(request, response);
//			return;
//
		}
		if (request.getParameter("submit").equals("削除")) {
			if (uDao.delete(id)) {	// 削除成功

			}

		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
		dispatcher.forward(request, response);
		return;
	}
}
