package com.OpenTrivia.OpenTrivia.Services;

public class StringReplaceService {

  public static String replaceUnderscoresAndUppercaseNextLetter(String string) {
    if (string.contains("_")) {
      StringBuffer s = new StringBuffer(string);
      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == '_') {
          s.setCharAt(i, Character.toUpperCase(s.charAt(i + 1)));
          s.deleteCharAt(i + 1);
          string = s.toString();
        }
      }

      System.out.println(s);
    }
    String freshString = string.replaceAll("_", "");
    return freshString;
  }
}
