# API REST Universidad - Arquitectura Hexagonal
API REST desarrollada en Java Spring Boot para gestión universitaria, implementando **Arquitectura Hexagonal**, con PostgreSQL y Docker.

## Descripción del Proyecto
Sistema backend para gestión de entidades universitarias desarrollado con:
- **Java 17** + **Spring Boot 3**
- **Arquitectura Hexagonal** (Puertos y Adaptadores)
- **PostgreSQL** - Base de datos
- **Docker** + **Docker Compose** - Contenerización
- **Maven** - Gestión de dependencias
  
## Arquitectura
Este proyecto implementa **Arquitectura Hexagonal** con las siguientes capas:

- **Dominio**: Entidades y l贸gica de negocio
- **Aplicacion**: Casos de uso y servicios
- **Infraestructura**: Adaptadores para base de datos, web, etc.
- **API REST**: Controladores y DTOs

## Características
- Arquitectura Hexagonal (Ports & Adapters)
- API RESTful completa
- Base de datos PostgreSQL con scripts de inicialización
- Contenerización con Docker
- Variables de entorno configurables

## Prerrequisitos

- **Docker** versión 20.10+ 
- **Docker Compose** versión 1.29+
- **Git** (para clonar el repositorio)

## Instalación y Ejecución

### 1. Clonar el repositorio
```bash
git clone https://github.com/aanampa/TEPSUP_ARQUITECTURA_HEXAGONAL.git
cd TEPSUP_ARQUITECTURA_HEXAGONAL




