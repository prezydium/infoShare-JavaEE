package com.isa.usersengine.servlets;

import com.isa.usersengine.dao.UsersRepositoryDao;
import com.isa.usersengine.dao.UsersRepositoryDaoBean;
import com.isa.usersengine.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add-user")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User newUser = new User();
        newUser.setId(Integer.parseInt(req.getParameter("id")));
        newUser.setName(req.getParameter("name"));
        newUser.setLogin(req.getParameter("login"));
        newUser.setAge(Integer.valueOf(req.getParameter("age")));
        newUser.setPassword(req.getParameter("password"));
        UsersRepositoryDao urdao = new UsersRepositoryDaoBean();
        urdao.addUser(newUser);


    }
}
