let usuario = {
    nombre: "Gabriel",
    apellido: "Gonzalez",
    direccion: {
        calle: "Trinidad",
        numero: 13,
    },
    recuperarClave: function(){
        console.log("Recuperando clave")
    },
}

let usuario1 = {
    nombre: "Gabriel",
    apellido: "Gonzalez",
    direccion: {
        calle: "Trinidad",
        numero: 13,
    },
    recuperarClave: function(){
        console.log("Recuperando clave")
    },
}

//Codigo repetitivo ==>

function crearUsuario(nombre, apellido, calle, numero){
    return{
        nombre,
        apellido,
        direccion:{
            calle,
            numero,
        },
        recuperarClave: function(){
            console.log("Recuperando clave")
        },
    }
}

usuario2 = crearUsuario("Juan","Andres","Boina",2);
usuario3 = crearUsuario("Manuel","Sanchez","Augusto",15);
