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
 * Servlet implementation class AccountServlet
 */
@WebServlet("/AccountServlet")
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountServlet() {
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
		// 登録ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Account.jsp");
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
				String name = request.getParameter("NAME");
				String nickname = request.getParameter("NICKNAME");
				String company = request.getParameter("COMPANY");
				String hobby = request.getParameter("HOBBY");
				String birthplace = request.getParameter("BIRTHPLACE");
				String thisisme = request.getParameter("THISISME");
				String future = request.getParameter("FUTURE");
				String word = request.getParameter("WORD");

				// 画像のアップロード方法について要確認

				// 登録処理を行う
				UserDAO uDao = new UserDAO();
				if (uDao.insert(new Account(0, name, nickname, company, hobby, birthplace, thisisme, future, word))) {	// 登録成功
					request.setAttribute("result",
					new Result("登録完了", "/SEEGGS/HomeServlet"));
				}
				else {												// 登録失敗
					request.setAttribute("result",
					new Result("登録を正常に行うことができませんでした", "/SEEGS/HomeServlet"));
				}

				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Result.jsp");
				dispatcher.forward(request, response);
	}

}
