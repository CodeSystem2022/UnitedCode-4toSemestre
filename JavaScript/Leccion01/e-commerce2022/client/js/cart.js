//const mercadopago = require("mercadopago");
const modalContainer = document.getElementById("modal-container");
const modalOverlay = document.getElementById("modal-overlay");
const cartBtn = document.getElementById("cart-btn");
const cartCounter = document.getElementById("cart-counter");

const displayCart = () => {
    modalContainer.innerHTML = "";
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

    // modal body
    if (cart.length > 0){
    cart.forEach((product) => {
      const modalBody = document.createElement("div");
      modalBody.className = "modal-body";
      modalBody.innerHTML = `
      <div class="product">
          <img class="product-img" src="${product.img}" />
          <div class="product-info">      
              <h4>${product.productName}</h4>
          </div>
        <div class="quantity">
          <span class="quantity-btn-decrease">-</span>
          <span class="quantity-input">${product.quanty}</span>
          <span class="quantity-btn-increase">+</span>
        </div> 
          <div class="price">${product.price * product.quanty} $</div>
          <div class="delete-product">❌</div> 
      </div>
      `;
        modalContainer.append(modalBody);

      const decrease = modalBody.querySelector(".quantity-btn-decrease");
      decrease.addEventListener("click", ()=>{
        if(product.quanty !==1){
          product.quanty--;
          displayCart();
        };
        displayCartCounter();
      });

      const increase = modalBody.querySelector(".quantity-btn-increase");
      increase.addEventListener("click", ()=>{
        product.quanty++;
        displayCart()
        displayCartCounter();
      });

      // Delete
      const deleteProduct = modalBody.querySelector(".delete-product");

      deleteProduct.addEventListener("click", () => {
        deleteCartProduct(product.id)
      })
    });  
    
    // modal footer
    const total = cart.reduce((acc, el) => acc + el.price * el.quanty, 0);

    const modalFooter = document.createElement("div");
    modalFooter.className = "modal-footer"
    modalFooter.innerHTML = `
    <div class="total-price">Total: ${total} $</div>
    <button class="btn-primary" id="checkout-btn"> ir al pago </button>
    <div id="button-checkout"></div>
    `;
    modalContainer.append(modalFooter);

    //MercadoPago
    
    const mercadopago = new MercadoPago("TEST-8681a8c6-218e-47ad-98a8-e9d6c941e1b4", {
      locale: "es-AR", // The most common 
    });

    const checkoutButton = modalFooter.querySelector("#checkout-btn");

    checkoutButton.addEventListener("click", function () {
      checkoutButton.remove();

      const orderData = {
        quantity: 1,
        description: "compra de ecommerce",
        price: total,
      };

      fetch("http://localhost:8080/create_preference", {
        method: "POST",
        headers: {
          "content-Type": "application/json",
        },
        body: JSON.stringify(orderData),
      })
        .then(function (response) {
          return response.json();
        })
        .then(function (preference) {
          createCheckoutButton(preference.id);
        })
        .catch(function () {
          alert("Unexpected error");
        });
    });

    function createCheckoutButton(preferenceId) {
      const bricksBuilder = mercadopago.bricks();

      const renderComponent = async (bricksBuilder) => {
        await bricksBuilder.create(
          "wallet",
          "button-checkout",
          {
            initialization: {
              preferenceId: preferenceId,
            },
            callBacks: {
              onError: (error) => console.error(error),
              onReady: () => {},
            },
          }
        )
      }
      window.checkoutButton = renderComponent(bricksBuilder);
    }
  }else {
    const modalText = document.createElement("h2");
    modalText.className = "modal-body";
    modalText.innerText = "Carrito Vacio";
    modalContainer.append(modalText);
  }
};

cartBtn.addEventListener("click", displayCart);

const deleteCartProduct = (id) => {
  const foundId = cart.findIndex((element) => element.id === id);
  cart.splice(foundId,1);
  displayCart();
  displayCartCounter();
} 

const displayCartCounter = () => {
  if(cart.length > 0){
  const cartLength = cart.reduce((acc, el) => acc + el.quanty, 0);
  cartCounter.style.display = "block";
  cartCounter.innerText = cartLength;
  } else{
    cartCounter.style.display = "none";
  }  
}