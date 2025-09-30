# Template PC_1

Este proyecto es un backend desarrollado con Spring Boot que implementa autenticación, autorización y gestión de usuarios. A continuación se describen brevemente los principales componentes:

## Estructura principal
- **Autenticación y Autorización:**
  - Controladores y servicios para login y manejo de JWT.
  - Jerarquía de roles configurada (ejemplo: `ADMIN > USER`).
  - Filtros y configuración de seguridad personalizada.
- **Gestión de Usuarios:**
  - CRUD de usuarios con roles.
  - Repositorio para persistencia de usuarios.
- **Excepciones:**
  - Manejador global de excepciones.
  - Clases para errores específicos (conflicto, no autorizado, etc.).
- **DTOs:**
  - Objetos de transferencia para login, respuesta JWT y creación de usuarios.
- **Configuración:**
  - Archivos y clases para configuración general y de seguridad.

## Endpoints principales
- `/api/auth/login`: Autenticación de usuarios y generación de JWT.
- `/api/user`: Gestión de usuarios (requiere permisos).
- Endpoints protegidos por roles usando anotaciones como `@PreAuthorize`.

## Utilidad de la jerarquía de roles
El bean `RoleHierarchy` permite que usuarios con rol superior (ej. `ADMIN`) accedan a endpoints de roles inferiores (ej. `USER`).

## Otros
- Archivos de configuración en `resources`.
- Pruebas unitarias básicas en la carpeta `test`.

Para más detalles, revisa la estructura de carpetas y los archivos fuente.
