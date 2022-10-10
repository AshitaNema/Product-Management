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

import com.nagarro.training.Advance_Java_Assignment_3.model.Product;
import com.nagarro.training.Advance_Java_Assignment_3.model.ProductDao;

/**
 * Servlet implementation class DeleteProduct
 */
public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteProduct() {
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
		deleteProduct(request, response);
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

	private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int prodId = Integer.parseInt(req.getParameter("id"));

		ProductDao dao = new ProductDao();
		Product product = dao.getProduct(prodId);
		String image = product.getProductImage();
		System.out.println(image);



		dao.deleteProduct(prodId);

		Logger.getLogger(productStatus).info(successMessage);
		System.out.println(dbImageLimit);
		//System.out.println(imagesize.length);
		resp.sendRedirect(req.getContextPath() + "/welcome");


	}

}
