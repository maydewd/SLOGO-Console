package model;

import javafx.beans.Observable;


public interface IBasicModel extends BasicModelActions, BasicModelSettings, Observable {
	public void setCurrentTurtle();
}