FROM ubuntu:18.04
MAINTAINER Embedded Software <embedded-software@minebea-intec.com>

#ENV HTTP_PROXY http://127.0.0.1:3128
#ENV HTTPS_PROXY http://127.0.0.1:3128
#RUN export http_proxy=$HTTP_PROXY
#RUN export https_proxy=$HTTPS_PROXY

# Set environment variables
ENV TERM xterm-256color

ARG DEBIAN_FRONTEND=noninteractive

ENV TZ=Europe/Berlin

RUN apt-get update && apt-get upgrade -y

# Install essentials
RUN apt-get install -y \
            gawk wget git-core diffstat unzip texinfo gcc-multilib \
            build-essential chrpath socat cpio python python3 python3-pip python3-pexpect \
            xz-utils debianutils iputils-ping python3-git python3-jinja2 libegl1-mesa libsdl1.2-dev \
            pylint3 xterm python3-subunit mesa-common-dev \
            apt-utils \
            locales curl tree vim bash-completion screen \
            rsync bc libncurses-dev \
            libusb-1.0-0-dev \
            picocom psmisc

# use bash instead of dash
RUN ln -sf bash /bin/sh

ARG GID=1000
ARG UID=1000
ENV USER_NAME docker

# Create non-root user
RUN groupadd -g $GID $USER_NAME
RUN useradd -u $UID -g $GID --create-home --shell /bin/bash $USER_NAME
RUN usermod -aG sudo $USER_NAME
RUN chown -R $USER_NAME:$USER_NAME /home/

RUN locale-gen en_US.UTF-8 && update-locale LC_ALL=en_US.UTF-8 LANG=en_US.UTF-8

ENV LANG en_US.UTF-8
ENV LC_ALL en_US.UTF-8

# set user to use
#USER $USER_NAME
WORKDIR /home/$USER_NAME

USER $USER_NAME

# work dir
WORKDIR /home/$USER_NAME/nexis


