SUMMARY="simple my c test application"
LICENSE = "MIT"
FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://myc.c"
 
S = "${WORKDIR}"

do_compile() {
    ${CC} ${CFLAGS} ${LDFLAGS} myc.c -o myc
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 myc ${D}${bindir}
}
