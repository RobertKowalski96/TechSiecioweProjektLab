package controller;

import jdbc.MatchDao;
import model.Match;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/summary")
public class SummaryController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MatchDao matchDao = new MatchDao();
        List<Match> matches = matchDao.getAllMatches();
//        matchDao.close();

        req.setAttribute("matches", matches);
        req.getRequestDispatcher("summary.jsp").forward(req, resp);
    }
}
