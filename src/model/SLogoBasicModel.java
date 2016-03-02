package model;

import java.util.List;
import java.util.Map;
import java.util.Observer;
import controller.commands.AbstractExpressionNode;
import javafx.beans.property.ListProperty;
import javafx.beans.property.MapProperty;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyListProperty;


public class SLogoBasicModel implements IBasicModel {

    BasicTurtleModel myTurtleModel = new BasicTurtleModel();
    BasicOptionsModel myOptionsModel = new BasicOptionsModel();

    @Override
    public void moveTurtleForward (double pixels) {
        getMyTurtleModel().moveTurtleForward(pixels);
    }

    @Override
    public void setTurtleCoordinates (Point newPoint) {
        getMyTurtleModel().setTurtleCoordinates(newPoint);
    }

    @Override
    public Point getTurtleCoordinates () {
        return getMyTurtleModel().getTurtleCoordinates();
    }

    @Override
    public double getTurtleHeading () {
        return getMyTurtleModel().getTurtleHeading();
    }

    @Override
    public void setTurtleHeading (double heading) {
        getMyTurtleModel().setTurtleHeading(heading);
    }

    @Override
    public void setPenDown (boolean penDown) {
        getMyTurtleModel().setPenDown(penDown);
    }

    @Override
    public boolean getPenDown () {
        return getMyTurtleModel().getPenDown();
    }

    @Override
    public void setTurtleVisibility (boolean visible) {
        getMyTurtleModel().setTurtleVisibility(visible);
    }

    @Override
    public boolean getTurtleVisibility () {
        return getMyTurtleModel().getTurtleVisibility();
    }

    @Override
    public void clearLines () {
        getMyTurtleModel().clearLines();
    }

    @Override

    public ReadOnlyListProperty<LineInfo> getLines () {
        return getMyTurtleModel().getReadOnlyLines();
    }

    @Override
    public MapProperty<String, Double> variableMapProperty() {
        return getMyOptionsModel().variableMapProperty();
    }

    @Override
    public MapProperty<String, List<String>> definedCommandsProperty () {
        return getMyOptionsModel().definedCommandsProperty();
    }

    @Override
    public Map<String, AbstractExpressionNode> userCommandsBodies () {
        return getMyOptionsModel().userCommandsBodies();
    }

    @Override
    public ListProperty<String> commandHistoryProperty() {
        return getMyOptionsModel().commandHistoryProperty();
    }

    @Override
    public ReadOnlyListProperty<String> languageOptionsProperty () {
        return getMyOptionsModel().languageOptionsProperty();
    }

    @Override
    public ReadOnlyIntegerProperty getActiveLanguageIndex () {
        return getMyOptionsModel().getActiveLanguageIndex();
    }

    @Override
    public void setActiveLanguageIndex (int languageIndex) {
        getMyOptionsModel().setActiveLanguageIndex(languageIndex);
    }

    @Override
    public ListProperty<RGBColor> colorOptionsProperty () {
        return getMyOptionsModel().colorOptionsProperty();
    }

    @Override
    public ReadOnlyIntegerProperty getActiveBackgroundColorIndex () {
        return getMyTurtleModel().backgroundColorIndexProperty();
    }

    @Override
    public void setActiveBackgroundColorIndex (int backgroundColorIndex) {
        // TODO add message
        if (backgroundColorIndex >= getMyOptionsModel().colorOptionsProperty().size()) {
            throw new IllegalArgumentException();
        }
        getMyTurtleModel().backgroundColorIndexProperty().set(backgroundColorIndex);
    }

    @Override
    public ReadOnlyIntegerProperty getActivePenColorIndex () {
        return getMyTurtleModel().getActivePenColorIndex();
    }

    @Override
    public void setActivePenColorIndex (int penColorIndex) {
        // TODO Add message
        if (penColorIndex >= getMyOptionsModel().colorOptionsProperty().size()) {
            throw new IllegalArgumentException();
        }
        getMyTurtleModel().getActivePenColorIndex().set(penColorIndex);
    }

    @Override
    public ListProperty<String> turtleImageOptionsProperty () {
        return getMyOptionsModel().turtleImageOptionsProperty();
    }

    @Override
    public ReadOnlyIntegerProperty getActiveTurtleImageIndex () {
        return getMyTurtleModel().getActiveTurtleImageIndex();
    }

    @Override
    public void setActiveTurtleImageIndex (int turtleImageIndex) {
        // TODO add message
        if (turtleImageIndex >= getMyOptionsModel().turtleImageOptionsProperty().size()) {
            throw new IllegalArgumentException();
        }
        getMyTurtleModel().getActiveTurtleImageIndex().set(turtleImageIndex);
    }

    @Override
    public void addCoreTurtleObserver (Observer observer) {
        getMyTurtleModel().addObserver(observer);
    }

    private BasicTurtleModel getMyTurtleModel () {
        return myTurtleModel;
    }

    private BasicOptionsModel getMyOptionsModel () {
        return myOptionsModel;
    }

}
