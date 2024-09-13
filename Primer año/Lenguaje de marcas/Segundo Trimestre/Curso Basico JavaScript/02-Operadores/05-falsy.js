//short-circuit

//FALSO
/**
 * false
 * 0
 * ''
 * null
 * undefined
 * NaN
 */

let nombre = ''
let user = nombre || 'UsuarioDefault' //User vale por nombre, o UsuarioDefault (EN CASO QUE NOMBRE = UNDEFINED)
console.log(user);

/*-------------------------------------------------*/

/**
 * La variable x imprime ambas funciones siempre que ambas sean true, si una es falsa solo devuelve la true, si ambas son false no imprime ninguna
 */

function fn1 (){
    console.log("funcion 1");
    return true;
}

function fn2 (){
    console.log("funcion 2");
    return true;
}

let x = fn1() && fn2();
console.log(x);