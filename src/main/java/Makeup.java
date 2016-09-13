public class Makeup {
  private String mBrand;
  private String mItemName;
  private Integer mPrice;

  public Makeup(String brand, String itemName, Integer price) {
    mBrand = brand;
    mItemName = itemName;
    mPrice = price;

  }

  public String getBrand() {
    return mBrand;
  }
  public String getItemName() {
    return mItemName;
  }
  public Integer getPrice() {
    return mPrice;
  }
}
