package namdv.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import namdv.dao.UserDAO;
import namdv.model.User;

public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String insert_or_edit = "/User.jsp";
	private static String list_user = "/ListUser.jsp";

	public UserController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forward = list_user;
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("listUser")) {
			request.setAttribute("users", UserDAO.getAllRecords());

		} else if (action.equalsIgnoreCase("delete")) {
			String userId = request.getParameter("userId");
			UserDAO.delete(userId);

			request.setAttribute("users", UserDAO.getAllRecords());

		} else if (action.equalsIgnoreCase("edit")) {
			forward = insert_or_edit;
			String userId = request.getParameter("userId");
			User u = UserDAO.getRecordById(userId);
			request.setAttribute("user", u);
		} else {
			forward = insert_or_edit;
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User u = new User();
		u.setName(request.getParameter("username"));
		u.setPassword(request.getParameter("password"));
		u.setEmail(request.getParameter("email"));
		u.setSex(request.getParameter("sex"));
		u.setCountry(request.getParameter("country"));

		String userId = request.getParameter("userid");
		if (userId == null || userId.isEmpty()) {
			UserDAO.add(u);
		} else {
			u.setId(userId);
			UserDAO.update(u);
		}

		response.sendRedirect(request.getContextPath() + "/index.jsp");
	}
}
