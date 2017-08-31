# Set the base image to java8
FROM openjdk:8-alpine

# File Author / Maintainer
MAINTAINER Jorge Acetozi

# Define default environment variables
ENV NOTEPAD_HOME=/opt/notepad
ENV NOTEPAD_BINARIES=/opt/notepad/bin

# Create directory
RUN mkdir -p $NOTEPAD_BINARIES

# Set default directory
WORKDIR $NOTEPAD_HOME

# Copy notepad jar file
COPY target/*.jar $NOTEPAD_HOME/notepad.jar

# Add initialization script
ADD entrypoint.sh $NOTEPAD_BINARIES/entrypoint.sh

# Give permissions
RUN chmod 755 $NOTEPAD_BINARIES/entrypoint.sh

# Expose default servlet container port
EXPOSE 8080

# Main command
ENTRYPOINT ["/bin/sh", "/opt/notepad/bin/entrypoint.sh"]
