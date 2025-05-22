SUMMARY = "Marvell WiFi driver (mwifiex)"
DESCRIPTION = "Out-of-tree driver for Marvell WiFi chipsets"

LICENSE = "MIT"
FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI += " \
    file://Makefile \
    file://mlan/ \
    file://mlinux/ \
"
S = "${WORKDIR}"
inherit module

# Optional: Specify kernel module dependencies
# DEPENDS += "virtual/kernel"

# If using kernel module class
EXTRA_OEMAKE += "KERNELDIR=${STAGING_KERNEL_DIR}"

do_compile() {
    oe_runmake
}

do_install() {
    install -d ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/extra
    install -m 0644 mlan.ko ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/extra
    install -m 0644 moal.ko ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/extra

}

# Allow kernel module to be auto-loaded
FILES_${PN} += "${nonarch_base_libdir}/modules/${KERNEL_VERSION}/extra"
