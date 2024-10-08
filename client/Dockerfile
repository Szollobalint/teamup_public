# Stage 1: Build the application
FROM node:20 AS build

WORKDIR /app

# Copy package.json and package-lock.json if available
COPY package*.json ./

# Install dependencies
RUN npm install

# Copy the rest of the application source code
COPY . .

# Build the application
RUN npm run build

# Stage 2: Serve the application using Nginx
FROM nginx:alpine

# Copy the built application from the build stage
COPY --from=build /app/dist /usr/share/nginx/html

# Copy the Nginx configuration file
COPY ./default.conf /etc/nginx/conf.d/default.conf

# Expose the port the app runs on
EXPOSE 5173

# Start Nginx
CMD ["nginx", "-g", "daemon off;"]
