document.getElementById("buscarDescripcion").addEventListener("input", function () {
    const termino = this.value;
    const xhr = new XMLHttpRequest();
    xhr.open("GET", "productos?accion=buscar&termino=" + encodeURIComponent(termino), true);
    xhr.onload = function () {
        if (xhr.status === 200) {
            document.getElementById("tablaProductos").innerHTML = xhr.responseText;
        }
    };
    xhr.send();
});