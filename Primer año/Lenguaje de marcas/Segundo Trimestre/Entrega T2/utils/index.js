//Variables
let inputnombre = document.querySelector("input#inputnombre");
let inputapellido = document.querySelector("input#inputapellido");
let inputcorreo = document.querySelector("input#inputcorreo");
let boton = document.querySelector("#boton");
let listausuarios = document.querySelector("#listausuarios");
let select = document.querySelector("#select");

var spanit =document.querySelector("#spanit");
var spanmarketing =document.querySelector("#spanmarketing");
var spanventas =document.querySelector("#spanventas");
var spanadministracion =document.querySelector("#spanadministracion");



boton.addEventListener("click", () => {

let menu = select.value;
    switch (Number(menu)) {
        case 1:
            if(inputnombre.value.length > 0 && inputapellido.value.length > 0){
                let nodo = document.createElement("li");
                nodo.textContent = `${inputnombre.value} ${inputapellido.value}`
                nodo.className = "class= list-group-item class= animate__animated animate__backInRight"
                listausuarios.append(nodo);
                inputnombre.value = ""
                inputapellido.value = ""
        
                Swal.fire({
                    position: "center",
                    icon: "success",
                    title: "Trabajador añadido",
                    showConfirmButton: false,
                    timer: 1500
                  });
                  
                  spanit.textContent++;
                
            } else{
                Swal.fire({
                    position: "center",
                    icon: "error",
                    title: "Datos mal introducidos pruebe de nuevo",
                    showConfirmButton: false,
                    timer: 1500
                  });
            }
            break;

        case 2:
            if(inputnombre.value.length > 0 && inputapellido.value.length > 0){
                let nodo = document.createElement("li");
                nodo.textContent = `${inputnombre.value} ${inputapellido.value}`
                nodo.className = "class= list-group-item class= animate__animated animate__backInRight"
                listausuarios.append(nodo);
                inputnombre.value = ""
                inputapellido.value = ""
        
                Swal.fire({
                    position: "center",
                    icon: "success",
                    title: "Trabajador añadido",
                    showConfirmButton: false,
                    timer: 1500
                  });

                  spanmarketing.textContent++;
                
            } else{
                Swal.fire({
                    position: "center",
                    icon: "error",
                    title: "Datos mal introducidos pruebe de nuevo",
                    showConfirmButton: false,
                    timer: 1500
                  });
            }
            break;

        case 3:
            if(inputnombre.value.length > 0 && inputapellido.value.length > 0){
                let nodo = document.createElement("li");
                nodo.textContent = `${inputnombre.value} ${inputapellido.value}`
                nodo.className = "class= list-group-item class= animate__animated animate__backInRight"
                listausuarios.append(nodo);
                inputnombre.value = ""
                inputapellido.value = ""
        
                Swal.fire({
                    position: "center",
                    icon: "success",
                    title: "Trabajador añadido",
                    showConfirmButton: false,
                    timer: 1500
                  });

                  spanventas.textContent++;
                
            } else{
                Swal.fire({
                    position: "center",
                    icon: "error",
                    title: "Datos mal introducidos pruebe de nuevo",
                    showConfirmButton: false,
                    timer: 1500
                  });
            }
            break;
        
        case 4:
            if(inputnombre.value.length > 0 && inputapellido.value.length > 0){
                let nodo = document.createElement("li");
                nodo.textContent = `${inputnombre.value} ${inputapellido.value}`
                nodo.className = "class= list-group-item class= animate__animated animate__backInRight"
                listausuarios.append(nodo);
                inputnombre.value = ""
                inputapellido.value = ""
        
                Swal.fire({
                    position: "center",
                    icon: "success",
                    title: "Trabajador añadido",
                    showConfirmButton: false,
                    timer: 1500
                  });

                  spanadministracion.textContent++;
                
            } else{
                Swal.fire({
                    position: "center",
                    icon: "error",
                    title: "Datos mal introducidos pruebe de nuevo",
                    showConfirmButton: false,
                    timer: 1500
                  });
            }
            break;
            
    }
});