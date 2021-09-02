package com.OpenTrivia.OpenTrivia.Controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.OpenTrivia.OpenTrivia.Model.Trivia;
import com.OpenTrivia.OpenTrivia.Services.StringReplaceService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200/trivia")
public class TriviaController {

  @GetMapping("/trivia")
  public String getTrivia() throws IOException {
    URL url;
    StringBuffer response;
    Trivia trivia = new Trivia();

    url = new URL("https://opentdb.com/api.php?amount=1");
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("GET");
    int responseCode = connection.getResponseCode();
    if (responseCode == HttpURLConnection.HTTP_OK) {
      BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      String inputLine;
      response = new StringBuffer();

      while ((inputLine = in.readLine()) != null) {
        response.append(inputLine);
      }
      in.close();

      trivia = createTrivia(response.toString());

    }

    Gson gson = new Gson();
    String triviaJson = gson.toJson(trivia);

    return triviaJson;
  }

  private Trivia createTrivia(String response) {

    JsonArray jsonArray = new JsonParser().parse(response).getAsJsonObject().getAsJsonArray("results");

    String jsonString = jsonArray.get(0).toString();
    String usefullString = StringReplaceService.replaceUnderscoresAndUppercaseNextLetter(jsonString);
    Gson gson = new Gson();

    Trivia trivia = gson.fromJson(usefullString, Trivia.class);

    return trivia;
  }
}
