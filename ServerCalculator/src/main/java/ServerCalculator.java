package ServerCalculator.src.main.java;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(name = "calc", value = "/calc")
public class ServerCalculator extends HttpServlet{
    @Override
    @SuppressWarnings("UseSpecificCatch")
    //handles the get requests
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //for the get
        //declares all my url vars and my 2 number vars
        String opperation = request.getParameter("opperation");
        String num1String = request.getParameter("num1String");
        String num2String = request.getParameter("num2String");
        int num1, num2;
        //just incase they dont put a number into the url it wont crash but tell them
        try {
            //turns the url var into a number
            num1 = Integer.parseInt(num1String);
            num2 = Integer.parseInt(num2String);
            int answer;
            //looks for the assosiated opperation, and if none is found echos to the user so
            if(opperation.equalsIgnoreCase("add")){
                answer = num1 + num2;
                response.getWriter().println(num1 + " + " + num2 + " = " + answer);
            }else if(opperation.equalsIgnoreCase("subtract")){
                answer = num1 - num2;
                response.getWriter().println(num1 + " - " + num2 + " = " + answer);
            }else if(opperation.equalsIgnoreCase("multiply")){
                answer = num1 * num2;
                response.getWriter().println(num1 + " * " + num2 + " = " + answer);
            }else if(opperation.equalsIgnoreCase("divide")){
                answer = num1 / num2;
                response.getWriter().println(num1 + " / " + num2 + " = " + answer);
            }else{
                response.getWriter().println("ERROR: '" + opperation + "' is not a valid opperation");
            }
        //tells the user if they didnt input a number into the url
        }catch(Exception e){
            response.getWriter().println("ERROR: '" + num1String + "'  or '" + num2String + "'is not a valid Number");
        }
    }   
}