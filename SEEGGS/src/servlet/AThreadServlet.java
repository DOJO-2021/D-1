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

import dao.BoardDAO;
import model.BoardBeans;

/**
 * Servlet implementation class ThreadServlet
 */
@WebServlet("/AThreadServlet")
public class AThreadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AThreadServlet() {
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
			response.sendRedirect("/LoginServlet");
			return;
		}
			doPost(request,response);

		// スレッドページにフォワードするs
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Thread.jsp");
//		dispatcher.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/LoginServlet");
			return;
		}

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		int type = Integer.parseInt(request.getParameter("type"));
		//掲示板の種類ごとに検索結果をスレッドに表示する。
		if (type == 1) {

			// 検索処理を行う
			BoardDAO bDao = new BoardDAO();
			List<BoardBeans> BoardList = bDao.select(new BoardBeans(null, 0,type,null));

			// 検索結果をリクエストスコープに格納する
			request.setAttribute("BoardList", BoardList);
			request.setAttribute("type", type);


			// 掲示板ページにフォワードする
			//response.sendRedirect("/WEB-INF/jsp/Thread.jsp");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/AThread.jsp");
			dispatcher.forward(request, response);
		}

		if (type == 2) {

			// 検索処理を行う
			BoardDAO bDao = new BoardDAO();
			List<BoardBeans> BoardList = bDao.select(new BoardBeans(null, 0,type,null));

			// 検索結果をリクエストスコープに格納する
			request.setAttribute("BoardList", BoardList);
			request.setAttribute("type", type);

			// 掲示板ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/AThread.jsp");
			dispatcher.forward(request, response);
		}

		if (type == 3) {

			// 検索処理を行う
			BoardDAO bDao = new BoardDAO();
			List<BoardBeans> BoardList = bDao.select(new BoardBeans(null, 0,type,null));

			// 検索結果をリクエストスコープに格納する
			request.setAttribute("BoardList", BoardList);
			request.setAttribute("type", type);

			// 掲示板ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/AThread.jsp");
			dispatcher.forward(request, response);
		}

		if (type == 4) {

			// 検索処理を行う
			BoardDAO bDao = new BoardDAO();
			List<BoardBeans> BoardList = bDao.select(new BoardBeans(null, 0,type,null));

			// 検索結果をリクエストスコープに格納する
			request.setAttribute("BoardList", BoardList);
			request.setAttribute("type", type);

			// 掲示板ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/AThread.jsp");
			dispatcher.forward(request, response);
		}

		if (type == 5) {

			// 検索処理を行う
			BoardDAO bDao = new BoardDAO();
			List<BoardBeans> BoardList = bDao.select(new BoardBeans(null, 0,type,null));

			// 検索結果をリクエストスコープに格納する
			request.setAttribute("BoardList", BoardList);
			request.setAttribute("type", type);

			// 掲示板ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/AThread.jsp");
			dispatcher.forward(request, response);
		}

		if (type == 6) {

			// 検索処理を行う
			BoardDAO bDao = new BoardDAO();
			List<BoardBeans> BoardList = bDao.select(new BoardBeans(null, 0,type,null));

			// 検索結果をリクエストスコープに格納する
			request.setAttribute("BoardList", BoardList);
			request.setAttribute("type", type);

			// 掲示板ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/AThread.jsp");
			dispatcher.forward(request, response);

		}
	}
}