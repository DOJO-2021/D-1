package servlet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.UserDAO;
import model.ResultBeans;
import model.UserBeans;
/**
 * Servlet implementation class AccountServlet
 */
@WebServlet("/AccountServlet")
@MultipartConfig
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
	/*
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/SEEGGS/LoginServlet");
			return;
		}
		*/

		// 登録ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Account.jsp");
				dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/*
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
				HttpSession session = request.getSession();
				if (session.getAttribute("id") == null) {
					response.sendRedirect("/SEEGGS/LoginServlet");
					return;
				}
				*/

				// リクエストパラメータを取得する
				request.setCharacterEncoding("UTF-8");

				String id = request.getParameter("id");
				String password = request.getParameter("password");

				// 画像のアップロード方法について要確認

				Part part = request.getPart("photo");

				String name = request.getParameter("name");
				String company = request.getParameter("company");
				String nickname = request.getParameter("nickname");
				String hobby = request.getParameter("hobby");
				String birthplace = request.getParameter("birthplace");
				String thisisme = request.getParameter("thisisme");
				String future = request.getParameter("future");
				String word = request.getParameter("word");

				UserDAO uDao = new UserDAO();


				System.out.println(part);

				String photo = Paths.get(part.getSubmittedFileName()).getFileName().toString();

				// アップロードするフォルダ
				String path ="C:/pleiades/workspace/D-1/SEEGGS/WebContent/upload";
				//実際にファイルが保存されている場所の確認、ターミナルから確認
				System.out.println(path);

				// 写真の登録処理
				try {part.write(path+File.separator+photo);
					if(uDao.insert (new UserBeans(id, password, photo, name, company, nickname, hobby, birthplace, thisisme, future, word)));
				} catch(Exception e) {
						request.setAttribute("submit",
								new ResultBeans("登録を正常に行うことができませんでした", "HomeServlet"));
				}

				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("HomeServlet");
				dispatcher.forward(request, response);
	}

}
