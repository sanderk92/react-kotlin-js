FROM nginx:alpine
COPY build/distributions/ /usr/share/nginx/html/dashboard
COPY nginx/nginx.conf /etc/nginx/conf.d/default.conf
