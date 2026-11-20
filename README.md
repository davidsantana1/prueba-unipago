# Prueba técnica Unipago
CRUD de películas. Fuente principal consultada: [Documentación de Kotlin](https://kotlinlang.org/docs/jvm-get-started-spring-boot.html).
Se puede usar el archivo ./requests.http para probarlo localmente o Postman.

## Schema de la tabla de películas

```
CREATE TABLE IF NOT EXISTS movies (
    id              VARCHAR(60)     DEFAULT RANDOM_UUID() PRIMARY KEY,
    title           VARCHAR         NOT NULL,
    release_year    INT             NULL,
    status          VARCHAR(9)      NOT NULL
);
```

Como se dijo al presentar el ejercicio, se puso un campo nullable (```release_year```) y se utilizó status para hacer un soft delete en lugar de un delete regular. Elegí hacer el cambio de status con un string pero otra opción hubiera sido un booleano con is_deleted o un campo con ```deleted_at``` que si está null signifique que no fue eliminado, y de lo contrario, que si lo fue.
