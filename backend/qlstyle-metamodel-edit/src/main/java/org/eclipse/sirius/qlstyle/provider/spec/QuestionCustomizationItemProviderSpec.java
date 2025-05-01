package org.eclipse.sirius.qlstyle.provider.spec;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.sirius.qlstyle.provider.QuestionCustomizationItemProvider;

public class QuestionCustomizationItemProviderSpec extends QuestionCustomizationItemProvider {
    /**
     * This constructs an instance from a factory and a notifier. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @param adapterFactory
     * @generated
     */
    public QuestionCustomizationItemProviderSpec(AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

    @Override
    public Object getImage(Object object) {
        return this.overlayImage(object, this.getResourceLocator().getImage("qlstyle/full/obj16/QuestionCustomization.svg"));
    }
}