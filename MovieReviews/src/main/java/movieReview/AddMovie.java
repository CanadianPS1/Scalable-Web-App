package movieReview;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(name = "add-movie", value = "/add-movie")
public class AddMovie extends HttpServlet{
    @Override
    @SuppressWarnings({ "UseSpecificCatch", "static-access" })
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String movieName = request.getParameter("movie");
        //adds a new movie to our static ad movie method whichs calls the non static addmovie method with the given movie name
        new GetAllMovies().AddMovieToAllMovies(new GetAllMovies().AddMovie(movieName));
        //echos info to the user
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + movieName + " Saved</h1>");
        out.println("</body></html>");
    }   
}