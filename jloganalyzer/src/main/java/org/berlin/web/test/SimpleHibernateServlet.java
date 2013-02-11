package org.berlin.web.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SimpleHibernateServlet
 */
public class SimpleHibernateServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SimpleHibernateServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		System.out.println("Running");		
		try {
			final NativeApiIllustrationTest hbm = new NativeApiIllustrationTest();
			hbm.setUp();
			hbm.testBasicUsage();
			hbm.tearDown();
		} catch(final Exception e) {
			e.printStackTrace();
		} // End of the try - catch //
		
		final PrintWriter out = response.getWriter();
		out.println("<html><body>Complete</body></html>");
		System.out.println("Done");
	}

} // End of the class //
