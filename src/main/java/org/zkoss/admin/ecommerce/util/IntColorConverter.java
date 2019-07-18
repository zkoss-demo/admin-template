package org.zkoss.admin.ecommerce.util;


import org.zkoss.bind.*;
import org.zkoss.zk.ui.Component;

import java.util.*;

/**
 * Convert integer to a bootstrap color
 */
public class IntColorConverter implements Converter<String, Integer, Component> {
    static private String COLORS[] = {"primary", "warning", "danger", "success"};

    @Override
    public String coerceToUi(Integer index, Component component, BindContext bindContext) {
        return COLORS[index % COLORS.length];
    }

    @Override
    public Integer coerceToBean(String s, Component component, BindContext bindContext) {
        //no need in our case
        return null;
    }
}
