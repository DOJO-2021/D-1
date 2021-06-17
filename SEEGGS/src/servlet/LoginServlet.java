package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDAO;
import model.LoginBeans;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

//a
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ログインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("password");

		// ログイン処理を行う(ユーザー)
		LoginDAO iDao = new LoginDAO();
		if (iDao.isLoginOK(id, pw)) {	// ログイン成功
			// セッションスコープにIDを格納する(変更有)
			HttpSession session = request.getSession();
			session.setAttribute("id", new LoginBeans(id,pw));

			if(!id.equals("admin"))
 {
				// ホームサーブレットにリダイレクトする(変更有)
				response.sendRedirect("/SEEGGS/HomeServlet");
				//RequestDispatcher dispatcher = request.getRequestDispatcher("/HomeServlet");
				//dispatcher.forward(request, response);

			}
			else {
				// 管理者用のホームサーブレットへ
				response.sendRedirect("/SEEGGS/AHomeServlet");
				//RequestDispatcher dispatcher = request.getRequestDispatcher("/AHomeServlet");
				//dispatcher.forward(request, response);
			}

		}
		/*else {									// ログイン失敗
			// リクエストスコープに、タイトル、メッセージ、戻り先を格納する
			request.setAttribute("result",
			new ResultBeans("IDまたはPWに間違いがあります。", "/SEEGGS/LoginServlet"));*/

		// 結果ページにフォワードする(変更有)

			}

		/*// ログイン処理を行う(管理者)
		LoginDAO aDao = new LoginDAO();
		if (aDao.isLoginOK(id, pw)) {	// ログイン成功
			// セッションスコープにIDを格納する(変更有)
			HttpSession session = request.getSession();
			session.setAttribute("id,pw", new LoginBeans(id,pw));
			// ホームサーブレットにリダイレクトする(変更有)
			response.sendRedirect("/SEEGGS/AHomeServlet");*/
		/*}
		else {									// ログイン失敗
			// リクエストスコープに、タイトル、メッセージ、戻り先を格納する
			request.setAttribute("result",
			new ResultBeans("IDまたはPWに間違いがあります。", "/SEEGGS/LoginServlet"));


			// 結果ページにフォワードする(変更有)
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Login.jsp");
			dispatcher.forward(request, response);
			}*/
}