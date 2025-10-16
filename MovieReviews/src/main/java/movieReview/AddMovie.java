package movieReview;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(name = "add-movie", value = "/add-movie")
public class AddMovie extends HttpServlet{
    @Override
    @SuppressWarnings("UseSpecificCatch")
    //handles the get requests
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //for the get
        //declares all my url vars and my 2 number vars
        //String num1String = request.getParameter("search");
        
    }   
}