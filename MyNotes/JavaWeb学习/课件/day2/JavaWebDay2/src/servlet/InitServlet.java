package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import controller.UserController;

public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		super.init();

		UserController.init();
	}

	@Override
	public void destroy() {
		super.destroy();

		UserController.save();
	}
}
