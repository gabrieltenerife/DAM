let carta = document.querySelector("#carta");
let boton = document.querySelector("#boton");

function mostrarProductos(productos) {
    carta.innerHTML = "";
    productos.forEach((item) => {
        const primeraImagen = item.images[0]; // Seleccionar la primera imagen
        carta.innerHTML += `<div class="col">
        <div class="card" id="carta" style="width: 18rem;">
            <img src='${primeraImagen}' class="card-img-top" alt="...">
            <div class="card-body">
              <h5 class="card-title">${item.title}</h5>
              <p class="card-text">${item.brand}</p>
              <a href="#" class="btn btn-primary">Añadir al carro</a>
            </div>
          </div>
    </div>`;
    });
}

function añadirAlCarro(titulo) {
    const listaCarro = document.querySelector("#listacarro");
    const nuevoElemento = document.createElement("li");
    nuevoElemento.textContent = titulo;
    listaCarro.appendChild(nuevoElemento);
}

function aplicarFiltros() {
    fetch("https://dummyjson.com/products")
    .then((result) => {
        return result.json();
    })
    .then((results2) => {
        let productosFiltrados = results2.products.filter((item) => {
            const marcaSeleccionada = document.querySelector("#marca").value;
            const categoriaSeleccionada = document.querySelector("#categoria").value;

            if (marcaSeleccionada && item.brand !== marcaSeleccionada) {
                return false;
            }

            if (categoriaSeleccionada && item.category !== categoriaSeleccionada) {
                return false;
            }

            return true;
        });

        const ordenSeleccionado = document.querySelector("#orden").value;
        if (ordenSeleccionado === "asc") {
            productosFiltrados.sort((a, b) => a.price - b.price);
        } else if (ordenSeleccionado === "desc") {
            productosFiltrados.sort((a, b) => b.price - a.price);
        }

        mostrarProductos(productosFiltrados);

        // Agregar event listener a todos los botones "Añadir al carro"
        const botonesCarro = document.querySelectorAll(".btn-primary");
        botonesCarro.forEach((boton) => {
            boton.addEventListener("click", (event) => {
                const tituloProducto = event.target.parentElement.querySelector(".card-title").textContent;
                añadirAlCarro(tituloProducto);
            });
        });
    })
    .catch((error) => {
        console.error("Error al cargar los productos:", error);
    });
}

boton.addEventListener("click", aplicarFiltros);
