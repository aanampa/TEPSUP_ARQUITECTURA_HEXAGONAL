# Stage 1: Build the Angular app
FROM node:20-alpine AS build
WORKDIR /app

# Copiar archivos de package desde la subcarpeta universidad
COPY universidad/package*.json ./

# Instalar dependencias
RUN npm install

# Copiar código fuente desde la subcarpeta universidad
COPY universidad/ .

# Construir la aplicación Angular
RUN npm run build -- --configuration=production

# Stage 2: Serve with nginx
FROM nginx:alpine
COPY nginx.conf /etc/nginx/nginx.conf
COPY --from=build /app/dist/universidad/browser /usr/share/nginx/html

EXPOSE 80