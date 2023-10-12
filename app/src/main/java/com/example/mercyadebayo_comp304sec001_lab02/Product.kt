package com.example.mercyadebayo_comp304sec001_lab02

data class Product(
    val name: String,
    val price: Double,
    val imageResource: Int
)
data class ProductCategory(
    val name: String,
    val products: List<Product>
)



// products for Appliances
val appliancesProducts = listOf(
    Product("Whirlpool Refrigerator", 5647.99, R.drawable.refrigerator_image),
    Product("Samsung Dishwasher", 797.99, R.drawable.dishwasher_image),
    Product("Samsung Cooktop", 895.06, R.drawable.cooktop_image),
    Product(" Midea Dryer", 849.99, R.drawable.dryer_image)


)

// products for TVs
val tvProducts = listOf(
    Product("55” Samsung LED", 699.99, R.drawable.samsung_tv_image),
    Product("32” LG Smart LED", 247.99, R.drawable.lg_tv_image),
    Product("32” Hisense Smart full Array", 167.99, R.drawable.hisense_smart_tv_image),
    Product("55” Hisense 4K ULED", 847.99, R.drawable.hisense_4k_tv_image)
)

// products for Computers
val computerProducts = listOf(
    Product("Dell Inspiron 27 All-in-One", 1499.99, R.drawable.dell_computer_image),
    Product("500GB Samsung Desktop", 490.19, R.drawable.samsung_computer_image),
    Product("24” iMac All-in-One", 1699.00, R.drawable.imac_computer_image),
    Product("Lenovo Desktop Computer ThinkCentre", 1358.99, R.drawable.lenovo_computer_image)
)

//  products for Furniture
val furnitureProducts = listOf(
    Product("HORIZON 89” SOFA", 2499.99, R.drawable.sofa_image),
    Product("AVERY CENTER TABLE", 7063.35, R.drawable.center_table_image),
    Product("ORTHO-DELUX BED SET", 153.67, R.drawable.bed_image),
    Product("DINING TABLE SET", 449.99, R.drawable.dining_set_image)

)

// products for Auto Accessories
val autoAccessoriesProducts = listOf(
    Product("3-in-1 HARNESS BOOSTER", 170.98, R.drawable.car_seat_image),
    Product("CAR INTERIOR LIGHT STRIP", 11.99, R.drawable.light_strip_image),
    Product("REFLECTIVE TAPE FOR CAR", 18.45, R.drawable.reflective_tape_image),
    Product("TRUNK ORGANIZER", 49.99, R.drawable.trunk_organizer_image)
)

// Create ProductCategory instances for each category
val productCategories = listOf(
    ProductCategory("Appliances", appliancesProducts),
    ProductCategory("TVs", tvProducts),
    ProductCategory("Computers", computerProducts),
    ProductCategory("Furniture", furnitureProducts),
    ProductCategory("Auto Accessories", autoAccessoriesProducts)
)
