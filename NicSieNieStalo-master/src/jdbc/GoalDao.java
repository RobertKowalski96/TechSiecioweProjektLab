package jdbc;

import model.Goal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GoalDao {
    private static final String URL = "jdbc:mysql://localhost:3306/nicsieniestao?useSSL=false";
    private static final String USER = "root";
    private static final String PASS = "Student140";
    private Connection connection;

    public GoalDao(){
        try {

            connection = ConnectionProvider.getConnection();
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

    public void addGoal(Goal goal){
        final String query = "insert into goals(minute, shooter, idmatch, isgood) values(?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatemet = connection.prepareStatement(query);
            preparedStatemet.setInt(1, goal.getMinute());
            preparedStatemet.setString(2, goal.getShooter());
            preparedStatemet.setLong(3, goal.getIdMatch());
            if (goal.isGood()){
                preparedStatemet.setLong(4,1);}
            else{
                preparedStatemet.setLong(4,0);}
            preparedStatemet.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Goal> getMatchGoals(long id){
        final String query = "SELECT * FROM goals where idmatch=?;";
        try {
            List<Goal> goals = new ArrayList<>();
            PreparedStatement preparedStatemet = connection.prepareStatement(query);
            preparedStatemet.setLong(1,id);
            ResultSet resultSet = preparedStatemet.executeQuery();

            while (resultSet.next()){
                Goal goal = new Goal();
                goal.setIdGoal(resultSet.getLong("idgoal"));
                goal.setMinute(resultSet.getInt("minute"));
                goal.setShooter(resultSet.getString("shooter"));
                goal.setGood(resultSet.getBoolean("isGood"));
                goals.add(goal);
            }
            return goals;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}


