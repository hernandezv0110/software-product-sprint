package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;

@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    // Get the value entered in the form.
    String textValue = request.getParameter("text-input");
    String nameValue = request.getParameter("name-input");

    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("User Contact-Info");

    FullEntity taskEntity =
        Entity.newBuilder(keyFactory.newKey())
            .set("Name", nameValue)
            .set("Email", textValue)
            .build();
    datastore.put(taskEntity);

    // Print the value so you can see it in the server logs.
    System.out.println("You submitted: " + nameValue + ", " + textValue);

    // Write the value to the response so the user can see it.
    response.getWriter().println("You submitted: " + nameValue + ", " + textValue);
    response.sendRedirect("https://vhernandez-sps-summer22.appspot.com/");
  }
}