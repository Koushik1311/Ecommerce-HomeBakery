package com.homebakery.homebakery.global;

import java.util.ArrayList;
import java.util.List;

import com.homebakery.homebakery.model.Product;

public class GlobalData {
    public static List<Product> cart;
    static {
        cart = new ArrayList<Product>();
    }
}
