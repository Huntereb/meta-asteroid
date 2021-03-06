FILESEXTRAPATHS_prepend := "${THISDIR}/ofono:"
SRC_URI = "git://github.com/rilmodem/ofono;protocol=https \
           file://ofono.service \
           file://ofono \
           file://0001-Makefile.am-Fixes-include-paths.patch"
SRCREV = "efc9c0a85d32706bc088e449e847be41dcc73b3d"

S = "${WORKDIR}/git/"

DEPENDS += "c-ares"

do_install_append() {
    install -d ${D}/lib/systemd/system/
    cp ${WORKDIR}/ofono.service ${D}/lib/systemd/system/ofono.service
}
