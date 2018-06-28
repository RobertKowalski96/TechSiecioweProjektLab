package controller;

import jdbc.GoalDao;
import model.Goal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/matchDetails")
public class MatchDetailsController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("id").isEmpty()) {
            resp.sendRedirect("noTeam.jsp");
        } else {
            long id = Long.valueOf(req.getParameter("id"));

            GoalDao goalDao = new GoalDao();
            List<Goal> goals = goalDao.getMatchGoals(id);

            req.setAttribute("goals", goals);
            req.getRequestDispatcher("matchDetails.jsp").forward(req, resp);
        }
    }
}
