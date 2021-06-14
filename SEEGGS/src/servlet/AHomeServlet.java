package servlet;
?
import java.io.IOException;
?
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
?
/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/AHomeServlet")//変更有
public class AHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
?
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
?
		//セッションスコープにインスタンスを保存
				session.setAttribute("id", id);
?
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String u_number = request.getParameter("U_NUMBER");
		String id = request.getParameter("ID");
		String password = request.getParameter("PASSWORD");
?
		//AHomeページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/AHome.jsp");
		dispatcher.forward(request, response);
	}
}