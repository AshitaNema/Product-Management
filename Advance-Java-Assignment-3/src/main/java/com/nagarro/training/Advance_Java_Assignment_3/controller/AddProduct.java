package com.nagarro.training.Advance_Java_Assignment_3.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.hibernate.Session;

import com.nagarro.training.Advance_Java_Assignment_3.model.Product;
import com.nagarro.training.Advance_Java_Assignment_3.model.ProductDao;
import static com.nagarro.training.Advance_Java_Assignment_3.constants.Constants.*;

/**
 * Servlet implementation class AddProduct
 */
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddProduct() {
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
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		addProduct(request, response);

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

	private void addProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String title = req.getParameter("title");
		String qty = req.getParameter("quantity");
		String size = req.getParameter("size");
		String image = req.getParameter("image");

		String currentImage = image;

		FileInputStream fileInputStream = new FileInputStream(currentImage);
		byte[] imagesize = new byte[fileInputStream.available()];
		fileInputStream.read(imagesize);
		Product product = new Product(title, qty, size, image);
		if ((imagesize.length / byteunit) <= 1 && (dbImageLimit + (imagesize.length / byteunit)) <= 10) {
			dbImageLimit += (imagesize.length / byteunit);

			product.setImage(imagesize);
			ProductDao productDao = new ProductDao();
			productDao.addProduct(product);

			
			
			Logger.getLogger(productStatus).info(successMessage);
			System.out.println(dbImageLimit);
			System.out.println(imagesize.length);
			resp.sendRedirect(req.getContextPath() + "/welcome");
		} else {

			Logger.getLogger(productStatus).info(invalidSize);
			System.out.println(dbImageLimit);
			resp.getWriter().print(
					"<html><body><h4 style='color:red;text-align:center;'>Image not uploaded! Use a smaller file.</h4></body></html>");
			req.getRequestDispatcher("welcome.jsp").include(req, resp);
			//resp.sendRedirect(req.getContextPath() + "/welcome");
		}


	}

}
