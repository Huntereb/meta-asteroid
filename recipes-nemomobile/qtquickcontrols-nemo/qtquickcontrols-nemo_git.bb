SUMMARY = "Glacier components for Nemomobile, based on QtQuickControls"
HOMEPAGE = "https://github.com/nemomobile/qtquickcontrols-nemo.git"
LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM = "file://COPYING.LIB;md5=4193e7f1d47a858f6b7c0f1ee66161de"

SRC_URI = "git://github.com/nemomobile/qtquickcontrols-nemo.git;protocol=https"
SRCREV = "da72638aeaab5b596258b7e172b3cc8828057d57"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "qtquickcontrols"
RDEPENDS_${PN} += "qtquickcontrols-qmlplugins"

do_configure_prepend() {
    sed -i "s@\$\$\[QT_INSTALL_QML\]/\$\$PLUGIN_IMPORT_PATH/themes@/usr/lib/qml/QtQuick/Controls/Styles/Nemo/themes@" ${S}/src/styles/styles.pro
    sed -i "s@src examples@src@" ${S}/qtquickcontrols-nemo.pro
}

FILES_${PN} += "/usr/lib"
FILES_${PN}-dbg += "/usr/lib/examples/.debug/ /usr/lib/qml/QtQuick/Controls/Nemo/.debug/ /usr/lib/qml/QtQuick/Controls/Styles/Nemo/.debug/"
