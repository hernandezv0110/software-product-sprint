package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String[] placesIveLived = {"El Loreto, Jalisco", "La Barca, Jalisco", "Santa Ana, California", "Belmont, California", "San Mateo, California", "Irvine, California"};
    String json = convertToJsonUsingGson(placesIveLived);

    response.setContentType("application/json;");
    response.getWriter().println(json);
    
  }

  private String convertToJsonUsingGson(String[] placesList) {
    Gson gson = new Gson();
    String json = gson.toJson(placesList);
    return json;
  }

}
