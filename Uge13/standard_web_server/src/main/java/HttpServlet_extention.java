import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.io.*;
import java.net.*;

@WebServlet(
        name = "HelloServlet",
        urlPatterns = "/api"
)

public class HttpServlet_extention extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.println("Hello");
        writer.close();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        String n , p;
        n = req.getParameter("username");
        p = req.getParameter("pwd");
        writer.println("Velkommen til systemet! før evaluering" +n+p);

        System.out.println("The name and password "+ n + "  " + p);
        if (Objects.equals(n, "philip") && Objects.equals(p, "123456")) {
            writer.println("Velkommen til systemet! efter evaluering");
            //resp.sendRedirect("welcome.html");
            /*try{
                FileInputStream fin = new FileInputStream("C:\\Users\\rwa\\IdeaProjects\\standard_web_server\\src\\main\\webapp\\index.html");
                int i=0;
                System.out.println("fin: " + fin.read());
                System.out.println("i=fin: " +(i=fin.read()));

                while((i=fin.read())!=-1){
                    System.out.print((char)i);
                }

                fin.close();
            }catch(Exception e){System.out.println(e);}*/

        }

        resp.addCookie(new Cookie("ehr","Johnny"));
    }
    }
