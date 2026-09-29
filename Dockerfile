# ============================================================
# Tu imagen personalizada para pruebas de automatización
# Basada en: markhobson/maven-chrome (jdk-21)
# Java 21 + Maven + Chrome + ChromeDriver
# ============================================================

FROM maven:3.9.15-eclipse-temurin-21

# --- Versiones que tú controlas ---
ARG CHROME_VERSION=147.0.7727.116-1
ARG CHROME_DRIVER_VERSION=147.0.7727.116

# --- Google Chrome ---
RUN apt-get update -qqy \
    && apt-get -qqy install gpg unzip wget \
    && wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add - \
    && echo "deb http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google-chrome.list \
    && apt-get update -qqy \
    && apt-get -qqy install google-chrome-stable=$CHROME_VERSION \
    && rm /etc/apt/sources.list.d/google-chrome.list \
    && rm -rf /var/lib/apt/lists/* /var/cache/apt/* \
    && sed -i 's/"$HERE\/chrome"/"$HERE\/chrome" --no-sandbox/g' /opt/google/chrome/google-chrome

# --- ChromeDriver ---
RUN wget -q -O /tmp/chromedriver.zip https://storage.googleapis.com/chrome-for-testing-public/$CHROME_DRIVER_VERSION/linux64/chromedriver-linux64.zip \
    && unzip /tmp/chromedriver.zip -d /opt \
    && rm /tmp/chromedriver.zip \
    && ln -s /opt/chromedriver-linux64/chromedriver /usr/bin/chromedriver

# --- Caché de Maven ---
ENV MAVEN_OPTS="-Dmaven.repo.local=/var/maven/.m2/repository"
RUN mkdir -p /var/maven/.m2/repository

# --- Directorio de trabajo ---
WORKDIR /app