package ru.netology.domain;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProductManager {
    private ProductRepository repository;

    public void add(Product item) {
        repository.save(item);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product item : repository.findAll()) {
            if (item.matches(text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = item;
                result = tmp;
            }
        }
        return result;
    }

//    public boolean matches(Product product, String search) {
//        if (product.getName().contains(search)) {
//            return true;
//        }
//        if (product instanceof Book) {
//            Book book = (Book) product;
//            if (book.getAuthor().contains(search)) {
//                return true;
//            }
//        }
//        if (product instanceof Smartphone) {
//            Smartphone smartphone = (Smartphone) product;
//            if (smartphone.getManufacture().contains(search)) {
//                return true;
//            }
//        }
//        return false;
//    }
}
