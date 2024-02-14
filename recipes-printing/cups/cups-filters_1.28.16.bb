include cups-filters.inc

#SRC_URI = "https://github.com/Distrotech/${PN}/archive/release-1-5-0.tar.gz"
LIC_FILES_CHKSUM = "file://COPYING;md5=2d77679ce6a2cc4d873d4ebbf2a401e6"
SRC_URI[md5sum] = "c9800c11ed7dd694fc3298440fcd97c7"
SRC_URI[sha256sum] = "0ca77bb820719a040ff003ecb478d0c2ceffc94e8bd1cd03ddb5a199444127ba"
EXTRA_OECONF_append = " --disable-exif"
