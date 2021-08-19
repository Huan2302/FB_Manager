package com.FB.Dao;

import com.FB.mapper.RowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AbstractDao<T> {
    ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
    public Connection getConnection(){
        try {
            Class.forName(resourceBundle.getString("driverName"));
            String url = resourceBundle.getString("url");
            String user = resourceBundle.getString("user");
            String password = resourceBundle.getString("password");
            return DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
        List<T> results = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try{
            connection = getConnection();
            statement =connection.prepareStatement(sql);
            //set parametter
            setParameter(statement,parameters);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                results.add(rowMapper.mapRow(resultSet));
            }
            return results;
        }catch (SQLException e){
            return null;
        } finally {
            try{
                if (connection != null){
                    connection.close();
                }
                if (statement != null){
                    statement.close();
                }
                if (resultSet != null){
                    resultSet.close();
                }
            }catch (SQLException e){
                return null;
            }
        }
    }

    public int delete(String sql, Object... parameters) {
        Connection connection = null;
          PreparedStatement statement = null;
        int resultSet = 0;
        try{
            connection = getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql);
            setParameter(statement,parameters);
            resultSet = statement.executeUpdate();
            connection.commit();
            return resultSet;
        }catch (SQLException e){
            if(connection != null){
                try {
                    connection.rollback();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }finally {
            try{
                if (connection != null){
                    connection.close();
                }
                if (statement != null){
                    statement.close();
                }
            }catch (SQLException e2){
                return 0;
            }
        }
        return 0;
    }

    public int count(String sql, Object... parameters) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            int count = 0;
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            setParameter(statement, parameters);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                count = resultSet.getInt(1);
            }
            return count;
        } catch (SQLException e) {
            return 0;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                return 0;
            }
        }
    }

    public Long insert(String sql, Object... parameters) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try{
            Long id = null;
            connection = getConnection();
            //kiểm soát trạng thái giao dịch(transaction)
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //set parameter
            setParameter(statement,parameters);
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if(resultSet.next()){
                id = resultSet.getLong(1);
            }
            connection.commit();
            return id;
        }catch (SQLException e){
            if(connection != null){
                try {
                    connection.rollback();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }finally {
            try{
                if (connection != null){
                    connection.close();
                }
                if (statement != null){
                    statement.close();
                }
                if(resultSet != null){
                    resultSet.close();
                }
            }catch (SQLException e2){
                return null;
            }
        }
        return null;
    }

    public void update(String sql, Object... paremeters) {
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql);
            setParameter(statement, paremeters);
            statement.executeUpdate();
            connection.commit();
        }catch (SQLException e){
            if(connection != null){
                try {
                    connection.rollback();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }finally {
            try{
                if(connection != null){
                    connection.close();
                }
                if(statement != null){
                    statement.close();
                }
            }catch (SQLException e1){
                e1.printStackTrace();
            }
        }
    }

    private void setParameter(PreparedStatement statement, Object... parameters) {
        try{
            for (int i = 0;i < parameters.length;i++){
                Object parameter = parameters[i];
                int index = i + 1;
                if(parameter instanceof Long){
                    statement.setLong(index,(Long) parameter);
                }else if(parameter instanceof String){
                    statement.setString(index,(String) parameter);
                }
                else if(parameter instanceof Timestamp){
                    statement.setTimestamp(index,(Timestamp) parameter);
                }else if(parameter instanceof Integer){
                    statement.setInt(index,(Integer) parameter);
                }
                else if(parameter == null){
                    statement.setNull(index, Types.NULL);
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
