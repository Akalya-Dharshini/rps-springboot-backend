package com.example.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class RpsController {

    @GetMapping("/play")
    public ResponseEntity<Map<String, String>> play(@RequestParam int userChoice) {
        String[] choices = {"rock", "paper", "scissors"};
        String playerChoice = choices[userChoice];
        String computerChoice = choices[new Random().nextInt(3)];

        String result;
        if (playerChoice.equals(computerChoice)) {
            result = "TIE";
        } else if ((playerChoice.equals("rock") && computerChoice.equals("scissors")) ||
                   (playerChoice.equals("paper") && computerChoice.equals("rock")) ||
                   (playerChoice.equals("scissors") && computerChoice.equals("paper"))) {
            result = "WIN";
        } else {
            result = "LOSE";
        }

        Map<String, String> response = new HashMap<>();
        response.put("player", playerChoice);
        response.put("computer", computerChoice);
        response.put("result", result);
        response.put("message", String.format("You choose %s. Computer choose %s. Result: %s!", 
                                               playerChoice, computerChoice, result));

        return ResponseEntity.ok(response);
    }
}
