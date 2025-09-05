# ITG Product API App - Caso Práctico

Esta aplicación Android es una implementación para un caso práctico que demuestra la habilidad para consumir una API REST, presentar la información en una interfaz de usuario moderna y seguir buenas prácticas de desarrollo en Kotlin para Android.

## Objetivo del Ejercicio

El objetivo principal es construir una aplicación que:
1.  Consuma una API de listado de productos.
2.  Muestre los productos en una vista de lista.
3.  Permita al usuario seleccionar un producto de la lista.
4.  Muestre la información detallada del producto seleccionado.
5.  Implemente un flujo de navegación específico donde la información del producto seleccionado pueda ser retornada a una vista anterior.

## Características Implementadas

*   **Consumo de API de Productos:** Se conecta a un endpoint para obtener un listado de productos.
*   **Visualización de Productos:**
    *   Muestra una lista de productos en tarjetas (cards).
    *   Cada tarjeta incluye: imagen del producto, nombre, precio y categoría.
    *   Carrusel de imágenes en la vista detallada si un producto tiene múltiples imágenes.
*   **Navegación:** Implementa navegación entre una pantalla de listado y la pantalla de detalle (antalla inicial).
*   **Arquitectura en Capas:**
    *   **Capa de Datos:** Responsable de la obtención de datos desde la API (Retrofit, Repositorio).
    *   **Capa de Casos de Uso (Use Cases/Interactors):** Encapsula la lógica de negocio específica (Ej: `GetProductsUseCase`).
    *   **Capa de Vista (UI):** Construida con Jetpack Compose, utilizando ViewModels para gestionar el estado y la lógica de la UI.
*   **Inyección de Dependencias:** Utiliza Hilt para gestionar las dependencias a lo largo de la aplicación.
*   **Manejo de Estados:** La UI reacciona a diferentes variables de estado de las operaciones de datos (Cargando, Exitoso, Error).
*   **Single Activity:** La aplicación sigue un patrón de actividad única con múltiples pantallas gestionadas por Navigation Compose.

## Tecnologías y Bibliotecas Utilizadas

*   **Kotlin:** Lenguaje de programación principal.
*   **Jetpack Compose:** Para la construcción de la interfaz de usuario de forma declarativa.
*   **Retrofit:** Para realizar llamadas de red y consumir la API REST.
*   **OkHttp & Gson Converter:** Para la configuración de Retrofit y el parseo de JSON (o `kotlinx.serialization` si se ha configurado explícitamente).
*   **Coroutines:** Para la gestión de operaciones asíncronas.
*   **ViewModel (Jetpack):** Para almacenar y gestionar datos relacionados con la UI de forma consciente del ciclo de vida.
*   **Navigation Compose:** Para la navegación entre las diferentes pantallas de la aplicación.
*   **Hilt:** Para la inyección de dependencias.
*   **Coil:** Para la carga y visualización de imágenes desde URLs.
*   **`kotlinx.serialization`:** Para la serialización/deserialización de objetos Kotlin (usado en la navegación y potencialmente en la capa de red).

## Arquitectura

La aplicación sigue una arquitectura limpia (o inspirada en ella) con las siguientes capas principales:

1.  **UI (Presentación):** Compuesta por Composable (pantallas y componentes), ViewModels y la lógica de navegación.
2.  **Domain (Casos de Uso):** Contiene la lógica de negocio. Los Casos de Uso son llamados por los ViewModels y orquestan la obtención de datos desde la capa de Datos.
3.  **Data:** Incluye Repositorios, fuentes de datos (API Service con Retrofit) y modelos de datos.

## Estructura del Proyecto (Ejemplo)
com.example.itgproductapiapp/

├── data/                 # Capa de Datos

│   ├── api/              # Clases relacionadas con la API (Retrofit, Modelos JSON)

│   │   ├── model/        # Data classes para las respuestas de la API

│   │   └── ProductApi.kt # Interfaz de Retrofit

│   ├── di/               # Módulos de Hilt para la capa de datos

│   └── repository/       # Implementaciones de Repositorio

├── domain/               # Capa de Dominio/Casos de Uso

│   ├── model/            # Modelos de dominio (opcional, si difieren de los de la API)

│   ├── repository/       # Interfaces de Repositorio

│   └── usecase/          # Clases de Casos de Uso

├── ui/                   # Capa de UI (Presentación)

│   ├── components/       # Composable reutilizables (ej. ProductCard)

│   ├── di/               # Módulos de Hilt para la capa de UI

│   ├── navigation/       # Configuración de Navigation Compose y rutas serializables

│   ├── screens/          # Composable que representan pantallas completas

│   ├── theme/            # Tema de la aplicación (colores, tipografía)

│   └── viewmodel/        # ViewModels

├── utils/                # Clases de utilidad

└── MainActivity.kt       # Actividad única que aloja el NavHos


## URL de la API

La aplicación consume la siguiente API para obtener el listado de productos:

`http://alb-dev-ekt-875108740.us-east-1.elb.amazonaws.com/apps/moviles/caso-practico/plp`

## Cómo Empezar

1.  Clona este repositorio: `git clone [URL_DEL_REPOSITORIO_AQUI]`
2.  Abre el proyecto en Android Studio (versión recomendada: Iguana | 2023.2.1 o más reciente).
3.  Asegúrate de tener un emulador configurado o un dispositivo Android conectado.
4.  Sincroniza el proyecto con los archivos Gradle.
5.  Ejecuta la aplicación.

## Futuras Mejoras (Opcional)

*   Implementación de persistencia local (Room) para cachear datos.
*   Pruebas unitarias y de UI.
*   Manejo de errores más detallado y específico en la UI.
*   Animaciones de transición más elaboradas.

Video Evidencia Adjunta: https://drive.google.com/file/d/1PFSShRVACT_ehYFWaGXu4_iiznmLiI9p/view?usp=sharing
