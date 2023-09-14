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







































































const deleteCartProduct =(id) => {
    const foundId = cart.findIndex((Element)=> Element.id === id);
    cart.splice(foundId, 1);
    displayCart();
};