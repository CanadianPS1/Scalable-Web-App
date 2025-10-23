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
    @SuppressWarnings({ "UseSpecificCatch", "static-access", "unchecked" })
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //makes my vars
        String search = request.getParameter("search");
        ArrayList<GetAllMovies> movieList;
        movieList = new GetAllMovies().GetAllMoviesList();
        //loops through all the movies and returns any that have the given string of text in their names
        for(int i = 0; i < movieList.size(); i++){
                if(movieList.get(i).getName().toLowerCase().contains(search.toLowerCase())){
                    PrintWriter out = response.getWriter();
                    out.println(movieList.get(i).getName() + "");
                }
        }

        
    }   
}