# TODO_AL: This recipe (by its location) represents an image which can be built.
# I've based it on the default karo-minimal-image the example tells us to build.
# We can modify the image from here.
SUMMARY = "A custom image based on the Ka-Ro minimal image"

require recipes-core/images/karo-image-minimal.bb

# IMAGE_INSTALL:append = " \
#     python3-pip \
# "
