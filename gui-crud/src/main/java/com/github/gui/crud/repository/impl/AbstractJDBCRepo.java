package com.github.gui.crud.repository.impl;

import com.github.gui.crud.entity.Person;
import com.github.gui.crud.exceptions.CrudException;
import com.github.gui.crud.repository.IPeopleRepo;
import com.github.gui.crud.utils.JDBCConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractJDBCRepo implements IPeopleRepo {

    private JDBCConnectionPool pool;

    public AbstractJDBCRepo(JDBCConnectionPool pool) {
        this.pool = pool;
    }

    @Override
    public Person save(Person p) {
        long id = 0;
        Connection connection = this.pool.connection();
        String sql = "INSERT INTO people (id, first_name, last_name, age, city) VALUES(?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setLong(1, p.getId());
            statement.setString(2, p.getFirstName());
            statement.setString(3, p.getLastName());
            statement.setInt(4, p.getAge());
            statement.setString(5, p.getCity());
            int row = statement.executeUpdate();
            if (row != 0) {
                ResultSet resultSet = statement.getGeneratedKeys();
                resultSet.next();
                id = resultSet.getLong(1);
            }
        } catch (SQLException e) {
            throw new CrudException(e.getMessage());
        } finally {
            this.pool.parking(connection);
        }
        return p.id(id);
    }

    @Override
    public List<Person> findAll() {
        List<Person> result = new ArrayList<>();
        Connection connection = this.pool.connection();
        String sql = "SELECT * FROM people";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Person p = new Person(
                        resultSet.getLong("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getInt("age"),
                        resultSet.getString("city")
                );
                result.add(p);
            }
        } catch (SQLException e) {
            throw new CrudException(e.getMessage());
        } finally {
            this.pool.parking(connection);
        }

        return result.stream()
                .sorted(Comparator.comparingLong(Person::getId))
                .collect(Collectors.toList());
    }

    @Override
    public void update(long id, Person p) {
        Connection connection = this.pool.connection();
        String sql = "UPDATE people SET first_name = ?, last_name = ?, age = ?, city = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, p.getFirstName());
            statement.setString(2, p.getLastName());
            statement.setInt(3, p.getAge());
            statement.setString(4, p.getCity());
            statement.setLong(5, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new CrudException(e.getMessage());
        } finally {
            this.pool.parking(connection);
        }
    }

    @Override
    public void remove(long id) {
        Connection connection = this.pool.connection();
        String sql = "DELETE FROM people WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new CrudException(e.getMessage());
        } finally {
            this.pool.parking(connection);
        }
    }
}
