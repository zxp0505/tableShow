package ethank.tableshow.modle;

import java.io.Serializable;

/**
 * Created by ping on 2017/2/16.
 */

//"商品条码", "商品分类", "规格", "单位", "供应商", "零售价", "保质期", "进货日期", "进货价"
public class Good implements Serializable {
    private String goodName;//商品名称
    private String goodBar;
    private String goodClasses;
    private String goodStandard;
    private String goodUnit;
    private String goodSupplier;
    private String goodPrice;
    private String goodQuality;
    private String goodPurchaseDate;
    private String goodBuyPrice;

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getGoodBar() {
        return goodBar;
    }

    public void setGoodBar(String goodBar) {
        this.goodBar = goodBar;
    }

    public String getGoodBuyPrice() {
        return goodBuyPrice;
    }

    public void setGoodBuyPrice(String goodBuyPrice) {
        this.goodBuyPrice = goodBuyPrice;
    }

    public String getGoodClasses() {
        return goodClasses;
    }

    public void setGoodClasses(String goodClasses) {
        this.goodClasses = goodClasses;
    }

    public String getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(String goodPrice) {
        this.goodPrice = goodPrice;
    }

    public String getGoodPurchaseDate() {
        return goodPurchaseDate;
    }

    public void setGoodPurchaseDate(String goodPurchaseDate) {
        this.goodPurchaseDate = goodPurchaseDate;
    }

    public String getGoodQuality() {
        return goodQuality;
    }

    public void setGoodQuality(String goodQuality) {
        this.goodQuality = goodQuality;
    }

    public String getGoodStandard() {
        return goodStandard;
    }

    public void setGoodStandard(String goodStandard) {
        this.goodStandard = goodStandard;
    }

    public String getGoodSupplier() {
        return goodSupplier;
    }

    public void setGoodSupplier(String goodSupplier) {
        this.goodSupplier = goodSupplier;
    }

    public String getGoodUnit() {
        return goodUnit;
    }

    public void setGoodUnit(String goodUnit) {
        this.goodUnit = goodUnit;
    }
}
