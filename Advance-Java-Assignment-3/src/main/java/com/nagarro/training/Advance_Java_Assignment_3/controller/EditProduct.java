package com.nagarro.training.Advance_Java_Assignment_3.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nagarro.training.Advance_Java_Assignment_3.model.Product;
import com.nagarro.training.Advance_Java_Assignment_3.model.ProductDao;

/**
 * Servlet implementation class EditProduct
 */
public class EditProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		openEditForm(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	@SuppressWarnings("deprecation")
	private void openEditForm(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		// String prodId = req.getParameter("id");
		ProductDao pd = new ProductDao();
		int id = Integer.parseInt(req.getParameter("id"));
		System.out.println(id);
		Product product = pd.getProduct(id);

		HttpSession session = req.getSession(true);

		session.putValue("id", id);

		session.putValue("title", product.getProductTitle());
		session.putValue("quantity", product.getProductQuantity());
		session.putValue("size", product.getProductSize());
		session.putValue("image", product.getImage());

		System.out.println("Opening Product Edit Form");
		req.getRequestDispatcher("editForm.jsp").forward(req, resp);

	}

}
