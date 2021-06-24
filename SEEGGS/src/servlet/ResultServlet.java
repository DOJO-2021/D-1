package servlet;

import java.io.IOException;

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
		//ThreadJSPからの投稿をデータベースにインサートしてBoardServletにフォワードするServlet
					HttpSession session = request.getSession();
					if (session.getAttribute("id") == null) {
						response.sendRedirect("/SEEGGS/LoginServlet");
						return;
					}

					doPost(request,response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/SEEGGS/LoginServlet");
			return;
		}
		request.setCharacterEncoding("UTF-8");
		int type = Integer.parseInt(request.getParameter("type"));
		String contents = request.getParameter("contents");


		BoardDAO bDao = new BoardDAO();
		if (bDao.insert(new  BoardBeans(null, 0,type,contents))) {	// 登録成功

			RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/Board.jsp");
			d.forward(request, response);
			return;

		}

		RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/Board.jsp");
		d.forward(request, response);
		return;
	}

}
