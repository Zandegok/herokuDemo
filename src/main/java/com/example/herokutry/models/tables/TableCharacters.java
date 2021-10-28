package com.example.herokutry.models.tables;

import com.example.herokutry.models.entities.Character;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Properties;

public interface TableCharacters extends JpaRepository<Character,Integer>
{

}

