# Use the latest MySQL image
FROM mysql

# Point to directory
WORKDIR /tmp

# Copy all the files to the working directory of the container
COPY world.sql /tmp/
# Copy the main world SQL file to docker-entrypoint-initdb.d.

#SQL scripts are ran here for the container
COPY world.sql /docker-entrypoint-initdb.d

# Set the root password for world db
ENV MYSQL_ROOT_PASSWORD example