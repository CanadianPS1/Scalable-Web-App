import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
 
@WebServlet(name = "echo", value = "/echo")
public class echo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.getWriter().println("Welcome to my Echo");
        //for the get
        String x = request.getParameter("x");
        String y = request.getParameter("y");
        response.getWriter().println(x + " my get concatination of x and y " + y);        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //for the post
        String x = request.getParameter("x");
        String y = request.getParameter("y");
        response.getWriter().println(x + " my get concatination of x and y " + y);        
    }
}