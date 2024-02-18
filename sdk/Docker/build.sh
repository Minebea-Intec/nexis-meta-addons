#!/bin/sh
PROXY="--build-arg http_proxy=$https_proxy --build-arg https_proxy=$https_proxy --build-arg HTTP_PROXY=$https_proxy --build-arg HTTPS_PROXY=$https_proxy"
#NOCACHE="--no-cache"
NOCACHE=""
docker build --tag "mi-yocto-nexis-$(id -u):latest" \
        --build-arg "UID=$(id -u)" \
        --build-arg "GID=$(id -g)" \
        $PROXY \
        $NOCACHE \
        --network host -f Dockerfile .
