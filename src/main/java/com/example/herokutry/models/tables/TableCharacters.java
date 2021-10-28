package com.example.herokutry.models.tables;

import com.example.herokutry.models.entities.Character;

import java.sql.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Properties;

public class TableCharacters
{
  private String url;
  private String login;
  private String password;

  private Connection getConnection()
          throws SQLException
  {
    Properties props = new Properties(); props.setProperty("user", login); props.setProperty("password", password);
    props.setProperty("ssl", "false");

    return DriverManager.getConnection(url, props);
  }

  public TableCharacters(String url, String login, String password)
  {
    this.url = url; this.login = login; this.password = password;
  }

  public ArrayList<Character> getAll()
          throws Exception
  {
    Connection connection = null; try
  {


    connection = getConnection(); Statement statement = connection.createStatement();
    //statement.executeQuery("set search_path = \"characters\"");

    String query = String.format("SELECT * FROM chars"); ResultSet rs = statement.executeQuery(query);
    ArrayList<Character> characters = new ArrayList<Character>(); while (rs.next())
  {
    Character character = new Character(rs.getInt("id"), rs.getString("name"), rs.getDouble("rating"));
    characters.add(character);

  }  return characters;
  }
  catch (Exception e)
  {
    throw new Exception("Ошибка выборки данных из базы данных");
  }
  finally
  {
    connection.close();
  }

  }

  public Character getById(int id)
          throws Exception
  {
    Connection connection = null; try
  {
    connection = getConnection(); Statement statement = connection.createStatement();
    //statement.executeQuery("set search_path = \"characters\"")
    String query = "SELECT * FROM chars WHERE id=" + id;
    ResultSet rs = statement.executeQuery(query);
    ArrayList<Character> characters = new ArrayList<Character>();
    if (rs.next())
    {
      Character character = new Character(rs.getInt("id"), rs.getString("name"), rs.getDouble("rating"));
      characters.add(character);

    }
    else throw new Exception();

    return characters.get(0);
  }
  catch (Exception e)
  {
    throw new Exception("Ошибка получения персонажа по id из базы данных");
  }
  finally
  {
    connection.close();
  }

  }

  public void insertOne(Character character)
          throws Exception
  {
    Connection connection = null; try
  {

    connection = getConnection();

    Statement statement = connection.createStatement();
    //statement.executeQuery("set search_path = \"characters\"");

    String query = String.format(Locale.US, "insert into chars (name,rating) values ('%s','%f');", character.name, character.rating);
    statement.executeUpdate(query); connection.close();
  }
  catch (Exception e)
  {
    throw new Exception("Ошибка вставки в бвзу данных");
  }
  finally
  {
    connection.close();
  }
  }

  public void deleteById(int id)
          throws Exception
  {
    Connection connection = null; try
  {


    connection = getConnection(); Statement statement = connection.createStatement();
    //statement.executeQuery("set search_path = \"characters\"");

    String query = String.format("delete from chars where id=%d;", id); statement.executeUpdate(query);


  }
  catch (Exception e)
  {
    throw new Exception("Ошибка удаления персонажа");
  }
  finally
  {
    connection.close();
  }

  }

  public void updateById(int id, Character character)
          throws Exception
  {
    Connection connection = null; try
  {

    connection = getConnection();

    Statement statement = connection.createStatement();
    //statement.executeQuery("set search_path = \"characters\"");

    String query = String.format(Locale.US, "update chars set  name='%s',rating=%f where id=%d;", character.name, character.rating, id);
    statement.executeUpdate(query); connection.close();
  }
  catch (Exception e)
  {
    throw new Exception("Ошибка удаления персонажа");
  }
  finally
  {
    connection.close();
  }
  }

}

