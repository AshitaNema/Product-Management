package com.nagarro.training.Advance_Java_Assignment_3.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nagarro.training.Advance_Java_Assignment_3.model.LoginDao;
import com.nagarro.training.Advance_Java_Assignment_3.model.Users;


public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDao loginDao;

    public void init() {
        loginDao = new LoginDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String uname = request.getParameter("uname");
        String upass = request.getParameter("upass");
        Users user = new Users();
        user.setUname(uname);
        user.setPass(upass);

        
        try {
            if (loginDao.validate(user)) {
            	//response.getWriter().print("after validate");
                HttpSession session = request.getSession(true);
                session.setAttribute("userSession",user.getUname());
                response.sendRedirect(request.getContextPath()+"/welcome");
//            	RequestDispatcher dispatcher = request.getRequestDispatcher("welcome.jsp");
//                dispatcher.forward(request, response);
            } else {
            	response.getWriter().print("");
                HttpSession session = request.getSession();
                RequestDispatcher dispatcher = request.getRequestDispatcher("Error.jsp");
                dispatcher.include(request, response);
                //session.setAttribute("user", username);
                //response.sendRedirect("login.jsp");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	doGet(req, resp);
    }

}
