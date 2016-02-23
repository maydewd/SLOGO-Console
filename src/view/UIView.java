package view;

import javafx.scene.Node;

/**
 * Created by Tim on 22/02/16.
 */
public interface UIView {

    int getWidth();

    int getHeight();

    /**
     * This method returns the Node that contains all of UI for this View
     * @return view Node
     */
    Node getNode();
}
