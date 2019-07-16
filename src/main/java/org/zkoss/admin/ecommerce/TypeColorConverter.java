package org.zkoss.admin.ecommerce;


import org.zkoss.bind.*;
import org.zkoss.zk.ui.Component;

import java.util.*;

/**
 * Convert {@link Type} to a font awesome icon class
 */
public class TypeColorConverter implements Converter<String, Type, Component> {
    static private Map<Type, String> borderColorMap = new HashMap() {{
        put(Type.Customer, "border-primary");
        put(Type.Order, "border-warning");
        put(Type.Task, "border-danger");
        put(Type.Request, "border-success");
    }};

    @Override
    public String coerceToUi(Type type, Component component, BindContext bindContext) {
        return borderColorMap.get(type);
    }

    @Override
    public Type coerceToBean(String s, Component component, BindContext bindContext) {
        //no need in our case
        return null;
    }
}
