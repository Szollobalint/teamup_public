# Stage 1: Build the React app using Vite
FROM node:20 AS build

# Set the working directory
WORKDIR /app

# Copy package.json and package-lock.json to the working directory
COPY package*.json ./

# Install dependencies
RUN npm install

# Copy the rest of the application code
COPY . .

# Build the application
RUN npm run build

# Debug: List the contents of the /app directory
RUN ls -la /app

# Debug: List the contents of the /app/dist directory
RUN ls -la /app/dist

# Stage 2: Serve the app with nginx
FROM nginx:alpine

# Copy the built files from the previous stage to the nginx html directory
COPY --from=build /app/dist /usr/share/nginx/html

# Expose port 80
EXPOSE 5173

# Start nginx
CMD ["nginx", "-g", "daemon off;"]
