# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   LICENSE
#   lib/llhttp/LICENSE-MIT
#   lib/playfair/LICENSE.md
# Recipe created by recipetool
#
LICENSE = "GPL-3.0-only & MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464 \
                    file://lib/llhttp/LICENSE-MIT;md5=f5e274d60596dd59be0a1d1b19af7978 \
                    file://lib/playfair/LICENSE.md;md5=c7cd308b6eee08392fda2faed557d79a"

SRC_URI = "git://github.com/FD-/RPiPlay.git;protocol=https;branch=master;name=rpiplay;destsuffix=git;submodules=1 \
           git://github.com/raspberrypi/userland.git;protocol=https;branch=master;name=userland;destsuffix=userland-src"

PV = "1.0+git${SRCPV}"
SRCREV_rpiplay  = "64d0341ed3bef098c940c9ed0675948870a271f9"
SRCREV_userland = "a54a0dbb2b8dcf9bafdddfc9a9374fb51d97e976"
SRCREV_FORMAT = "rpiplay_userland"

S = "${WORKDIR}/git"

DEPENDS = "openssl avahi libplist userland"

inherit cmake pkgconfig

CFLAGS += "-I${STAGING_INCDIR}/avahi-compat-libdns_sd"
CXXFLAGS += "-I${STAGING_INCDIR}/avahi-compat-libdns_sd"

# Symbols like vc_dispmanx_display_open live in libvchostif.so, which
# libbcm_host.so/libvcos.so only pull in as a *transitive* DT_NEEDED
# dependency, not something RPiPlay's CMakeLists.txt links directly.
# Modern binutils defaults to --no-copy-dt-needed-entries and won't
# resolve symbols through another lib's indirect dependency, and simply
# appending "-lvchostif" doesn't help because CMake places LDFLAGS-derived
# linker flags at the START of the link line, before the objects that
# actually need it. Restoring the old transitive-resolution behavior
# sidesteps the ordering problem entirely.
LDFLAGS += "-Wl,--copy-dt-needed-entries"

EXTRA_OECMAKE = ""

do_configure:prepend() {
    install -d ${RECIPE_SYSROOT}/opt/vc/src/hello_pi/libs/ilclient
    cp ${WORKDIR}/userland-src/host_applications/linux/apps/hello_pi/libs/ilclient/*.c \
       ${WORKDIR}/userland-src/host_applications/linux/apps/hello_pi/libs/ilclient/*.h \
       ${RECIPE_SYSROOT}/opt/vc/src/hello_pi/libs/ilclient/
}
