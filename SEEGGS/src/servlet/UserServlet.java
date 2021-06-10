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

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		// ユーザページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/User.jsp");
		dispatcher.forward(request, response);
	}

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
			String photo = request.getParameter("PHOTO");
			String name = request.getParameter("NAME");
			String company = request.getParameter("COMPANY");
			String nickname = request.getParameter("NICKNAME");
			String birthplace = request.getParameter("BIRTHPLACE");
			String thisisme = request.getParameter("THISISME");
			String hobby = request.getParameter("HOBBY");
			String future = request.getParameter("FUTURE");
			String word = request.getParameter("WORD");

			// 検索処理を行う
			UserDAO uDao = new UserDAO();
			List<Personal> cardList = uDao.select(new Personal(0, photo, name, company, nickname, birthplace, thisisme, hobby, future, word));

			// 検索結果をリクエストスコープに格納する
			request.setAttribute("cardList", cardList);

			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/User.jsp");
			dispatcher.forward(request, response);
	}


}
