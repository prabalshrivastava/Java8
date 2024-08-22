package interview;// package whatever; // don't place package name!
// Installed Libraries: JSON-Simple, JUNit 4, Apache Commons Lang3
import java.util.*;

class PublicsSapient {
	public static void main (String[] args) {
		// String str = "prabalpra";
		String str = "pbrbpra";
    System.out.println(
      Arrays.stream(str.split(""))
      .filter(s -> str.indexOf(s) == str.lastIndexOf(s))
      .findFirst()
      .map(s -> str.indexOf(s))
      .orElse(-1)
    );
    
    int index = -1;
    for(int i=0;i<str.length();i++){
      if(str.indexOf(str.charAt(i)) == str.lastIndexOf(str.charAt(i))){
        index = i;
      }
    }
    System.out.println("index : -> " + index);
    
    //Opening a new connection
    //Closing a existing connection
    //Resusing existing connection
    
    // Product - Category 
    // 1 Product - 1 Category
    // m Product - 1 Category
    
    //m:1 product and category
//    Category{
//      @OneToMany
//      List<Product> products
//    }
//    Product{
//      Category category;
//    }
//    category.getProduct();
//
//
//    CategoryRepo extends CRUDRepository<Category,Integer>{
//      @Query("select category from Category,Product where category.productId = product.productId")
//      Category fetchCategory();
//
//      select category from Category left join Product on category.productId = product.productId;
//    }
//
//    Notification
//      getCurrentClass()
//    <- email
//      getCurrentClass(){Email.class}
//     and SMS
//      getCurrentClass(){SMS.class}
//
//
	}
}