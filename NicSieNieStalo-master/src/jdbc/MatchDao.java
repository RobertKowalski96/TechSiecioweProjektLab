package jdbc;

import model.Goal;
import model.Match;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MatchDao {
    private static final String URL = "jdbc:mysql://localhost:3306/nicsieniestao?useSSL=false";
    private static final String USER = "root";
    private static final String PASS = "Student140";
    private Connection connection;

    public MatchDao(){
        try {
            connection =  ConnectionProvider.getConnection();
        } catch (SQLException e) {
            System.out.println("Could not establish connection");
        }
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addMatch(Match match){
        final String query = "insert into matches(opponent, date) values(?, ?)";
        try {
            PreparedStatement preparedStatemet = connection.prepareStatement(query);
            preparedStatemet.setString(1, match.getOpponent());
            preparedStatemet.setString(2, match.getDate());
            preparedStatemet.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public long getMatchID(Match match){
        final String query = "select idmatch from matches where opponent = ? and date = ?";
        try {
            PreparedStatement preparedStatemet = connection.prepareStatement(query);
            preparedStatemet.setString(1, match.getOpponent());
            preparedStatemet.setString(2, match.getDate());
            ResultSet resultSet = preparedStatemet.executeQuery();
            if(resultSet.next()) {
               return resultSet.getLong("idmatch");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }


    public List<Match> getAllMatches(){
        final String query = "SELECT idmatch, opponent, date, \n" +
                "(SELECT COUNT(*) FROM goals where goals.idmatch=matches.idmatch and goals.isGood=1) AS goals,\n" +
                "(SELECT COUNT(*) FROM goals where goals.idmatch=matches.idmatch and goals.isGood=0) AS \"goals lost\"\n" +
                "From matches;";
        try {
            ResultSet resultSet = connection.prepareStatement(query).executeQuery();
            List<Match> matches = new ArrayList<>();
            while (resultSet.next()){
                Match match = new Match();
                match.setIdMatch(resultSet.getLong("idmatch"));
                match.setOpponent(resultSet.getString("opponent"));
                match.setDate(resultSet.getString("date"));
                match.setGoodGoals(resultSet.getInt("goals"));
                match.setBadGoals(resultSet.getInt("goals lost"));
                matches.add(match);
            }
            return matches;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
