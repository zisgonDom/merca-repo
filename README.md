# merca-repo

#Proyecto Gradle
#Para ejecutar este proyecto deberá importarse en su IDE.

#Está configurado para que el servidor interno se ponga en marcha desde el puerto 8001.
#En caso de que dicho puerto este ocupado, se puede editar dicha configuración entrando en el fichero 'application.propperties' y cambiando las lineas dictadas a continuación:
    - server.port=8001
 #por ejemplo
    - server.port=9001

#Este proyecto consta de una API-REST, operaciones CRUD,así como tambien, pruebas sobre la API mediante POSTMAN.

#Para realizar las pruebas sobre la API-REST,
#se debera importar el archivo 'Juego de pruebas - MERCADONA.postman_collection.json'. Ya que se ha implementado un factor de seguridad mediante JWT, se debera ejecutar la primera petición para poder recibir el JwtToken y así incorporarlo en las demas peticiones.
