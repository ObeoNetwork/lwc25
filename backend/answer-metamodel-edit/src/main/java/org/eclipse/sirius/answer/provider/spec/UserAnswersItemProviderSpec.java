package org.eclipse.sirius.answer.provider.spec;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.sirius.answer.provider.UserAnswersItemProvider;

public class UserAnswersItemProviderSpec extends UserAnswersItemProvider {
    /**
     * This constructs an instance from a factory and a notifier. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @param adapterFactory
     * @generated
     */
    public UserAnswersItemProviderSpec(AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

    @Override
    public Object getImage(Object object) {
        return this.overlayImage(object, this.getResourceLocator().getImage("answer/full/obj16/UserAnswers.svg"));
    }
}
