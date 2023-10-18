package webProject.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.Base64;

public class ImageServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Image file path
        File file = new File("C:/Users/35177/Desktop/upload/Maze1.png");
        FileInputStream fis = new FileInputStream(file);
        byte byteArray[] = new byte[(int)file.length()];
        fis.read(byteArray);
        
        // Converts to a Base64-encoded string
        String encoded = Base64.getEncoder().encodeToString(byteArray);

        // Returns a Base64-encoded string
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(encoded);
    }
}

