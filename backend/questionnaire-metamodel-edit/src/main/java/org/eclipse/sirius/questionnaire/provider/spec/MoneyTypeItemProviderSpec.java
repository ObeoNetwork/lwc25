package org.eclipse.sirius.questionnaire.provider.spec;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.sirius.questionnaire.provider.MoneyTypeItemProvider;

public class MoneyTypeItemProviderSpec extends MoneyTypeItemProvider {
    /**
     * This constructs an instance from a factory and a notifier. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @param adapterFactory
     * @generated
     */
    public MoneyTypeItemProviderSpec(AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

    @Override
    public Object getImage(Object object) {
        return this.overlayImage(object, this.getResourceLocator().getImage("questionnaire/full/obj16/MoneyType.svg"));
    }
}
