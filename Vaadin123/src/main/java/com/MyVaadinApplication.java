package com;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.sql.*;

public class MyVaadinApplication extends UI {
   static final String JDBC_DRIVER = "org.postgresql.Driver";
   static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/postgres";
   static final String USER = "postgres";
   static final String PASSWORD = "5099";
    @Override
    public  void init(VaadinRequest request) {
        VerticalLayout layout = new VerticalLayout();
        setContent(layout);
        Button button = new Button("adds a new line");
        layout.addComponent(button);
        button.addClickListener((Button.ClickListener) clickEvent -> {
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            String sql = "INSERT into  auto (id, model, year, carcase) VALUES (3, 'ford', 2015, 'sedan')";
            try (Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
                 Statement statement = connection.createStatement()) {
                statement.executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();

            }
        });
    }

}
