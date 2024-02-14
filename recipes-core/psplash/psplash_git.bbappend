FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SPLASH_IMAGES = "file://my-custom-psplash.png;outsuffix=default"

SRC_URI += " \
    file://0003-nexis-colors-scheme.patch \
"