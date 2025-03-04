package milbot;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.application.Platform;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Controller for MainWindow. Provides the layout for the other controls.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Mil mil;

    private Timer exitTimer;

    private Image user = new Image(this.getClass().getResourceAsStream("/images/user.png"));
    private Image chatbot = new Image(this.getClass().getResourceAsStream("/images/chatbot.png"));

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
        String welcomeMessage = "Hi there, I'm Mil - your personal chatbot.\n How can I help you today?";
        dialogContainer.getChildren().add(DialogBox.getDukeDialog(welcomeMessage, chatbot));
    }

    public void setMil(Mil m) {
        mil = m;
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Duke's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        assert input != null : "User input should not be null";
        String response = mil.getResponse(input);
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, user),
                DialogBox.getDukeDialog(response, chatbot)
        );
        userInput.clear();

        if (response.equals("Have a nice day and see you again soon!")) {
            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(2000);
                    Platform.runLater(() -> {
                        Platform.exit();
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            Platform.runLater(() -> { thread.start();
            });
        }

    }
}

