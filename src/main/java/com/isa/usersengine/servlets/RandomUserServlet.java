package com.isa.usersengine.servlets;


import com.isa.usersengine.cdi.RandomUserCDIApplicationDao;
import com.isa.usersengine.cdi.RandomUserCDIRequestDao;
import com.isa.usersengine.cdi.RandomUserCDISessionDao;
import com.isa.usersengine.domain.User;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/random-user")
public class RandomUserServlet extends HttpServlet {

    @Inject
    RandomUserCDISessionDao randomUserCDISessionDao;
    @Inject
    RandomUserCDIApplicationDao randomUserCDIApplicationDao;
    @Inject
    RandomUserCDIRequestDao randomUserCDIRequestDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        User sessionUser = randomUserCDISessionDao.getRandomUser();
        User requestUser = randomUserCDIRequestDao.getRandomUser();
        User applicationUser = randomUserCDIApplicationDao.getRandomUser();

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<body>");
        writer.println(sessionUser.toString() + "  - sessionUser\n");
        writer.println(requestUser.toString() + "  - requestUser\n");
        writer.println(applicationUser.toString() + "  - applicationUser\n");
        writer.println("</body>");
        writer.println("</html>");


    }
}