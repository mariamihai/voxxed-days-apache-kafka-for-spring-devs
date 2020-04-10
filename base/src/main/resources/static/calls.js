async function get(categoryId, productId) {
    await fetch('http://localhost:8080/product/' + categoryId + "/" + productId);
}