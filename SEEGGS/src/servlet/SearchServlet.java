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
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
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
			doPost(request,response);
//			RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/Result.jsp");
//			d.forward(request, response);
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
		//リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String contents = request.getParameter("contents");

		// 検索処理を行う
		BoardDAO bDao = new BoardDAO();
		List<BoardBeans> BoardList = bDao.select3(new BoardBeans("",0,0,contents));

	//	if(contents != null){

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("BoardList", BoardList);
		RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/Result.jsp");
		d.forward(request, response);
		return;
		}
}
