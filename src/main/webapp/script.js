function seleccionarMarca(descripcion_marca, id_marca, el) {
    const dropdown = el.closest(".dropdown").querySelector(".dropdown-toggle");
    dropdown.innerText = descripcion_marca;
    document.getElementById("cod_marca").value = id_marca;
}

function seleccionarProveedor(descripcion_proveedor, id_proveedor, el) {
    const dropdown = el.closest(".dropdown").querySelector(".dropdown-toggle");
    dropdown.innerText = descripcion_proveedor;
    document.getElementById("cod_proveedor").value = id_proveedor;
}

function seleccionarArea(descripcion_area, id_area, el) {
    const dropdown = el.closest(".dropdown").querySelector(".dropdown-toggle");
    dropdown.innerText = descripcion_area;
    document.getElementById("cod_area").value = id_area;
}

function seleccionarCategoria(descripcion_categoria, id_categoria, el) {
    const dropdown = el.closest(".dropdown").querySelector(".dropdown-toggle");
    dropdown.innerText = descripcion_categoria;
    document.getElementById("id_categoria").value = id_categoria;
}

document.addEventListener("DOMContentLoaded", function() {
    document.getElementById("formAgregarProducto").addEventListener("submit", function(event) {
        if (!document.getElementById("cod_marca").value ||
            !document.getElementById("cod_proveedor").value ||
            !document.getElementById("cod_area").value ||
            !document.getElementById("id_categoria").value) {

            event.preventDefault(); // Evita el submit
            alert("No debes dejar ningún dropdown vacío");
        }
    });
});