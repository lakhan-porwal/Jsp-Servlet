package in.com.rays.ctl;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.com.rays.bean.UserBean;
import in.com.rays.model.UserModel;

@WebServlet("/UserCtl")
public class	 UserCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("UserView.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		String dob = request.getParameter("dob");

		try {

			bean.setFirstName(firstName);
			bean.setFirstName(lastName);
			bean.setFirstName(loginId);
			bean.setFirstName(password);
			bean.setFirstName(dob);

			model.add(bean);

			request.setAttribute("succMsg", "user saved successfully");
		} catch (Exception e) {
			e.printStackTrace();

		}

		RequestDispatcher rd = request.getRequestDispatcher("UserView.jsp");
		rd.forward(request, response);

	}

}
