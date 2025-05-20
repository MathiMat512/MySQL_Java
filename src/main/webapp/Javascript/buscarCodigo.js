function filtrarBusquedaporCodigo() {
    const input = document.getElementById('buscarCodigo');
    const filter = input.value.trim().toUpperCase();
    const table = document.getElementById('tablaActividades'); // Selección correcta
    const tr = table.getElementsByTagName('tr');

    for (let i = 1; i < tr.length; i++) {
        const td = tr[i].getElementsByTagName('td')[0]; // Columna "Código"
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