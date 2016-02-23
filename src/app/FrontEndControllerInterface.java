package app;

import javafx.scene.paint.Color;

public interface FrontEndControllerInterface {
	public Object setPenColor(Color c);

	public Object setBackgroundColor(Color black);

	public Object setLanguage(String string);

	public Color getPenColor();

	public Color getBackgroundColor();
}
