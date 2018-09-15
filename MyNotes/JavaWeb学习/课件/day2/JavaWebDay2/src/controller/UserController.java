package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.IOUtils;
import model.User;

public class UserController {

	private static List<User> users = new ArrayList<>();

	@SuppressWarnings("unchecked")
	public static void init() {
		List<User> list = (List<User>) IOUtils.loadObject("D:\\datas.file");
		if (list != null) {
			users.addAll(list);
		}
	}

	public static boolean save() {
		return IOUtils.saveObject("D:\\datas.file", users);
	}

	public static boolean addUser(User user) {
		User u = getUserByName(user.getUsername());
		if (u != null) {
			return false;
		}

		if (user.getId() < 0) {
			user.setId(users.size() + 1);
		}

		user.setCreateTime(new Date());
		users.add(user);
		save();
		return true;
	}

	public static User getUserByName(String name) {
		if (name == null) {
			return null;
		}

		for (User user : users) {
			if (name.equals(user.getUsername())) {
				return user;
			}
		}

		return null;
	}
}
