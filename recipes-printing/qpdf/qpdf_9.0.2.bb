DESCRIPTION = "PDF transformation/inspection software"
HOMEPAGE = "http://qpdf.sourceforge.net"
LICENSE = "Artistic-2.0"
SECTION = "libs"
DEPENDS = "libpcre zlib jpeg"

SRC_URI = "https://github.com/qpdf/qpdf/archive/release-qpdf-${PV}.tar.gz"
SRC_URI += "file://libtool_syntax_problem.patch"

LIC_FILES_CHKSUM = "file://Artistic-2.0;md5=7806296b9fae874361e6fb10072b7ee3"
SRC_URI[md5sum] = "11a4d2b629092655b8635323c4c2b501"
SRC_URI[sha256sum] = "8877d49857b9dcb9a5232b537d2f9ef3d5c38138c81d744d76e97237b1d49be2"

inherit autotools-brokensep gettext

# disable random file detection for cross-compile
EXTRA_OECONF = " CPPFLAGS="-g0" \ 
		--with-random=/dev/urandom \
		--disable-static \
                "

EXTRA_OEMAKE_class-target = "LIBTOOL=${STAGING_BINDIR_CROSS}/${HOST_SYS}-libtool"

S="${WORKDIR}/${PN}-release-${PN}-${PV}"

# avoid Makefile returning error on 'make clean' before configure was run
CLEANBROKEN = "1"

do_configure_prepend() {
	sed -i "/docdir/d" "${S}"/make/libtool.mk
}

do_configure() {
    NOCONFIGURE=true ./autogen.sh --enable-gst-plugin
    oe_runconf
}

do_install_prepend() {

}

DEBIAN_NOAUTONAME_libqpdf = "1"

PACKAGES =+ "libqpdf"
FILES_libqpdf = "${libdir}/libqpdf.so.*"

RDEPEND_${PN} = "libqpdf"
