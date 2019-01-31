package com.sogeti.training.rental.ui;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class PerspectiveFactory1 implements IPerspectiveFactory {

	@Override
	public void createInitialLayout(IPageLayout layout) {
		// TODO Auto-generated method stub

		layout.addView("com.sogeti.training.rental.ui.angencedetails", IPageLayout.LEFT, 0.5f, IPageLayout.ID_EDITOR_AREA);
		layout.addView("com.sogeti.training.rental.ui.rentalproperty", IPageLayout.LEFT, 0.5f, IPageLayout.ID_EDITOR_AREA);
	}

}
