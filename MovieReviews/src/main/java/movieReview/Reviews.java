package movieReview;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(name = "reviews", value = "/reviews")
public class Reviews extends HttpServlet{
    @Override
    @SuppressWarnings({ "UseSpecificCatch", "static-access" })
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //makes my vars
        String review = request.getParameter("review");
        String movie = request.getParameter("movie");
        @SuppressWarnings("unchecked")
        ArrayList<GetAllMovies> movies = new GetAllMovies().GetAllMoviesList();
        //loops through all the movies to find the movie thats being searched for and then finds all of its reviews and displays them
        for(int i = 0; i < movies.size(); i++){
            if(movies.get(i).getName().equals(movie)){
                if(review != null){
                    movies.get(i).AddReview(review);
                }
                @SuppressWarnings("unchecked")
                ArrayList<String> reviews = movies.get(i).getReviews();
                PrintWriter out = response.getWriter();
                for(int j = 0; j < reviews.size(); j++){
                    out.println(reviews.get(j) + "");
                }
                break;
            }
        }
        
    }   
}