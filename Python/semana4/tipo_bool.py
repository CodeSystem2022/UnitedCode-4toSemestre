
# Bool contiene los valores de True y False
# Los tipos numéricos, es false para el 0 (cero), true para los demás valores
valor = 0
resultado = bool(valor)
print(f'valor: {valor}, Resultado: {resultado}')

valor = 0.1
resultado = bool(valor)
print(f'valor: {valor}, Resultado: {resultado}')




# ciclos
variable = 17
while variable:
    print('regresa verdadero')
    break
else:
    print('regresa falso')








# Tipo colecciones -> False para colecciones vacias
# Tipo colecciones -> True para todas las demás
# Lista
valor = []
resultado = bool(valor)
print(f'valor de una lista vacia: {valor}, resultado: {resultado}')

valor = [5,7,9]
resultado = bool(valor)
print(f'valor de una lista con elementos: {valor}, resultado: {resultado}')

# Tupla
valor = ()
resultado = bool(valor)
print(f'valor de una tupla vacía: {valor}, resultado: {resultado}')

valor = (3,)
resultado = bool(valor)
print(f'valor de una tupla con elementos: {valor}, resultado: {resultado}')

# Diccionario
valor = {}
resultado = bool(valor)
print(f'valor de un diccionario vacio: {valor}, resultado: {resultado}')

valor = {'Nombre': 'Enzo', 'Apellido': 'Fernandez'}
resultado = bool(valor)
print(f'valor de un diccionario con elementos: {valor}, resultado: {resultado}')

































# Sentencia de control con bool
if (1,):
    print('Regresa verdadero')
else:
    print('Regresa Falso')
