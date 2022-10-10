package com.nagarro.training.Advance_Java_Assignment_3.controller;

import static com.nagarro.training.Advance_Java_Assignment_3.constants.Constants.byteunit;
import static com.nagarro.training.Advance_Java_Assignment_3.constants.Constants.dbImageLimit;
import static com.nagarro.training.Advance_Java_Assignment_3.constants.Constants.invalidSize;
import static com.nagarro.training.Advance_Java_Assignment_3.constants.Constants.productStatus;
import static com.nagarro.training.Advance_Java_Assignment_3.constants.Constants.successMessage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nagarro.training.Advance_Java_Assignment_3.model.Product;
import com.nagarro.training.Advance_Java_Assignment_3.model.ProductDao;

/**
 * Servlet implementation class SaveEditedProduct
 */
public class SaveEditedProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveEditedProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		editProduct(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void editProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		HttpSession session = req.getSession();
		int id = (int) session.getAttribute("id");

		String title = req.getParameter("title").trim();
		String qty = req.getParameter("quantity").trim();
		String size = req.getParameter("size").trim();
		String image = req.getParameter("image").trim();

		ProductDao dao = new ProductDao();


		String currentImage = image;

		FileInputStream fileInputStream = new FileInputStream(currentImage);
		byte[] imagesize = new byte[fileInputStream.available()];
		fileInputStream.read(imagesize);


		if ((imagesize.length / byteunit) <= 1 && (dbImageLimit + (imagesize.length / byteunit)) <= 10) {
			dbImageLimit += (imagesize.length / byteunit);


			dao.editProduct(id, title, qty, size, image,imagesize);

			Logger.getLogger(productStatus).info(successMessage);
			System.out.println(dbImageLimit);
			System.out.println(imagesize.length);
			session.removeAttribute("id");
			System.out.println("Successfully Edited product");
			resp.sendRedirect(req.getContextPath() + "/welcome");
		} else {

			Logger.getLogger(productStatus).info(invalidSize);
			System.out.println(dbImageLimit);
			resp.getWriter().print(
					"<html><body><h4 style='color:red;text-align:center;'>Image not uploaded! Use a smaller file.</h4></body></html>");
			req.getRequestDispatcher("welcome.jsp").include(req, resp);
			
		}

	}

}
