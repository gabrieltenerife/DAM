function suma(){
    return 2+2;
}

let resultado = suma();
console.log(resultado);
console.log(suma());
/* ------------------------------------- */

function resta (a){
    return a-2;
}


// LOS DATOS QUE SE LE PASA A LAS FUNCIONES SE LLAMAN ARGUMENTOS
resultado = resta(5);
console.log(resultado);
console.log(arguments); // Imprime un array con los argumentos (no recomendado)
