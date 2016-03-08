package view;

import javafx.scene.control.Menu;
import model.IBasicModel;

public abstract class BackEndColorSelector extends Selector {
    private Menu myBackEndSettings;
    
    public BackEndColorSelector (IBasicModel basicModel) {
        myBackEndSettings = new Menu("Pen Color");
        for(int i = 0; i < basicModel.colorOptionsProperty().getSize(); i++){
            makeButton(i, basicModel);
        }
    }

    public abstract void makeButton(int i, IBasicModel basicModel);

    @Override
    public Menu getMenu (){
        return myBackEndSettings;
    }

}
