package com.sogeti.training.rental.ui;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.core.runtime.preferences.IEclipsePreferences.IPreferenceChangeListener;
import org.eclipse.core.runtime.preferences.IEclipsePreferences.PreferenceChangeEvent;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.swt.graphics.RGB;

public class RentalPrefInitializer extends AbstractPreferenceInitializer implements RentalUIConstants {

	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = RentalUiActivator.getDefault().getPreferenceStore();
		store.setDefault(C_COLOR_E, StringConverter.asString(new RGB(243,87,25)));
		store.setDefault(R_COLOR_E, StringConverter.asString(new RGB(120,180,145)));
		store.setDefault(O_COLOR_E, StringConverter.asString(new RGB(20,240,250)));
	}

}
