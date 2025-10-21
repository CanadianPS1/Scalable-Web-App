package movieReview;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.io.IOException;
public class GetAllMovies {
    private String name;
    private String reviews;
    public GetAllMovies MovieGetter(int location) throws IOException{
        /*ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(new File("mydata.json"));
        String name = jsonNode.get("name").asText();
        int age = jsonNode.get("age").asInt();
        String city = jsonNode.get("city").asText();
        String state = jsonNode.get("state").asText();
        String country = jsonNode.get("country").asText(); */
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(new File("movies.json"));
        if(jsonNode.size() <= location){
            JsonNode item = jsonNode.get(location - 1);
            name = item.get("name").asText();
            reviews = item.get("reviews").asText();
        }
        return null;
    }
    //https://www.geeksforgeeks.org/java/how-to-read-and-write-json-files-in-java/
    public GetAllMovies AddMovie(String name) throws StreamWriteException, DatabindException, IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode jsonNode = objectMapper.createObjectNode();
        jsonNode.put("name", name);
        jsonNode.put("reviews", "");
        objectMapper.writeValue(new File("movies.json"), jsonNode);
        return null;
    }
    public String getName(){
        return name;
    }
    public String getReviews(){
        return reviews;
    }
    public void setName(String n){
        name = n;
    }
    public void setReviews(String r){
        reviews = r;
    }
}
