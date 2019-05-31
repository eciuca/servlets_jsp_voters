package com.sda.grupa5.servlet.votare.controller;

import com.sda.grupa5.servlet.votare.service.VotingService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/jsp/create")
public class CreateVoter extends HttpServlet {

    private final VotingService votingService;

    public CreateVoter() {
        votingService = VotingService.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        votingService.addVoter(firstName, lastName);

        resp.sendRedirect(req.getContextPath() + "/jsp");
    }

}
