package com.OpenTrivia.OpenTrivia.Controllers;

import java.util.Map;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.OpenTrivia.OpenTrivia.Services.TriviaService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200/checkanswer")
public class CheckAnswerController {

  private final TriviaService service;

  public CheckAnswerController(TriviaService service) {
    this.service = service;
  }

  @PostMapping("/checkanswer")
  public Response checkAnswer(@RequestBody Map<String, Integer> map) {
    System.out.println("Hij komt aan!");
    return Response.serverError().build();

  }

}
