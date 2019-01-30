package com.sogeti.training.rental.ui.provider;

import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;

import com.opcoach.training.rental.Customer;
import com.opcoach.training.rental.RentalAgency;

public class RentalProvider extends LabelProvider implements ITreeContentProvider {

	@Override
	public Object[] getElements(Object inputElement) {
		
		Object[] result = null;
		
		if(inputElement instanceof  List<?>) {
			result =  ((List<?>) inputElement).toArray();
		}
		
		return result;
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		Object[] result = null;
		
		if (parentElement instanceof RentalAgency) {
			result = ((RentalAgency) parentElement).getCustomers().toArray();
		}
		
		return result;
	}

	@Override
	public Object getParent(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		return true;
	}
	
	public String getText(Object element) {
		if( element instanceof RentalAgency) {
			return ((RentalAgency) element).getName();
		} else if (element instanceof Customer) {
			return ((Customer) element).getDisplayName();
		}
		else {
			return super.getText(element);
		}
	}

}
