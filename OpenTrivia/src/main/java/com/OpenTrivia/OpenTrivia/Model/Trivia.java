package com.OpenTrivia.OpenTrivia.Model;

import com.google.gson.annotations.Expose;

public class Trivia {

  @Expose
  private String category;

  @Expose
  private String type;

  @Expose
  private String difficulty;

  @Expose
  private String question;

  @Expose
  private String correctAnswer;

  @Expose
  private String[] incorrectAnswers;

  @Expose
  private String[] answers;

  public Trivia() {
  }

  public Trivia(String category, String type, String difficulty, String question, String correctAnswer,
      String[] incorrectAnswers) {
    this.category = category;
    this.type = type;
    this.difficulty = difficulty;
    this.question = question;
    this.correctAnswer = correctAnswer;
    this.incorrectAnswers = incorrectAnswers;
  }

  public Trivia(String category, String type, String difficulty, String question, String[] answers) {
    this.category = category;
    this.type = type;
    this.difficulty = difficulty;
    this.question = question;
    this.answers = answers;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getDifficulty() {
    return difficulty;
  }

  public void setDifficulty(String difficulty) {
    this.difficulty = difficulty;
  }

  public String getQuestion() {
    return question;
  }

  public void setQuestion(String question) {
    this.question = question;
  }

  public String getCorrectAnswer() {
    return correctAnswer;
  }

  public void setCorrectAnswer(String correctAnswer) {
    this.correctAnswer = correctAnswer;
  }

  public String[] getIncorrectAnswer() {
    return incorrectAnswers;
  }

  public void setIncorrectAnswer(String[] incorrectAnswers) {
    this.incorrectAnswers = incorrectAnswers;
  }

  public String[] getAnswers() {
    return incorrectAnswers;
  }

  public void setAnswers(String[] answers) {
    this.answers = answers;
  }
}
