@WebServlet("/hello")
public class SimpleHelloServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException {
        res.getWriter().write("Hello Servlet");
    }
}
