package org.zkoss.admin.converter;


import org.zkoss.admin.ecommerce.dao.Type;
import org.zkoss.admin.util.BsColor;
import org.zkoss.bind.*;
import org.zkoss.zk.ui.Component;

import java.util.*;

/**
 * Convert {@link Type} to a font awesome icon class
 */
public class TypeColorConverter implements Converter<String, Type, Component> {
    static private Map<Type, String> borderColorMap = new HashMap() {{
        put(Type.Customer, BsColor.PRIMARY.getCssClass());
        put(Type.Order, BsColor.WARNING.getCssClass());
        put(Type.Task, BsColor.DANGER.getCssClass());
        put(Type.Request, BsColor.SUCCESS.getCssClass());
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
