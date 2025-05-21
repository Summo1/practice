document.addEventListener('DOMContentLoaded', function() {
    const toggleButton = document.querySelector('.navbar-toggle');
    const navbarMenu = document.querySelector('.navbar-menu');
    
    // Toggle mobile menu
    toggleButton.addEventListener('click', function() {
        navbarMenu.classList.toggle('active');
        toggleButton.classList.toggle('active');
    });
    
    // Update cart count (you would replace this with your actual cart logic)
    function updateCartCount() {
        // This is just for demonstration - replace with your actual cart count
        const cartCount = document.querySelector('.cart-count');
        const count = localStorage.getItem('cartCount') || 0;
        cartCount.textContent = count;
    }
    
    updateCartCount();
});