let nombre = document.querySelector("#nombre");
let apellido = document.querySelector("#apellido");
let correo = document.querySelector("#correo");
let contraseña = document.querySelector("#contraseña");
let boton = document.querySelector("#boton");
let salida = document.querySelector("#salida");
let listo = document.querySelector("#listo");

    boton.addEventListener("click",()=>{
        salida.textContent = `Su nombre es ${nombre.value}, Su apellido es ${apellido.value}, Su correo es ${correo.value} y su contraseña es ${contraseña.value}.`
    })


