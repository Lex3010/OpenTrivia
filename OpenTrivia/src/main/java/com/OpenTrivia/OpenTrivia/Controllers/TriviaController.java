package com.OpenTrivia.OpenTrivia.Controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.OpenTrivia.OpenTrivia.Model.Answer;
import com.OpenTrivia.OpenTrivia.Model.Trivia;
import com.OpenTrivia.OpenTrivia.Services.StringReplaceService;
import com.OpenTrivia.OpenTrivia.Services.TriviaService;
import com.OpenTrivia.OpenTrivia.Services.URLService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "http://localhost:4200/rest/trivia")
public class TriviaController {

  private final URLService urlService;
  private TriviaService triviaService;

  public TriviaController(URLService urlService, TriviaService triviaService) {
    this.urlService = urlService;
    this.triviaService = triviaService;
  }

  @GetMapping("/rest/trivia")
  public String getTrivia() throws IOException {
    Trivia trivia = new Trivia();

    StringBuffer response = urlService.getResponse();

    trivia = triviaService.createTriviaFromJsonString(response.toString());

    Gson gson = new Gson();
    String triviaJson = gson.toJson(trivia);

    return triviaJson;
  }
}
