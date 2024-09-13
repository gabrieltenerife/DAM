//Creamos la funcion con el nombre de lo que crea la funcion con la primera en mayus siempre.
function Usuario (){
    this.id = 1;
    this.recuperarClave = function(){
        console.log("recuperar clave");
    }
}

let user = new Usuario ();