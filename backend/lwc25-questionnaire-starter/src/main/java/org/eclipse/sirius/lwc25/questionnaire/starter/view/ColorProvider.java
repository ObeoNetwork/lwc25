package org.eclipse.sirius.lwc25.questionnaire.starter.view;

import org.eclipse.sirius.components.view.ColorPalette;
import org.eclipse.sirius.components.view.UserColor;
import org.eclipse.sirius.components.view.View;
import org.eclipse.sirius.components.view.builder.providers.IColorProvider;

import java.util.Collection;
import java.util.Objects;

public class ColorProvider implements IColorProvider {

    private final View view;

    public ColorProvider(View view) {
        this.view = Objects.requireNonNull(view);
    }

    @Override
    public UserColor getColor(String colorName) {
        return this.view.getColorPalettes()
                .stream()
                .map(ColorPalette::getColors)
                .flatMap(Collection::stream)
                .filter(userColor -> userColor.getName().equals(colorName))
                .findFirst()
                .orElse(null);
    }
}