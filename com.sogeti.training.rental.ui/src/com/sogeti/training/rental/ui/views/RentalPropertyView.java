package com.sogeti.training.rental.ui.views;


import java.util.Date;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;

import com.opcoach.training.rental.Customer;
import com.opcoach.training.rental.Rental;
import com.opcoach.training.rental.RentalAgency;
import com.opcoach.training.rental.RentalObject;
import com.sogeti.training.rental.core.RentalCoreActivator;

public class RentalPropertyView extends ViewPart implements ISelectionListener {

	private Label rentedObjectLabel;
	private Label renterPersonLabel;
	private Label endDateLabel;
	private Label startDateLabel;

	public RentalPropertyView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(1, false));
		Group g = new Group(parent, SWT.BORDER);
		g.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
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
		
		Group grpDateDeLocation = new Group(parent, SWT.NONE);
		grpDateDeLocation.setText("Date de Location");
		grpDateDeLocation.setLayout(new GridLayout(2, false));
		grpDateDeLocation.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		//fieldDateLocaltionLabel.setLayoutData(gd_fieldDateLocaltionLabel);
		Label lblDu = new Label(grpDateDeLocation, SWT.NONE);
		lblDu.setText("du: ");
		
		startDateLabel = new Label(grpDateDeLocation, SWT.NONE);
		
		
		Label lblAu = new Label(grpDateDeLocation, SWT.NONE);
		lblAu.setText("au: ");
		
		endDateLabel = new Label(grpDateDeLocation, SWT.NONE);
		this.setRental(RentalCoreActivator.getAgency().getRentals().get(0));
		
	}

	public void setRental(Rental r) {
		rentedObjectLabel.setText(r.getRentedObject().getName());
		renterPersonLabel.setText(r.getCustomer().getDisplayName());
		startDateLabel.setText(r.getStartDate().toString());
		endDateLabel.setText(r.getEndDate().toString());
	}
	
	@Override
	public void init(IViewSite site) throws PartInitException {
		super.init(site);
		site.getPage().addSelectionListener(this);
	}
	
	@Override
	public void dispose() {
		getSite().getPage().removeSelectionListener(this);
		super.dispose();
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
                                              
	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		if(selection instanceof IStructuredSelection) {
			Object selectedObject = ((IStructuredSelection) selection).getFirstElement();
			if(selectedObject instanceof Rental) {
				this.setRental((Rental) selectedObject);
			}
		}
		
	}

}
