package controller;

import java.io.File;

import javafx.scene.paint.Color;

public interface FrontEndControllerInterface {
	public void setPenColor(Color c);

	public void setBackgroundColor(Color black);

	public void setLanguage(String string);

	public Color getPenColor();

	public Color getBackgroundColor();

	public void setTurtleImage(File file);
}
