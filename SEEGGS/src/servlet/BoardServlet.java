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
 * Servlet implementation class BoardServlet
 */
@WebServlet("/BoardServlet")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardServlet() {
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


			// リクエストパラメータを取得する
			request.setCharacterEncoding("UTF-8");
			int m_number = Integer.parseInt(request.getParameter( "M_NUMBER"));
			int type = Integer.parseInt(request.getParameter("TYPE"));
			String contents = request.getParameter("CONTENTS");

			// 検索処理を行う
			BoardDAO bDao = new BoardDAO();
			List<BoardBeans> BoardList = bDao.select(new BoardBeans(m_number,type,contents));


			//掲示板の種類ごとに検索結果をスレッドに表示する。
			if (request.getParameter("SUBMIT").equals("ノウハウ共有掲示板")) {


				// 検索結果をリクエストスコープに格納する
				request.setAttribute("BoardList", BoardList);

				// 掲示板ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Board.jsp");
				dispatcher.forward(request, response);
			}

			if (request.getParameter("SUBMIT").equals("エラー共有掲示板")) {


				// 検索結果をリクエストスコープに格納する
				request.setAttribute("BoardList", BoardList);

				// 掲示板ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Board.jsp");
				dispatcher.forward(request, response);
			}

			if (request.getParameter("SUBMIT").equals("お悩み相談掲示板")) {


				// 検索結果をリクエストスコープに格納する
				request.setAttribute("BoardList", BoardList);

				// 掲示板ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Board.jsp");
				dispatcher.forward(request, response);
			}

			if (request.getParameter("SUBMIT").equals("講師に質問！")) {


				// 検索結果をリクエストスコープに格納する
				request.setAttribute("BoardList", BoardList);

				// 掲示板ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Board.jsp");
				dispatcher.forward(request, response);
			}

			if (request.getParameter("SUBMIT").equals("ジモトーーーク！")) {


				// 検索結果をリクエストスコープに格納する
				request.setAttribute("BoardList", BoardList);

				// 掲示板ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Board.jsp");
				dispatcher.forward(request, response);
			}

			if (request.getParameter("SUBMIT").equals("休日何してる？")) {


				// 検索結果をリクエストスコープに格納する
				request.setAttribute("BoardList", BoardList);

				// 掲示板ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Board.jsp");
				dispatcher.forward(request, response);
			}


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

		// 掲示板ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Board.jsp");
		dispatcher.forward(request, response);

}


}
