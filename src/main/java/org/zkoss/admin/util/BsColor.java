package org.zkoss.admin.util;

/**
 * bootstrap color code
 */
public enum BsColor {
    PRIMARY ("#007bff"), SUCCESS("#28a745"), WARNING("#ffc107")
    , DANGER("#dc3545"), INFO("#17a2b8"), SECONDARY("#6c757d");

    private String hexCode;

    BsColor(String hexCode) {
        this.hexCode = hexCode;
    }

    public String getCssClass(){
        return toString().toLowerCase();
    }

    public String getHexCode() {
        return hexCode;
    }

    public static BsColor getColor(int index){
        return values()[index % values().length];
    }
}
