/**
 * Se pueden crear de las dos maneras, pero si lo creas con new String no te devuelve el valor 
 * directo dentro del String, debes utilizar el metodo valueOf.
 * Ocurre igual con el resto de variables.
 */

let a1 = "1+1";
 let a2 = new String ("1+1");

 console.log(a2.valueOf());