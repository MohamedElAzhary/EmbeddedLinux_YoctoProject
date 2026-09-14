# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# Unable to find any files that looked like license statements. Check the accompanying
# documentation and source headers and set LICENSE and LIC_FILES_CHKSUM accordingly.
#
# NOTE: LICENSE is being set to "CLOSED" to allow you to at least start building - if
# this is not accurate with respect to the licensing of the software being built (it
# will not be in most cases) you must specify the correct value before using this
# recipe for anything other than initial testing/development!

############# Documentation Variables ##########

# Documentation Variables
SUMMARY = "This is a hello world native cpp recipe"
DESCRIPTION = "This is a hellow world native cpp recipe"
HOMEPAGE = "https://github.com/embeddedlinuxworkshop/y_t1/"

############# License Variables ################

# License Variables
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

############## Source Code Variables ###########

# Source Code URI
SRC_URI = "git://github.com/embeddedlinuxworkshop/y_t1;protocol=https;branch=master"

# Hash of checkedout commit
SRCREV = "49600e3cd69332f0e7b8103918446302457cd950"

# Source code to be downloaded here at S directory
S = "${WORKDIR}/git"

# NOTE: no Makefile found, unable to determine what needs to be done

############## BitBake Tasks #####################

do_configure () {
	# Specify any needed configure commands here
	:
}

# Set the build directory if needed (defaults to S if not specified)
B = "${S}"

do_compile () {
    # Ensure CXX and CXXFLAGS use the proper environment variables
    ${CXX} ${CXXFLAGS} ${B}/main.cpp -o helloworld ${LDFLAGS}
}

do_install () {
    # Create the destination directory explicitly
    install -d ${D}${bindir}
    
    # Install the compiled binary into the destination bin directory
    install -m 0755 ${B}/helloworld ${D}${bindir}/
}

