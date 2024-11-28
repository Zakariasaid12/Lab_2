package com.example.servlet;

import com.example.dao.IndyWinnerDao;
import com.example.dao.IndyWinnerDaoImpl;
import com.example.model.IndyWinner;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@jakarta.servlet.annotation.WebServlet("/IndyWinnerServlet") // URL mapping
public class IndyWinnerServlet extends jakarta.servlet.http.HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IndyWinnerDao dao;

    @Override
    public void init() throws ServletException {
        // Initialize the DAO (ensure it works properly with the MySQL driver)
      
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set the response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            // Validate 'year' parameter
            String yearParam = request.getParameter("year");

            if (yearParam == null || yearParam.isEmpty()) {
                // Handle missing 'year' parameter
                out.println("<h1>Error: Missing 'year' parameter. Please provide a valid year.</h1>");
                return; // Stop further processing
            }

            int year;
            try {
                year = Integer.parseInt(yearParam); // Attempt to parse the year parameter
            } catch (NumberFormatException e) {
                // Handle invalid 'year' parameter
                out.println("<h1>Error: Invalid 'year' parameter. Please enter a valid numeric year.</h1>");
                return; // Stop further processing
            }

            // Use the DAO to fetch the winner from the database
            IndyWinner winner = dao.findWinnerByYear(year);

            if (winner != null) {
                // Display the winner if found
                out.println("<h1>Winner of " + year + ": " + winner.getWinnerName() + "</h1>");
                out.println("<p>Country: " + winner.getCountry() + "</p>");
                out.println("<p>Average Speed: " + winner.getAverageSpeed() + " mph</p>");
            } else {
                // Handle case where no winner is found
                out.println("<h1>No winner found for the year " + year + ".</h1>");
            }

        } catch (Exception e) {
            // Handle any unexpected errors
            out.println("<h1>An error occurred: " + e.getMessage() + "</h1>");
            e.printStackTrace();
        } finally {
            // Close the PrintWriter to release resources
            out.close();
        }
    }

    @Override
    public void destroy() {
        // Clean up resources (if needed)
        super.destroy();
    }
}
