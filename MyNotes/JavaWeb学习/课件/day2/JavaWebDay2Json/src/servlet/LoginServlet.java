package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// String username = request.getParameter("username");
		// String password = request.getParameter("password");
		//

		PrintWriter out = response.getWriter();
		String str = assemblewithGson();
		System.out.println(str);
		out.append(str);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private String assembleWithJson() {
		User user = new User("Zhangsan", // uname
				"abcd123", // pwd
				"123@qq.com", // email
				"Male", // gender
				"1980-01-01", // birth
				new String[] { "Movie", "Music" });

		JSONObject jobj = new JSONObject();
		jobj.put("username", user.getUsername());
		jobj.put("password", user.getPassword());
		jobj.put("email", user.getEmail());
		jobj.put("gender", user.getGender());
		JSONArray array = new JSONArray();
		for (String h : user.getHobby()) {
			array.add(h);
		}
		jobj.put("hobby", array.toString());
		return jobj.toString();
	}

	private String assemblewithGson() {
		User user = new User("Lisi", // uname
				"qqqqqqq", // pwd
				"qqq@qq.com", // email
				"dfasfasd", // gender
				"1982-02-02", // birth
				new String[] { "Music" });
		
		
		
		return new Gson().toJson(user);
	}
}
