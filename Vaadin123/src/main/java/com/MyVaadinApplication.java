package com;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MyVaadinApplication extends UI {
    @Override
    public void init(VaadinRequest request) {
         VerticalLayout layout = new VerticalLayout();

         setContent(layout);
        layout.addComponent(new Label("Hello, World!"));
    }
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
}
