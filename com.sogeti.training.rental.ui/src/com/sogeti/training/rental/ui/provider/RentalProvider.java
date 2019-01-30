package com.sogeti.training.rental.ui.provider;

import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;

import com.opcoach.training.rental.Customer;
import com.opcoach.training.rental.Device;
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
			RentalAgency a = (RentalAgency) parentElement;
			result = new Node[] {new Node(Node.CUSTOMERS, a), new Node(Node.RENTALS, a), new Node(Node.OBJETS_A_LOUER, a)};
		} else if (parentElement instanceof Node) {
			result = ((Node) parentElement).getChildren();
		}
		return result;
	}

	@Override
	public Object getParent(Object element) {
		
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		/*if(element instanceof RentalAgency) {
			RentalAgency rentalAgency = (RentalAgency) element;
			if(rentalAgency.getCustomers().size() != 0 || rentalAgency.getObjectsToRent().size() != 0 || rentalAgency.getRentals().size() != 0) {
				return true;
			}
		} else if (element instanceof Node) {
			Node node = (Node) element;
			if(node.getChildren().length != 0) {
				return true;
			}
		}*/
		
		if(element instanceof RentalAgency || element instanceof Node) {
			return true;
		}
		return false;
	}
	
	public String getText(Object element) {
		if( element instanceof RentalAgency) {
			return ((RentalAgency) element).getName();
		} else if (element instanceof Customer) {
			return ((Customer) element).getDisplayName();
		} else if (element instanceof Device) {
			return ((Device) element).getName();
		}
		else {
			return super.getText(element);
		}
	}
	
	private class Node {
		public static final String OBJETS_A_LOUER = "Objets à louer";
		public static final String RENTALS = "Rentals";
		public static final String CUSTOMERS = "Customers";
		private String label;
		private RentalAgency rentalAgency;
		
		public Node (String label, RentalAgency rentalAngency) {
			this.label = label;
			this.rentalAgency = rentalAngency;
		}
		
		@Override
		public String toString() {
		
			return label;
		}
		
		public Object[] getChildren() {
			if(label == CUSTOMERS) {
				return rentalAgency.getCustomers().toArray();
			} else if (label == RENTALS) {
				return rentalAgency.getRentals().toArray();
			} else if (label == OBJETS_A_LOUER) {
				return rentalAgency.getObjectsToRent().toArray();
			} else {
				return null;
			}
		}

		public String getLabel() {
			return label;
		}

		public void setLabel(String label) {
			this.label = label;
		}
		
		
	}

}
