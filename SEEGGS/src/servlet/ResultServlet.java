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
 * Servlet implementation class ResultServlet
 */
@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResultServlet() {
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
					int m_number = Integer.parseInt(request.getParameter("m_number"));
					int type = Integer.parseInt(request.getParameter("type"));
					String contents = request.getParameter("contents");

					// 検索処理を行う
					BoardDAO bDao = new BoardDAO();
					List<BoardBeans> BoardList = bDao.select(new BoardBeans(m_number,type,contents));

					// 検索結果をリクエストスコープに格納する
					request.setAttribute("BoardList", BoardList);

					RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/Result.jsp");
					d.forward(request, response);
					return;
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Result.jsp");
		dispatcher.forward(request, response);
	}

}
