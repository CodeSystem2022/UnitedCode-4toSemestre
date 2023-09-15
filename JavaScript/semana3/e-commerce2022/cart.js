//3.6 Eliminar productos del modal -> Parte 1 y 2 - VIDEO 6
//delete (desde linea 65 a 69 en video)
const deleteProduct = modalBody.querySelector(".delete-product");

deleteProduct.addEventListener("click", ()=>{
    deleteCartProduct(product.id);
})
//(desde linea 87 en video)
const deleteCartProduct =(id)=>{
    const foundId = cart.findIndex((element)=> element.id === id)
    console.log(foundId);
}