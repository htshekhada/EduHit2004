import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;
import java.util.*;


public class Dispresult extends HttpServlet
{
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
             
    {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();

      HttpSession session = request.getSession(true);      
      String userid = (String) session.getValue("userid");
      String password=(String) session.getValue("password");
       

      if((userid==null) || (password==null))
         {
          response.sendRedirect("/servlet/Login");
          return;
         }


              out.println("<html>");    
              out.println("<head>");
              out.println("<title>EducationHIT by H.T.Shekhada</title>");
              out.println("</head>");
        
              


      out.println("<body bgcolor=\"rgb(211,255,213)\">");
             
           
              out.println("<center><font face=\"Times New Roman\" size=4 >Section For The Reports Of Different Types Of Result</font></center>");
              out.println("<br>");

              out.println("<center>");

              out.println("<form method=\"get\" action=\"http://"+request.getServerName()+":8080/servlet/Dispscs\" >");
              out.println("<input  type=\"submit\" value=\" Subject Result Of Entire Standard \" name=\"start\" style=\"font-family: Times New Roman; font-size: 18pt\">");

              out.println("</form>");

                out.println("</center>");
            
        //      out.println("<br>");

              out.println("<center>");

              out.println("<form method=\"get\" action=\"http://"+request.getServerName()+":8080/servlet/Dispres\" >");
              out.println("<input  type=\"submit\" value=\"       Result Of Particular Exam       \" name=\"start\" style=\"font-family: Times New Roman; font-size: 18pt\">");

              out.println("</form>");

                out.println("</center>");


              out.println("<center>");
     //         out.println("<br>");

              out.println("<form method=\"get\" action=\"http://"+request.getServerName()+":8080/servlet/Fresult1\">");
              out.println("<input  type=\"submit\" value=\"    Yearly Result Of One Student     \" name=\"start\" style=\"font-family: Times New Roman; font-size: 18pt\">");
              out.println("</form>");
  

//              out.println("<br><br><br>");
           
//              out.println("<center>");

//              out.println("<a href=\"http://"+request.getServerName()+":8080/servlet/Dispsc\" >");
//              out.println("Class vise Result");
//              out.println("</a>");

//                out.println("</center>");

        


              out.println("</center>");

    //          out.println("<br>");
           
              out.println("<center>");

              out.println("<form method=\"get\" action=\"http://"+request.getServerName()+":8080/servlet/Dispgen\" >");
              out.println("<input  type=\"submit\" value=\"  Yearly Result Of Entire Standard  \" name=\"start\" style=\"font-family: Times New Roman; font-size: 18pt\">");

              out.println("</form>");

                out.println("</center>");


    //          out.println("<br>");
           
              out.println("<center>");

              out.println("<form method=\"get\" action=\"http://"+request.getServerName()+":8080/servlet/Dispcla1\" >");
              out.println("<input  type=\"submit\" value=\"Progress Report Of Entire Standard\" name=\"start\" style=\"font-family: Times New Roman; font-size: 18pt\">");
              out.println("</form>");

                out.println("</center>");



            
              out.println("</body>");
              out.println("</html>");
        } 

     }
