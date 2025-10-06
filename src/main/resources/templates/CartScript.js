function addToCart(productId) {
    fetch(`/api/cart/add/${productId}`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
    })
        .then(response => response.json())
        .then(cart => {
            console.log('Товар добавлен в корзину:', cart);
            updateCartUI(cart);
        })
        .catch(error => {
            console.error('Ошибка:', error);
        });
}

function removeFromCart(productId) {
    fetch(`/api/cart/remove/${productId}`, {
        method: 'DELETE',
    })
        .then(response => response.json())
        .then(cart => {
            console.log('Товар удалён из корзины:', cart);
            updateCartUI(cart);
        })
        .catch(error => {
            console.error('Ошибка:', error);
        });
}

function updateCart(quantities) {
    fetch('/api/cart/update', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(quantities),
    })
        .then(response => response.json())
        .then(cart => {
            console.log('Корзина обновлена:', cart);
            updateCartUI(cart);
        })
        .catch(error => {
            console.error('Ошибка:', error);
        });
}

function loadCart() {
    fetch('/api/cart')
        .then(response => response.json())
        .then(cart => {
            console.log('Текущая корзина:', cart);
            updateCartUI(cart);
        })
        .catch(error => {
            console.error('Ошибка:', error);
        });
}

function updateCartUI(cart) {
    const cartItemsContainer = document.getElementById('cart-items');
    const cartTotalElement = document.getElementById('cart-total');

    cartItemsContainer.innerHTML = '';

    cart.items.forEach(item => {
        const itemElement = document.createElement('div');
        itemElement.className = 'cart-item';
        itemElement.innerHTML = `
            <div>
                <h5>${item.product.name}</h5>
                <p>Цена: ${item.product.price} ₽</p>
                <input type="number" value="${item.quantity}" min="1" onchange="updateQuantity(${item.product.id}, this.value)">
                <button onclick="removeFromCart(${item.product.id})">Удалить</button>
            </div>
        `;
        cartItemsContainer.appendChild(itemElement);
    });

    cartTotalElement.textContent = `Итого: ${cart.totalPrice} ₽`;
}

function updateQuantity(productId, quantity) {
    const quantities = {};
    quantities[productId] = parseInt(quantity);
    updateCart(quantities);
}

document.addEventListener('DOMContentLoaded', loadCart);
