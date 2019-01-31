package com.sogeti.training.rental.ui.provider;

import java.util.List;

import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

import com.opcoach.training.rental.Customer;
import com.opcoach.training.rental.Device;
import com.opcoach.training.rental.RentalAgency;
import com.sogeti.training.rental.ui.RentalUIConstants;
import com.sogeti.training.rental.ui.RentalUiActivator;

public class RentalProvider extends LabelProvider implements ITreeContentProvider, IColorProvider, RentalUIConstants {

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
	
	
	
	@Override
	public Image getImage(Object element) {
		if(element instanceof RentalAgency) {
			return RentalUiActivator.getDefault().getImageRegistry().get(IMG_AGENCY);
		} else if (element instanceof Node) {
			Node node = (Node) element;
			switch (node.getLabel()) {
			case Node.CUSTOMERS:
				return RentalUiActivator.getDefault().getImageRegistry().get(IMG_CUSTOMER);
			case Node.OBJETS_A_LOUER:
				return RentalUiActivator.getDefault().getImageRegistry().get(IMG_RENTAL_OBJECT);
			case Node.RENTALS:
				return RentalUiActivator.getDefault().getImageRegistry().get(IMG_RENTAL);
			default:
				break;
			}
		}
		return super.getImage(element);
	}
	
	
	
	@Override
	public Color getForeground(Object element) {
		if( element instanceof RentalAgency) {
			return getAColor(RentalUiActivator.getDefault().getPreferenceStore().getString(C_COLOR_E));
		} else if (element instanceof Node) {
			return Display.getCurrent().getSystemColor(SWT.COLOR_CYAN);
		}
		return null;
	}

	@Override
	public Color getBackground(Object element) {
		if( element instanceof RentalAgency) {
			return Display.getCurrent().getSystemColor(SWT.COLOR_DARK_GRAY);
		} else if (element instanceof Node) {
			return Display.getCurrent().getSystemColor(SWT.COLOR_DARK_GRAY);
		}
		return null;
	}
	
	private Color getAColor(String rgbKey) {
		ColorRegistry colorRegistry = JFaceResources.getColorRegistry();
		Color color = colorRegistry.get(rgbKey);
		if(color == null) {
			colorRegistry.put(rgbKey, StringConverter.asRGB(rgbKey));
			color = colorRegistry.get(rgbKey);
		}
		return color;
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
