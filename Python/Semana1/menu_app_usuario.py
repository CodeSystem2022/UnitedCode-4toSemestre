from capa_datos_persona.Usuario import Usuario
from logger_base import log
from capa_datos_persona.usuario_dao import UsuarioDAO

opcion = None
while opcion != 5:
    print('Opciones: ')
    print('1. Listar Usuarios: ')
    print('2. Agregar Usuarios: ')
    print('3. Modificar Usuarios: ')
    print('4. Eliminar Usuarios: ')
    print('5. Salir. ')
    opcion = int(input('Digite la opcion (1-5): '))
    if opcion == 1:
        usuarios = UsuarioDAO.seleccionar()
        for usuario in usuarios:
            log.info(usuario)
    elif opcion == 2:
        username_var = input('Digite el nombre de usuario: ')
        passwoord_var = input('Digite su contraseña: ')
        usuario = Usuario(username=username_var, password=passwoord_var)
        usuario_insertado = UsuarioDAO.insertar(usuario)
        log.info(f'Usuario insertado: {usuario_insertado}')
    
else:
    log.info('Salimos de la aplicacion, hasta pronto!!!')