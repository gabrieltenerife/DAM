/**
 * Un OBJETO en JS puede contener otros objetos, e incluso funciones y arrays.
 * Las funciones no es necesario ponerle nombre por que ya tienen un atributo asignado.
 */

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

console.log(usuario.nombre);