
const modalContainer = document.getElementById("modal-container");
const modalOverlay = document.getElementById("modal-overlay");
const cartBtn = document.getElementById("cart-btn");

const displayCart = () => {
    modalContainer.innerHTML = ""
    modalContainer.style.display = "block";
    modalOverlay.style.display = "block";
    // modal header
    const modalHeader = document.createElement("div");

    const modalClose = document.createElement("div");
    modalClose.innerText = "❌";
    modalClose.className = "modal-close";
    modalHeader.append(modalClose);

    modalClose.addEventListener("click",()=> {
        modalContainer.style.display = "none"
        modalOverlay.style.display = "none"
    })

    const modalTitle = document.createElement("div");
    modalTitle.innerText = "Carrito";
    modalTitle.className = "modal-title";
    modalHeader.append(modalTitle);

    modalContainer.append(modalHeader);

    //modal body(video1)
    
       //Botones de suma y resta de productos(video4 esta dentro  cart.forEach)

      // Eliminar productos del modal (parte del VIDEO 6 esta dentro cart.forEach)
      //delete 
     const deleteProduct = modalBody.querySelector(".delete-product");
    
    deleteProduct.addEventListener("click", ()=>{
        deleteCartProduct(product.id);
      });
  

   //modal fotter
  //Calcular el total de la compra(video5)

  //Ahora vamos al Footer(video2)

};

cartBtn.addEventListener("click", displayCart);

//Eliminar productos del modal (parte del video 6 y 7)
const deleteCartProduct =(id)=>{
    const foundId = cart.findIndex((element)=> element.id === id)
    console.log(foundId);
}