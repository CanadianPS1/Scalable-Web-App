package movieReview;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

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
        //file io
        //implement file io stuff
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(new File("C:\\Users\\spiel\\Documents\\GitHub\\Scalable-Web-App\\MovieReviews\\src\\main\\java\\movieReview\\movies.json"));
        for(int i = 0; i < jsonNode.size(); i++){
            GetAllMovies movieGetter = new GetAllMovies().MovieGetter(i + 1);;
            movieList.add(movieGetter);
        }
        for(int i = 0; i < movieList.size(); i++){
            if(movieList.get(i).getName().contains(search)){
                PrintWriter out = response.getWriter();
                out.println("<form method=\"POST\" action=\"/subtract");
                out.println("<input type=\"submit\" value=\" " + movieList.get(i) + "\"/>");
                out.println("</body></html>");
            }
        }

        
    }   
}