#!/bin/sh
IMAGE=mi-yocto-nexis-$(id -u):latest
PROXY="-e http_proxy=$https_proxy -e https_proxy=$https_proxy -e HTTP_PROXY=$https_proxy -e HTTPS_PROXY=$https_proxy"

# add "-it" for interactive container
docker run --rm --privileged \
	--user $(id -u):$(id -g) \
	-v /home/yocto-sources:/home/yocto-sources \
	-v $PWD:/home/docker/nexis \
	--network host \
	${PROXY} \
	${IMAGE} $@
