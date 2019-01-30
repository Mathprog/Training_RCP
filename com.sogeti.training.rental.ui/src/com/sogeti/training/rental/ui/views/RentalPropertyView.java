package com.sogeti.training.rental.ui.views;


import java.util.Date;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.part.ViewPart;

import com.opcoach.training.rental.Customer;
import com.opcoach.training.rental.Rental;
import com.opcoach.training.rental.RentalAgency;
import com.opcoach.training.rental.RentalObject;
import com.sogeti.training.rental.core.RentalCoreActivator;

public class RentalPropertyView extends ViewPart {

	private Label rentedObjectLabel;
	private Label renterPersonLabel;

	public RentalPropertyView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		Group g = new Group(parent, SWT.NONE);
		g.setText("Information");
		g.setLayout(new GridLayout(2, false));
		
		GridData gd = new GridData();
		gd.horizontalSpan = 2;
		gd.horizontalAlignment = SWT.FILL;
		rentedObjectLabel = new Label(g, SWT.NONE);
		rentedObjectLabel.setLayoutData(gd);
		
		
		
		Label renterPersonTitleLabel = new Label(g, SWT.NONE);
		renterPersonTitleLabel.setText("Loué à: ");
		renterPersonLabel = new Label(g, SWT.NONE);
		this.setRental(RentalCoreActivator.getAgency().getRentals().get(0));
		
		
	}

	public void setRental(Rental r) {
		rentedObjectLabel.setText(r.getRentedObject().getName());
		renterPersonLabel.setText(r.getCustomer().getDisplayName());
	}
	
	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
