package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.UserController;
import model.User;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String birth = request.getParameter("birth");
		String gender = request.getParameter("gender");
		String[] hobby = request.getParameterValues("hobby");

		User user = new User(username, password, email, gender, birth, hobby);
		boolean added = UserController.addUser(user);

		PrintWriter out = response.getWriter();
		if (added) {
			out.append("<p>恭喜您，注册成功！</p>");
		} else {
			out.append("注册失败，用户已存在，请");
		}
		out.append("<a href='login.html'>点击登录</a>");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append("当前页面不允许使用GET方式提交！");
		// String username = new String(username.getBytes("iso8859-1"),
		// "UTF-8");
	}
}
