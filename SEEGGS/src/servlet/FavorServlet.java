package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.FavorDAO;
import model.FavorBeans;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/FavorServlet")
public class FavorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FavorServlet() {
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
		// お気に入りページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Favor.jsp");
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
			String u_number = request.getParameter("U_NUMBER");
			String m_number = request.getParameter("M_NUMBER");

			// 検索処理を行う
			FavorDAO fDao = new FavorDAO();
			List<FavorBeans> cardList = fDao.select(new FavorBeans(0, 0));

			// 検索結果をリクエストスコープに格納する
			request.setAttribute("favorList", favorList);

			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Favor.jsp");
			dispatcher.forward(request, response);
	}


}

