package com.progressquest.ultra.util;

import java.awt.Component;
import java.awt.Font;

/**
 * Util classes with helper functions for the components.
 *
 * @author fernando-marquardt
 */
public class ComponentUtil {

    /**
     * Add the Bold style in the font of the component.
     *
     * @param component Component to have the font changed.
     */
    public static void setFontBold(Component component) {
        Font font = component.getFont();
        component.setFont(font.deriveFont(font.getStyle() | Font.BOLD));
    }

    /**
     * Set the font size to the component font.
     *
     * @param component The component to have the font size changed.
     * @param size The new font size to set.
     */
    public static void setFontSize(Component component, float size) {
        Font font = component.getFont();
        component.setFont(font.deriveFont(size));
    }

}
