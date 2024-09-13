const user = {id:1,}

//Añadiendo propiedades al objeto a posterori;
user.nombre = "Juan";
user.recuperardata = function(){console.log("Recuperando dato")}

//Eliminando propiedades
delete user.nombre;

//Podemos hacer que no se puedan cambiar las PROPIEDADES ni VALORES a un objeto:
const user1 = Object.freeze({id: 1, nombre: "Gabriel",});

//Podemos hacer que no se puedan cambiar las PROPIEDADES pero si los valores a un objeto:
let user2 = Object.seal({id:1, nombre:"Gabriel",});