package org.zkoss.admin.util;

/**
 * custom color code corresponding to bootstrap
 */
public enum BsColor {
    PRIMARY ("#0093F9"), SUCCESS("#15CAB4"), WARNING("#FFA516")
    , DANGER("#FF4051"), INFO("#9665ED"), SECONDARY("#B2DEFD");

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
