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


