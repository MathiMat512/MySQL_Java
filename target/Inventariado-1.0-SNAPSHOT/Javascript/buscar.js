function filtrarBusqueda() {
    const input = document.getElementById('buscar');
    const filter = input.value.toUpperCase();
    const table = document.querySelector('.table');
    const tr = table.getElementsByTagName('tr');

    // Recorrer todas las filas de la tabla, empezando desde el índice 1 para omitir los encabezados
    for (let i = 1; i < tr.length; i++) {
        const td = tr[i].getElementsByTagName('td')[1]; // Columna de descripción (índice 1)
        if (td) {
            const txtValue = td.textContent || td.innerText;
            if (txtValue.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }
    }
}
