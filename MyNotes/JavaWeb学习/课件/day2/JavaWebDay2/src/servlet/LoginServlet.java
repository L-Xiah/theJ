package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.UserController;
import model.User;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append("当前页面不允许使用GET方式提交！");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = UserController.getUserByName(username);
		if (user == null) {
			out.append("<p>(" + username + ")用户未注册！</p>");
			out.append("<a href='register.html'>点击注册</a>");
			return;
		}

		if (!user.getPassword().equals(password)) {
			out.append("<p>用户名或密码错误！</p>");
			out.append("<a onclick='javascript: history.back(-1)'>点击返回</a>");
			return;
		}

		out.append("<h1>欢迎您，" + username + "</h1>");
		StringBuilder sb = new StringBuilder();
		sb.append("姓名：" + user.getUsername());
		sb.append("<br/>");
		sb.append("邮箱：" + user.getEmail());
		sb.append("<br/>");
		sb.append("性别：" + user.getGender());
		sb.append("<br/>");
		sb.append("生日：" + user.getBirth());
		sb.append("<br/>");
		String hobby = "";
		for (String h : user.getHobby()) {
			hobby += (h + " ");
		}
		sb.append("爱好：" + hobby);
		out.append(sb.toString());
	}
}
