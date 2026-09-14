SUMMARY = "GNU Nano text editor"
HOMEPAGE = "https://www.nano-editor.org/"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=f27defe1e96c2e1ecd4e0c9be8967949"

SRC_URI = "https://www.nano-editor.org/dist/v7/nano-7.2.tar.xz"
SRC_URI[sha256sum] = "86f3442768bd2873cec693f83cdf80b4b444ad3cc14760b74361474fc87a4526"

DEPENDS = "file zlib ncurses"

# Inherit necessary classes for building Autotools-based packages
inherit pkgconfig gettext autotools

# Optional extra flags to pass to the configure script if needed
EXTRA_OECONF = ""
