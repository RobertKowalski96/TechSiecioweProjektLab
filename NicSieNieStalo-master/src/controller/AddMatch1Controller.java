package controller;

import jdbc.MatchDao;
import model.Match;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/addMatch1")
public class AddMatch1Controller extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String opponent, date;
        int goodGoals, badGoals;

        opponent = req.getParameter("opponent");
        date = req.getParameter("date");
        goodGoals = Integer.valueOf(req.getParameter("goodGoals"));
        badGoals = Integer.valueOf(req.getParameter("badGoals"));




        Match match = new Match(opponent, date);
        MatchDao matchDao = new MatchDao();

        //adding match to database
        matchDao.addMatch(match);
        req.setAttribute("idmatch", matchDao.getMatchID(match));
        req.setAttribute("match", match);
        req.setAttribute("goodGoals", goodGoals);
        req.setAttribute("badGoals", badGoals);
        req.getRequestDispatcher("addMatch2.jsp").forward(req, resp);

    }
}
