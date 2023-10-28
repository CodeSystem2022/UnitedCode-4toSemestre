function hola(nombre){
    return new Promise(function (resolve, reject) {
        setTimeout(function() {
            console.log('Hola '+nombre);
            resolve(nombre);
        }, 1000);
    });
    
}

function hablar(callbackHablar){
    setTimeout(function() {
        console.log('Hola bla bla ')
        callbackHablar();
    }, 1000);
}

function adios(nombre, otroCallback) {
    setTimeout(function() {
        console.log('Adios '+ nombre);
        otroCallback();
    }, 1500);
} 

console.log('Iniciando el proceso...');
hola('Mariel')
    .then((nombre) => {
        console.log('Terminando el proceso');
    })