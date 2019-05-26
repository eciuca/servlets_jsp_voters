package com.sda.grupa5.servlet.votare;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet(urlPatterns = "/")
public class VotingServlet extends HttpServlet {

    private final VotingService votingService;

    public VotingServlet() {
        votingService = VotingService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Person> voters = votingService.getVotersList();
        PrintWriter out = resp.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Voters list</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<ul>");
        for (Person voter : voters) {
            out.println("<li>" + voter.getFirstName() + " " + voter.getLastName() + "</li>");
        }
        out.println("</ul>");
        out.println("</body>");
        out.println("</html>");
    }


}
