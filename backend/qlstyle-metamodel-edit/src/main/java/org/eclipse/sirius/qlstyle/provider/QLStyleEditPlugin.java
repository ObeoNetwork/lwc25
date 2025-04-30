/**
 */
package org.eclipse.sirius.qlstyle.provider;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.sirius.questionnaire.provider.QuestionnaireEditPlugin;

/**
 * This is the central singleton for the QLStyle edit plugin. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 *
 * @generated
 */
public final class QLStyleEditPlugin extends EMFPlugin {
	/**
	 * Keep track of the singleton. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static final QLStyleEditPlugin INSTANCE = new QLStyleEditPlugin();

	/**
	 * Keep track of the singleton. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private static Implementation plugin;

	@Override
	public Object doGetImage(String key) throws IOException {
		URL url = new URL(this.getBaseURL() + "icons/" + key + this.getExtensionFor(key));
		InputStream inputStream = url.openStream();
		inputStream.close();
		return url;
	}

	private String getExtensionFor(String key) {
		String result = ".gif";
		int index = key.lastIndexOf('.');
		if (index != -1) {
			String extension = key.substring(index + 1);
			if ("png".equalsIgnoreCase(extension) || "gif".equalsIgnoreCase(extension)
					|| "bmp".equalsIgnoreCase(extension) || "ico".equalsIgnoreCase(extension)
					|| "jpg".equalsIgnoreCase(extension) || "jpeg".equalsIgnoreCase(extension)
					|| "tif".equalsIgnoreCase(extension) || "tiff".equalsIgnoreCase(extension)
					|| "svg".equalsIgnoreCase(extension)) {
				result = "";
			}
		}
		return result;
	}

	/**
	 * Create the instance. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public QLStyleEditPlugin() {
		super(new ResourceLocator[] { QuestionnaireEditPlugin.INSTANCE, });
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the singleton instance.
	 * @generated
	 */
	@Override
	public ResourceLocator getPluginResourceLocator() {
		return plugin;
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the singleton instance.
	 * @generated
	 */
	public static Implementation getPlugin() {
		return plugin;
	}

	/**
	 * The actual implementation of the Eclipse <b>Plugin</b>. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static class Implementation extends EclipsePlugin {
		/**
		 * Creates an instance. <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @generated
		 */
		public Implementation() {
			super();

			// Remember the static instance.
			//
			plugin = this;
		}
	}

}
