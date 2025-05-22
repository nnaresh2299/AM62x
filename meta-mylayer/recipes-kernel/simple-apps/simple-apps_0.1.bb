SUMMARY="simple c test application"
LICENSE = "MIT"
FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://simple.c"
 
S = "${WORKDIR}"

do_compile() {
    ${CC} ${CFLAGS} ${LDFLAGS} simple.c -o simple
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 simple ${D}${bindir}
}
