package com.sogeti.training.rental.ui;

import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class RentalPrefColor extends FieldEditorPreferencePage implements IWorkbenchPreferencePage, RentalUIConstants {



	public RentalPrefColor() {
		super(GRID);
		setPreferenceStore(RentalUiActivator.getDefault().getPreferenceStore());
		setDescription("A demonstration of a preference page implementation");
	}

	@Override
	public void init(IWorkbench workbench) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void createFieldEditors() {
		// TODO Auto-generated method stub
		addField(new ColorFieldEditor(C_COLOR_E, "Customer", getFieldEditorParent()));
		addField(new ColorFieldEditor(R_COLOR_E, "Rental", getFieldEditorParent()));
		addField(new ColorFieldEditor(O_COLOR_E, "Object", getFieldEditorParent()));
	}

}
