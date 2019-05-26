package com.sda.grupa5.servlet.votare;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/jsp")
public class VotingServletWithJsp extends HttpServlet {

    private final VotingService votingService;

    public VotingServletWithJsp() {
        votingService = VotingService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Person> voters = votingService.getVotersList();

        req.setAttribute("voters", voters);

        getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/voters.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        votingService.addVoter(firstName, lastName);

        resp.sendRedirect(req.getContextPath() + "/jsp");
    }

}
