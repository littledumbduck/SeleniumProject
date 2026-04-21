# Selenium Automation Project - SauceDemo

Este proyecto consiste en la automatización de pruebas para la plataforma de prácticas **SauceDemo** utilizando **Selenium WebDriver**, **Java** y **JUnit 5**. El objetivo principal es validar el flujo de autenticación y la gestión de productos en el carrito de compras aplicando el patrón de diseño **Page Object Model (POM)**.

## 🚀 Tecnologías Utilizadas

* **Java**: Lenguaje de programación principal.
* **Selenium WebDriver**: Para la interacción y automatización del navegador.
* **JUnit 5**: Framework de pruebas para la ejecución de casos de test y aserciones.
* **Maven**: Gestión de dependencias y construcción del proyecto.
* **Chrome WebDriver**: Driver para la ejecución de pruebas en el navegador Google Chrome.

## 🏗️ Estructura del Proyecto (Page Object Model)

El proyecto está organizado siguiendo el patrón **POM**, separando la lógica de los elementos de la página de la lógica de las pruebas:

* **Pages**: Contienen los selectores y los métodos que interactúan con la interfaz de usuario.
* **Tests**: Contienen los casos de prueba y las verificaciones (asserts).

### Clases de Página (src/main/java)
1.  **LoginPage**:
    * Métodos para introducir nombre de usuario y contraseña.
    * Método para hacer clic en el botón de login.
    * Función `loginToSauceDemo(user, pass)` para realizar el proceso completo en una sola llamada.
2.  **InventoryPage**:
    * Métodos para añadir productos específicos al carrito.
    * Método para obtener el número de artículos mediante el contador del carrito (`shopping_cart_badge`).
    * Método para verificar el texto de los botones (cambio de "Add to cart" a "Remove").

### Clases de Prueba (src/test/java)
1.  **LoginTest**:
    * `loginCorrecto()`: Valida que un usuario válido accede a la URL de inventario.
    * `loginIncorrecto()`: Valida que aparece un mensaje de error con credenciales inválidas.
2.  **InventoryTest**:
    * `anadirUnProductoAlCarrito()`: Verifica que el contador sube a 1 al añadir un producto.
    * `anadirDosProductosAlCarrito()`: Verifica que el contador sube a 2 al añadir dos productos.
    * `botonCambiaTrasAnadirProducto()`: Comprueba que el texto del botón cambia dinámicamente al interactuar.

## 🛠️ Configuración y Ejecución

Las pruebas utilizan las anotaciones de ciclo de vida de JUnit 5:
* `@BeforeEach`: Inicializa el WebDriver de Chrome y navega a la URL base antes de cada test.
* `@AfterEach`: Cierra el navegador al finalizar cada prueba para liberar recursos.

### Requisitos previos
* Java JDK 11 o superior.
* Maven instalado.
* Google Chrome instalado.

### Reflexión final

A través de esta tarea, he profundizado en la importancia del patrón Page Object Model, ya que permite que el código sea mucho más mantenible y legible. Si la estructura de la web cambia, en principio no se debería cambiar nada ya que los elementos elegidos para posicionarnos en la página son los "id" y los "test", cosa que los desarrolladores de frontend no deberían cambiar en principio. Además, he practicado el manejo de esperas y la importancia de las aserciones precisas para garantizar que la automatización realmente valide el comportamiento del software y no solo realice acciones mecánicas. Ha sido fundamental entender el ciclo de vida de los tests (@BeforeEach/@AfterEach) para asegurar un entorno de pruebas limpio en cada ejecución.
