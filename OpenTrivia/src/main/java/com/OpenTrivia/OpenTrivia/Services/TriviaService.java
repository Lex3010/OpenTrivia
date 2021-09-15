package com.OpenTrivia.OpenTrivia.Services;

import com.OpenTrivia.OpenTrivia.Model.Answer;

import com.OpenTrivia.OpenTrivia.Model.Trivia;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class TriviaService {

  private static final Map<Integer, String> triviaAnswerMap = new HashMap<>();

  public String getCorrectAnswer(long id, String answer) {
    return triviaAnswerMap.getOrDefault(id, answer);
  }

  public Trivia createTriviaFromJsonString(String response) {
    JsonArray jsonArray = new JsonParser().parse(response).getAsJsonObject().getAsJsonArray("results");

    String jsonString = jsonArray.get(0).toString();

    String usefullString = StringReplaceService.replaceUnderscoresAndUppercaseNextLetter(jsonString);

    Gson gson = new Gson();

    Trivia trivia = gson.fromJson(usefullString, Trivia.class);

    // Iterate over possible answers, so later on you can combine all wrong answers
    // with the correct ons
    ArrayList<String> answers = new ArrayList<String>();
    for (String answer : trivia.getIncorrectAnswer()) {
      answers.add(answer);
    }

    // Add correct answer
    answers.add(trivia.getCorrectAnswer());

    triviaAnswerMap.put(1, trivia.getCorrectAnswer());

    // Answer correctAnswer = new Answer(trivia.getCorrectAnswer());

    // create Trivia with all answers combined
    Trivia combinedAnswersTrivia = new Trivia(trivia.getCategory(), trivia.getType(), trivia.getDifficulty(),
        trivia.getQuestion(), answers.toArray(new String[0]));

    return combinedAnswersTrivia;
  }

}
