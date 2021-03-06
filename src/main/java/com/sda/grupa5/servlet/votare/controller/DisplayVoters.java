package com.sda.grupa5.servlet.votare.controller;

import com.sda.grupa5.servlet.votare.model.Person;
import com.sda.grupa5.servlet.votare.service.VotingService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/jsp")
public class DisplayVoters extends HttpServlet {

    private final VotingService votingService;

    public DisplayVoters() {
        votingService = VotingService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Person> voters = votingService.getVotersList();

        req.setAttribute("voters", voters);

        getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/voters.jsp")
                .forward(req, resp);
    }

}
