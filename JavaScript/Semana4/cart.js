// Video 4
const decrese = modalBody.querySelector(".quantity-btn-decrese");
decrese.addEventListener('click', () => {
    if(product.quanty !== 1) {
        product.quanty --;
        displayCart();
    }
});

const increse = modalBody.querySelector(".quantity-btn-increse");
increse.addEventListener('click', () => {
    product.quanty ++;
    displayCart();
}) 

// Video 6

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




































































const deleteCartProduct =(id) => {
    const foundId = cart.findIndex((Element)=> Element.id === id);
    cart.splice(foundId, 1);
    displayCart();
};