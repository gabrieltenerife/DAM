
/**
 * Puedes asignar variables a una funcion, asi como puedes pasar funciones como parametro
 * para otra funcion.
 */

let nombre;

function usuarios (Nombre) {
    this.nombre;
}

let u = usuarios;
let user = new u("Gabriel");

function of (Fn, arg){
    return new Fn(arg);
}

let user1 = of(usuarios, "Juan");
console.log(user1);