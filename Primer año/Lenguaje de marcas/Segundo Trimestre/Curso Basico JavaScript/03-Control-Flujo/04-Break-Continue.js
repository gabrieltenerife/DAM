let i = 0;


//SE SALTA ESA EJECUCION NO IMPRIME 2 EN ESTE CASO
while (i<10){
    i++;
    
    if(i === 2)
        continue;

    if(i=7)
        break;

    console.log(i);
}

