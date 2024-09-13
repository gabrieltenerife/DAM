let temperatura = document.querySelector("#temperatura");
let botoncalcular = document.querySelector("#botoncalcular");
let botonlimpiar = document.querySelector("#botonlimpiar");
let parrafo = document.querySelector("#parrafo");
let resultado;

botoncalcular.addEventListener("click",()=>{
if (temperatura.value.length == "0")
    alert("Escribe una temperatura")
else
    resultado = (temperatura.value * 1.8) + 32;
    parrafo.textContent = `${temperatura.value} en Celsius equivalen a ${resultado} en Fahrenheit`;
    temperatura.value = "";
})

botonlimpiar.addEventListener("click",()=>{
    temperatura.value = "";
})