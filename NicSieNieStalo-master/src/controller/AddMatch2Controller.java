package controller;

import jdbc.GoalDao;
import model.Goal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.SysexMessage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/addMatch2")
public class AddMatch2Controller extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GoalDao goalDao = new GoalDao();
        String shooter;
        int minute;

        int goodGoals = Integer.valueOf(req.getParameter("goodGoals"));
        int badGoals = Integer.valueOf(req.getParameter("badGoals"));
        long idmatch = Long.valueOf(req.getParameter("idmatch"));

        for (int i = 0; i < goodGoals; i++){
            shooter = req.getParameter("goodGoalShooter"+i);
            minute = Integer.valueOf(req.getParameter("goodGoalTime"+i));
            Goal goal = new Goal(shooter, minute, idmatch);
            goal.setGood(true);
            goalDao.addGoal(goal);
        }
        for (int i = 0; i < badGoals; i++){
            shooter = req.getParameter("badGoalShooter"+i);
            minute = Integer.valueOf(req.getParameter("badGoalTime"+i));
            Goal goal = new Goal(shooter, minute, idmatch);
            goal.setGood(false);
            goalDao.addGoal(goal);
        }

        resp.sendRedirect("index.jsp");

    }
}
