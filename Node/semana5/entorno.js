
let nombre = process.env.NOMBRE || 'Sin nombre';
let web = process.env.MI_WEB || 'No tengo Web';

console.log('Hello '+ nombre);
console.log('Mi web es:  '+ web);