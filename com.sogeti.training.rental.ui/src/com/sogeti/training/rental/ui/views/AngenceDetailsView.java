package com.sogeti.training.rental.ui.views;

import java.util.Arrays;

import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;

import com.opcoach.training.rental.RentalAgency;
import com.sogeti.training.rental.core.RentalCoreActivator;
import com.sogeti.training.rental.ui.RentalUIConstants;
import com.sogeti.training.rental.ui.RentalUiActivator;
import com.sogeti.training.rental.ui.provider.RentalProvider;

public class AngenceDetailsView extends ViewPart implements RentalUIConstants, IPropertyChangeListener{

	private TreeViewer tv;

	public AngenceDetailsView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		tv = new TreeViewer(parent);
		RentalProvider rentalProvider = new RentalProvider();
		tv.setContentProvider(rentalProvider);
		tv.setLabelProvider(rentalProvider);
		tv.setInput(Arrays.asList(RentalCoreActivator.getAgency()));
		tv.expandAll();
		tv.refresh();
		getSite().setSelectionProvider(tv);
		
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent event) {
		if(event.getProperty() == C_COLOR_E)
			tv.refresh();
	}
	
	@Override
	public void init(IViewSite site) throws PartInitException {
		// TODO Auto-generated method stub
		super.init(site);
		RentalUiActivator.getDefault().getPreferenceStore().addPropertyChangeListener(this);
	}

	@Override
	public void dispose() {
		RentalUiActivator.getDefault().getPreferenceStore().removePropertyChangeListener(this);
		super.dispose();
	}
	
	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
