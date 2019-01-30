package com.sogeti.training.rental.ui.views;

import java.util.Arrays;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import com.opcoach.training.rental.RentalAgency;
import com.sogeti.training.rental.core.RentalCoreActivator;
import com.sogeti.training.rental.ui.provider.RentalProvider;

public class AngenceDetailsView extends ViewPart {

	public AngenceDetailsView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		TreeViewer tv = new TreeViewer(parent);
		RentalProvider rentalProvider = new RentalProvider();
		tv.setContentProvider(rentalProvider);
		tv.setLabelProvider(rentalProvider);
		tv.setInput(Arrays.asList(RentalCoreActivator.getAgency()));
		tv.expandAll();
		getSite().setSelectionProvider(tv);
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
