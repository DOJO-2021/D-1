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
@WebServlet("/AHomeServlet")//�ύX�L
public class AHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
?
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ���������O�C�����Ă��Ȃ������烍�O�C���T�[�u���b�g�Ƀ��_�C���N�g����
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/SEEGGS/LoginServlet");
			return;
		}
?
		//�Z�b�V�����X�R�[�v�ɃC���X�^���X��ۑ�
				session.setAttribute("id", id);
?
		// ���N�G�X�g�p�����[�^���擾����
		request.setCharacterEncoding("UTF-8");
		String u_number = request.getParameter("U_NUMBER");
		String id = request.getParameter("ID");
		String password = request.getParameter("PASSWORD");
?
		//AHome�y�[�W�Ƀt�H���[�h����
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/AHome.jsp");
		dispatcher.forward(request, response);
	}
}