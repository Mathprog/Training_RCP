package com.sogeti.training.rental.rcp;

import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.actions.ActionFactory;

public class ApplicationActionBarAdvisor extends ActionBarAdvisor {
	private IAction quitAction;
	private IAction quitAction_1;
	private IAction preferencesAction;

	public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
		super(configurer);
	}
	
	@Override
	protected void makeActions(IWorkbenchWindow window) {
		super.makeActions(window);
		{
			quitAction = ActionFactory.QUIT.create(window);
			register(quitAction);
		}
		{
			quitAction_1 = ActionFactory.QUIT.create(window);
			register(quitAction_1);
		}
		{
			preferencesAction = ActionFactory.PREFERENCES.create(window);
			register(preferencesAction);
		}
	}
	
	@Override
	protected void fillMenuBar(IMenuManager menuBar) {
		super.fillMenuBar(menuBar);
		
		MenuManager menuManager = new MenuManager("New MenuManager");
		menuManager.setMenuText("File");
		menuBar.add(menuManager);
		menuManager.add(quitAction_1);
		
		MenuManager menuManager_1 = new MenuManager("New MenuManager");
		menuManager_1.setMenuText("Window");
		menuBar.add(menuManager_1);
		menuManager_1.add(preferencesAction);
	}
	
	@Override
	protected void fillCoolBar(ICoolBarManager coolBar) {
		super.fillCoolBar(coolBar);
	}

}

