function cambiarLimite() {
    const limite = document.getElementById('selectLimite').value;
    // Hacer una petición AJAX para obtener los datos con el nuevo límite
    fetch(`actividades?limite=${limite}`)
        .then(response => response.text())
        .then(html => {
            // Crear un elemento temporal para parsear el HTML
            const temp = document.createElement('div');
            temp.innerHTML = html;
            
            // Extraer solo el contenido de la tabla
            const nuevaTabla = temp.querySelector('#tabla tbody');
            if (nuevaTabla) {
                document.querySelector('#tabla tbody').innerHTML = nuevaTabla.innerHTML;
            }
        })
        .catch(error => console.error('Error:', error));
}