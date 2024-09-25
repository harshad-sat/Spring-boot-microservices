package hy.example.catalogservice.hy.example.domain;

 class ProductMapper {

    static Product toEntity(ProductEntity productEntity) {
        return new Product(
                productEntity.getCode(),
                productEntity.getName(),
                productEntity.getDescription(),
                productEntity.getImageUrl(),
                productEntity.getPrice());
    }
}