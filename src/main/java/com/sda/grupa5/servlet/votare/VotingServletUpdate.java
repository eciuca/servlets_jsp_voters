package com.sda.grupa5.servlet.votare;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/jsp/update")
public class VotingServletUpdate extends HttpServlet {

    private final VotingService votingService;

    public VotingServletUpdate() {
        votingService = VotingService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/update_voter.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer voterIndex = Integer.parseInt(req.getParameter("voterIndex"));
        String voterLastName = req.getParameter("voterLastName");
        String voterFirstName = req.getParameter("voterFirstName");

        votingService.updateVoter(voterIndex, voterFirstName, voterLastName);

        resp.sendRedirect(req.getContextPath() + "/jsp");
    }

}
