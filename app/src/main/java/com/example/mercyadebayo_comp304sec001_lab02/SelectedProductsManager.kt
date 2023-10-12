package com.example.mercyadebayo_comp304sec001_lab02

object SelectedProductsManager {
    private val selectedProducts = mutableListOf<Product>()

    fun addSelectedProduct(product: Product) {
        selectedProducts.add(product)
    }

    fun removeSelectedProduct(product: Product) {
        selectedProducts.remove(product)
    }

    fun getSelectedProducts(): List<Product> {
        return selectedProducts
    }
}