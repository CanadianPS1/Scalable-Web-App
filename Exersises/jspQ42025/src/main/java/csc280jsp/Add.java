package csc280jsp;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(name = "add", value = "/add")
public class Add extends HttpServlet{
    @Override
    @SuppressWarnings("UseSpecificCatch")
    //handles the get requests
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //for the get
        //declares all my url vars and my 2 number vars
        String num1String = request.getParameter("a");
        String num2String = request.getParameter("b");
        int num1, num2;
        //just incase they dont put a number into the url it wont crash but tell them
        try {
            //turns the url var into a number
            num1 = Integer.parseInt(num1String);
            num2 = Integer.parseInt(num2String);
            int answer;
            //looks for the assosiated opperation, and if none is found echos to the user so
            answer = num1 + num2;
            //response.getWriter().println(num1 + " + " + num2 + " = " + answer);
            request.setAttribute("result", answer);
            RequestDispatcher disp = request.getRequestDispatcher("results.jsp");
            disp.forward(request, response);
        //tells the user if they didnt input a number into the url
        }catch(Exception e){
            response.getWriter().println("ERROR: '" + num1String + "'  or '" + num2String + "'is not a valid Number");
        }
    }   
}