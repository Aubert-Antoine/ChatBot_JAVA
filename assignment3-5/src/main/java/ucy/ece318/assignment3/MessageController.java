package ucy.ece318.assignment3;
import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionChoice;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.completion.CompletionResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
public class MessageController {
    @Autowired
    private MessageRepository repository;
    final private String token = "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";

    final private boolean debug = true;
    CompletionRequest request = new CompletionRequest();;
    String model ="text-davinci-002";
    OpenAiService service = new OpenAiService(token); ;
    CompletionResult response;

    @GetMapping("/MessageList")
    public Iterable<Message> getMessages() {
        // change return null to something more appropriate
        return repository.findAll();
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

        Message messInput = new Message();

        //set date / type / id --> auto fill / txt

        // set the date
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        messInput.setMessageDate(dtf.format(now));
        messInput.setMessageType("Question");
        messInput.setMessageText(message);

        repository.save(messInput);

        /*
        request to openAI :
         */
        request.setPrompt(message);
        response = service.createCompletion(request);
        List<CompletionChoice> responses = response.getChoices();
        for(CompletionChoice c: responses){
            System.out.println(c.getText());
        }

        /*
        Make a mess for the response
         */
        Message messOutput = new Message();
        messOutput.setMessageType("Answer");
        messOutput.setMessageDate(dtf.format(LocalDateTime.now()));
        messOutput.setMessageText(responses.toString());

        if(debug) System.out.println(String.format("The message output of openAi is %s",messOutput.getMessageText()));

        repository.save(messOutput);

        return new RedirectView("");


    }
    @GetMapping("/deleteMessage")
    public RedirectView deleteMessage(@RequestParam Integer id) {
        // add code to delete message
        for (Message message: getMessages()) {
            if (debug) String.format("Liste des messages : %s", message.getMessageText());

            if (message.getId() == id) {
                repository.delete(message);
            }
        }

        return new RedirectView("");

    }

}