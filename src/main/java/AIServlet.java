import com.google.genai.Client;
import io.github.cdimascio.dotenv.Dotenv;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// [2]
@WebServlet("/ai") // localhost:8080/ai
// 이 서블릿을 통해 호출
public class AIServlet extends HttpServlet { // [1]
    // doGet, doPost

    // 경로에 들어갔을 때 (GET) -> 그 때 호출될 기능
    @Override // [3]
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Dotenv dotenv = Dotenv.load(); // [7]
        String apiKey = dotenv.get("GOOGLE_API_KEY");
        // [8] -> resources/.env
        Client client = Client.builder()
                .apiKey(apiKey).build(); // [9]

        req.setAttribute("data", "안녕하세요! 반갑습니다!"); // [6]

        RequestDispatcher dispatcher = req.getRequestDispatcher(
                "/WEB-INF/ai.jsp");
        dispatcher.forward(req, resp); // [4]
        // WEB-INF -> ai.jsp [5]
    }
}
