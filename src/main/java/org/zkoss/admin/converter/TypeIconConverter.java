package org.zkoss.admin.converter;


import org.zkoss.admin.ecommerce.dao.Type;
import org.zkoss.bind.*;
import org.zkoss.zk.ui.Component;

import java.util.*;

/**
 * Convert {@link Type} to a font awesome icon class
 */
public class TypeIconConverter implements Converter<String, Type, Component> {
    static private Map<Type, String> iconMap = new HashMap() {{
        put(Type.Customer, "z-icon-group");
        put(Type.Order, "z-icon-list");
        put(Type.Task, "z-icon-tasks");
        put(Type.Request, "z-icon-phone");
    }};

    @Override
    public String coerceToUi(Type type, Component component, BindContext bindContext) {
        return iconMap.get(type);
    }

    @Override
    public Type coerceToBean(String s, Component component, BindContext bindContext) {
        //no need in our case
        return null;
    }
}
