SUMMARY = "Star CUPS Driver Ver. 4.7.0 for linux"
HOMEPAGE = "https://star-emea.com"
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = "file://SoftwareLicenseAgreement.pdf;md5=fff2ebd554758ddab1f133c83785659c"

SRC_URI = " \
    file://${BPN}_src_${PV}.zip \
    file://Makefile \
    "

SECTION = "console/utils"
DEPENDS = "cups"

S = "${WORKDIR}/${BPN}"

do_configure[noexec] = "1"

do_compile () {
    cp ${WORKDIR}/Makefile ${S}/src
    cd src
    oe_runmake all
}

do_install() {
    install -m 0755 -d ${D}/usr/lib/cups/filter
    install -m 0755 ${S}/src/rastertostarm ${D}/usr/lib/cups/filter
    install -m 0755 -d ${D}/usr/share/ppd/cupsfilters
    install -m 0644 ${S}/ppd/sms230i.ppd ${D}/usr/share/ppd/cupsfilters
}

FILES_${PN} = " /usr/lib/cups/filter/rastertostarm /usr/share/ppd/cupsfilters/sms230i.ppd"
