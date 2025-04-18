document.querySelectorAll('.dropdown-menu .dropdown-item').forEach(function (item) {
    item.addEventListener('click', function (e) {
        e.preventDefault();
        const value = this.getAttribute('data-value');
        const inputId = this.getAttribute('data-input');
        const dropdown = this.closest('.dropdown').querySelector('.dropdown-toggle');

        dropdown.textContent = this.textContent.trim();

        document.getElementById(inputId).value = value;
    });
});