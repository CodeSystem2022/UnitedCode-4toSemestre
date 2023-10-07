import math
from decimal import Decimal

# manejo de valores infinitos
infinito_positivo = float('inf')
print(f'Infinito positivo: {infinito_positivo}')
print(f'Es infinito?: {math.isinf(infinito_positivo)}')

infinito_negativo = float('-inf')
print(f'Infinito negativo:{infinito_negativo}')
print(f'Es infinito?:{math.isinf(infinito_negativo)}')

#Modulo marth
infinito_positivo = math.inf
print(f'infinito psositivo:{infinito_positivo}')
print(f'Es infinito?:{math.insinf(infinito_positivo)}')

infinito_negativo = math.inf
print(f'infinito negativo:{infinito_negativo}')
print(f'Es infinito?:{math.insinf(infinito_negativo)}')

# Modulo decimal
infinito_positivo = Decimal('Infinity')
print(f'infinito psositivo:{infinito_positivo}')
print(f'Es infinito?:{math.insinf(infinito_positivo)}')

infinito_negativo = Decimal('-Infinity')
print(f'infinito negativo:{infinito_negativo}')
print(f'Es infinito?:{math.insinf(infinito_negativo)}')

