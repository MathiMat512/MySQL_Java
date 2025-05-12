function seleccionarMarcaAdd(descripcion, idMarca) {
    document.getElementById("cod_marca_add").value = idMarca;
    document.getElementById("marcaDropdownButtonAdd").textContent = descripcion;
}

function seleccionarMarcaEdit(descripcion, idMarca, idProducto) {
    document.getElementById(`cod_marca_${idProducto}`).value = idMarca;
    document.getElementById(`marcaDropdownButton_${idProducto}`).textContent = descripcion;
}

function seleccionarProveedorAdd(proveedor, codProveedor) {
    document.getElementById("cod_proveedor_add").value = codProveedor;
    document.getElementById("proveedorDropdownButtonAdd").textContent = proveedor;
}

function seleccionarProveedorEdit(descripcion, codProveedor, idProducto) {
    document.getElementById(`cod_proveedor_${idProducto}`).value = codProveedor;
    document.getElementById(`proveedorDropdownButton_${idProducto}`).textContent = descripcion;
}

function seleccionarAreaAdd(area, codArea) {
    document.getElementById("cod_area_add").value = codArea;
    document.getElementById("areaDropdownButtonAdd").textContent = area;
}

function seleccionarAreaEdit(area, codArea, idProducto) {
    document.getElementById(`cod_area_${idProducto}`).value = codArea;
    document.getElementById(`areaDropdownButton_${idProducto}`).textContent = area;
}

function seleccionarCategoriaAdd(categoria, codCategoria) {
    document.getElementById("cod_categoria_add").value = codCategoria;
    document.getElementById("categoriaDropdownButtonAdd").textContent = categoria;
}

function seleccionarCategoriaEdit(categoria, codCategoria, idProducto) {
    document.getElementById(`cod_categoria_${idProducto}`).value = codCategoria;
    document.getElementById(`categoriaDropdownButton_${idProducto}`).textContent = categoria;
}

function seleccionarRolAdd(rol, codRol) {
    document.getElementById("cod_rol_add").value = codRol;
    document.getElementById("rolDropdownButtonAdd").textContent = rol;
}

function seleccionarRolEdit(rol, codRol, id_user) {
    document.getElementById(`cod_rol_${id_user}`).value = codRol;
    document.getElementById(`rolDropdownButton_${id_user}`).textContent = rol;
}

function eliminarProducto(id) {
    if (confirm('¿Estás seguro de eliminar el producto con ID ' + id + '?')) {
        fetch('productos?id_producto=' + id, {
            method: 'DELETE'
        })
        .then(response => {
            if (response.ok) {
                alert('Producto eliminado con éxito');
                window.location.href = 'productos'; // Redirigir a la lista de productos
            } else {
                alert('Error al eliminar el producto');
            }
        })
        .catch(error => {
            console.error('Error:', error);
            alert('Error en la solicitud');
        });
    }
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