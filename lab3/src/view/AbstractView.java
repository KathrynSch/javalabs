package view;

import model.Model;

public abstract class AbstractView implements View{

	private GUIListener controller;
	private final Model model;
	
	public AbstractView(Model model) {
		this.model = model;
	}
	
	/*
	 * this method is protected because it will be used by the daughter classes
	 * and is final because the model is initiated only once and can't be changed
	 */
	protected final Model getModel() {
		return this.model;
		
	}
	protected final GUIListener getController() {
		return this.controller;
		
	}
	
	@Override
	public void setController(GUIListener controller) {
		this.controller = controller;
	}
	
}
