package view;

import model.Model;

public abstract class AbstractView implements View{

	private GUIListener controller;
	private final Model model;
	
	public AbstractView(Model model) {
		this.model = model;
	}
	
	protected final Model getModel() {
		return model;
		
	}
	protected final GUIListener getController() {
		return controller;
		
	}
	
	
}
