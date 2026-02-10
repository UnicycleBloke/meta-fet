DESCRIPTION      = "Yet Another GRF Language (yagl) application" 
LICENSE          = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
DEPENDS          = "libpng"
SRC_URI          = "git://github.com/UnicycleBloke/yagl.git;protocol=https;branch=main;tag=v1.2.3"
S                = "${WORKDIR}/git"

inherit pkgconfig cmake

do_install() {
    install -d ${D}${bindir}
    install -m 0755 yagl ${D}${bindir}
}