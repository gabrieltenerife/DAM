//FOR 
for (let i = 0; i<100; i++){
    console.log(i);
}

//FOR OF
let animales = ["leon", "perro"]
for(let animal of animales){
    console.log(animal);
}

//FOR IN
 let user = {
    nombre: "Gabriel",
    contraseña: 123,
    id: 1,
 }

 for(let prop in user){
    console.log(prop,":",user[prop]);
 }