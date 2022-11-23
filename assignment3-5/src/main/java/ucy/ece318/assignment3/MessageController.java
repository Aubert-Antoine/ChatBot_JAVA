package ucy.ece318.assignment3;
import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.completion.CompletionResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class MessageController {
    @Autowired
    private MessageRepository repository;
    private String token = "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";
    CompletionRequest request;
    String model ="text-davinci-002";
    OpenAiService service;
    CompletionResult response;
    @GetMapping("/MessageList")
    public Iterable<Message> getMessages() {
        // change return null to something more appropriate
        return null;
    }
    @GetMapping("/addMessageandResponse")
    public RedirectView addMessageandResponse(@RequestParam final String message) {
      /*
      1. You need to create a message object and save it into the repository
      2. Make an api request to OpenAI with the message’s text and receive the answer.
      3. Create a new message object with the AI response and save it to the  repository.

        Remember, that you need to set the type  of the message as “Question”
        for the message of the user and “Answer”

       */

        return new RedirectView("");


    }
    @GetMapping("/deleteMessage")
    public RedirectView deleteMessage(@RequestParam Integer id) {
        // add code to delete message
        getMessages();
        return new RedirectView("");

    }

}