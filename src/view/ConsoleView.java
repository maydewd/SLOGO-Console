package view;

import controller.ConsoleController;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import model.IAdvancedModel;


import java.io.Console;

/**
 * Created by Tim on 22/02/16.
 */
public class ConsoleView extends BaseUIView {

	public static final int DEFAULT_WIDTH = 500;
	public static final int DEFAULT_HEIGHT = 100;

	private Pane uiPane;
	private TextArea commandField;
	private ConsoleController consoleController;


	public ConsoleView(IAdvancedModel model) {
		super(DEFAULT_WIDTH, DEFAULT_HEIGHT, model);

		uiPane = new Pane();
		this.setNode(uiPane);
		commandField = new TextArea();
		commandField.setPrefSize(getWidth(), getHeight());

		uiPane.setPrefSize(getWidth(), getHeight());

		uiPane.getChildren().add(commandField);
		commandField.setOnKeyPressed(event -> {
			if (event.getCode().equals(KeyCode.ENTER)) {
				if(!event.isShiftDown()){
					consoleController.executeCommand(commandField.getText()
					);
					commandField.clear();
					commandField.setEditable(false);
				} else {
					// Shift + Enter for multiline commands
					commandField.appendText("\n");
				}
			}
		});

		// Solves an extra enter keypress after keypress returns
		commandField.setOnKeyReleased(event -> {
			commandField.setEditable(true);
		});

		// Initialize Controller singleton
		ConsoleController.initController(model, this);
		consoleController = ConsoleController.getController();
	}
}
