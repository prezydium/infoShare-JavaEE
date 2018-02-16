package com.isa.usersengine.servlets;

import com.isa.usersengine.dao.UsersRepositoryDao;
import com.isa.usersengine.dao.UsersRepositoryDaoBean;
import com.isa.usersengine.domain.User;
import com.isa.usersengine.repository.UsersRepository;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/find-user-by-id")
public class FindUserByIdServlet extends HttpServlet {

    @EJB
    UsersRepositoryDao usersRepositoryDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("id") == null
                || req.getParameter("id").isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        } else {

            Integer id = Integer.parseInt(req.getParameter("id"));
            resp.setContentType("text/html;charset=UTF-8");
            PrintWriter writer = resp.getWriter();

            //UsersRepositoryDao ur = new UsersRepositoryDaoBean();

            User temp = usersRepositoryDao.getUserById(id);


            writer.println("<!DOCTYPE html>");
            writer.println("<html>");
            writer.println("<body>");
            writer.println(temp.getName()
                    + " " + temp.getLogin() + " "
                    + temp.getAge());
            writer.println("</body>");
            writer.println("</html>");
        }
    }
}
