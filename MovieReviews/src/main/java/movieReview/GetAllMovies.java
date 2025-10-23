package movieReview;

// import java.io.File;
// import java.io.IOException;
// import java.io.InputStream;
// import com.fasterxml.jackson.core.exc.StreamWriteException;
// import com.fasterxml.jackson.databind.DatabindException;
// import com.fasterxml.jackson.databind.JsonNode;
// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
public class GetAllMovies {
    //declares all my vars
    private String name;
    private ArrayList<String> reviews = new ArrayList<>();
    private static ArrayList<Object> movies = new ArrayList<>();
    //adds to my static list of movies
    public static void AddMovieToAllMovies(Object movie){
        movies.add(movie);
    }
    //will return the list of all movie vars
    @SuppressWarnings("rawtypes")
    public static ArrayList GetAllMoviesList(){
        return movies;
    }
    //creates a new movie instence with a set name
    public GetAllMovies AddMovie(String n){
        name = n;
        return this;
    }
    //adds to the reviews list with the given review
    public void AddReview(String r){
        reviews.add(r);
    }
    //returns back the reviews list
    @SuppressWarnings("rawtypes")
    public ArrayList getReviews(){
        return reviews;
    }
    //returns the movies name
    public String getName(){
        return name;
    }
    //private final int size = 0;
   
    //public GetAllMovies(int location) throws IOException{
        /*ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(new File("mydata.json"));
        String name = jsonNode.get("name").asText();
        int age = jsonNode.get("age").asInt();
        String city = jsonNode.get("city").asText();
        String state = jsonNode.get("state").asText();
        String country = jsonNode.get("country").asText(); */
        // ObjectMapper objectMapper = new ObjectMapper();
        // InputStream inputStream = getClass().getResourceAsStream("/movies.json");
        // JsonNode jsonNode = objectMapper.readTree(inputStream);
        // size = jsonNode.size();
        // if(jsonNode.size() >= location){
        //     JsonNode item = jsonNode.get(location - 1);
        //     name = item.get("name").asText();
        //     reviews = item.get("reviews").asText();
        // }
    //}
    //https://www.geeksforgeeks.org/java/how-to-read-and-write-json-files-in-java/
    // public void AddMovie(String name) throws StreamWriteException, DatabindException, IOException{
    //     ObjectMapper objectMapper = new ObjectMapper(); 
    //     ObjectNode jsonNode = objectMapper.createObjectNode(); 
    //     jsonNode.put("name", name); 
    //     jsonNode.put("reviews", ""); 
    //     objectMapper.writeValue(new File("/movies.json"), jsonNode);
    // }
    // public int getSize(){
    //     return size;
    // }
    // public String getName(){
    //     return name;
    // }
    // public String getReviews(){
    //     return reviews;
    // }
    // public void setName(String n){
    //     name = n;
    // }
    // public void setReviews(String r){
    //     reviews = r;
    // }
}
