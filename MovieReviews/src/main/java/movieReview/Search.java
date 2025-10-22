package movieReview;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(name = "search", value = "/search")
public class Search extends HttpServlet{
    @Override
    @SuppressWarnings("UseSpecificCatch")
    //handles the get requests
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //for the get
        //declares all my url vars and my 2 number vars
        String search = request.getParameter("search");
        ArrayList<GetAllMovies> movieList = new ArrayList<>();
        for(int i = 0; i < new GetAllMovies().getSize(); i++){
            movieList.add(new GetAllMovies(i + 1));
        }
        for(int i = 0; i < movieList.size(); i++){
            if(movieList.get(i).getName().toLowerCase().contains(search.toLowerCase())){
                PrintWriter out = response.getWriter();
                out.println(movieList.get(i).getName() + "");
            }
        }

        
    }   
}