let nombre = "Gabriel";
let apellido = "Gonzalez";
let edad = "21";

let persona = {
    nombre: "Gabriel",
    apellido: "Gonzalez",
    edad: 21,
};

//ACCEDER A LAS PROPIEDADES DEL OBJETO
console.log(persona);
console.log(persona.nombre);
console.log(persona['nombre']);

//MODIFICAR LOS VALORES DEL OBJETO
persona.nombre = "Juan";
persona["edad"] = 22;
console.log(persona.nombre);
console.log(persona.edad);

//ELIMINAR PROPIEDADES DEL OBJETO
delete persona.edad;
console.log(persona);