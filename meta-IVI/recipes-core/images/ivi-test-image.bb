# Include Base Image
require recipes-core/images/rpi-test-image.bb

# Image Info
SUMMARY = "IVI Test Image that include Raspberry Pi and HelloWorld Package"

# Image Installation and features
# In IMAGE_INSTALL we can add the packages that we want to include in our image
IMAGE_INSTALL:append = " helloworld openssh nano rpiplay"

IMAGE_FEATURE:append = " debug-tweaks"

inherit audio

