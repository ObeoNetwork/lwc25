package org.eclipse.sirius.qlstyle.provider.spec;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.sirius.qlstyle.provider.QLStyleItemProvider;

public class QLStyleItemProviderSpec extends QLStyleItemProvider {
    /**
     * This constructs an instance from a factory and a notifier. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @param adapterFactory
     * @generated
     */
    public QLStyleItemProviderSpec(AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

    @Override
    public Object getImage(Object object) {
        return this.overlayImage(object, this.getResourceLocator().getImage("qlstyle/full/obj16/QLStyle.svg"));
    }
}