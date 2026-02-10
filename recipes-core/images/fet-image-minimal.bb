# Original file: layers/meta-karo-distro/recipes-core/images/karo-image-minimal.bb

# SUMMARY = "A minimal Linux system without graphics support."
# require karo-image.inc 
# require karo-minimal.inc
# IMAGE_ROOTFS_MAXSIZE ??= "${@bb.utils.contains('MACHINE_FEATURES',"nand","65536","",d)}"
# python extend_recipe_sysroot:append() {
#     if d.getVar('DISTRO') != 'karo-minimal':
#         raise_sanity_error("cannot build '%s' with DISTRO '%s'" % (d.getVar('BPN'), d.getVar('DISTRO')), d)
# }


# This is a modified copy of layers/meta-karo-distro/recipes-core/images/karo-image-minimal.bb
SUMMARY = "A minimal Linux system without graphics support. Based on karo-image-minimal"

# I previously pulled in karo-image-minimal.bb directly (following KaRo example 
# https://karo-electronics.github.io/docs/yocto-guide/mainline/customizing.html#create-custom-image)
# but that broke the custom build because the expected name of the distro was hard-coded.
# Note that the paths needed to be qualified to find the include file.
require recipes-core/images/karo-image.inc 
require recipes-core/images/karo-minimal.inc

IMAGE_ROOTFS_MAXSIZE ??= "${@bb.utils.contains('MACHINE_FEATURES',"nand","65536","",d)}"

# TODO_AC Is this the right place for this? Modeled on karo-distro/recipes-core/images/karo-image-x11.bb
# Chech the syntax for assignments. In this case the space is important.
IMAGE_INSTALL:append = " hello-world"
IMAGE_INSTALL:append = " yagl"

# TODO_AC Incredible! The ridiculous parser fails if the { is on the following line. 
# I so fucking hate Linux developers for their smug presumption.
python extend_recipe_sysroot:append() {
    # Hard-coded so that this image can only be built with karo-custom-fet distro. This was copies from 
    # the karo-minimal but I'm not sure it's really needed. Does no harm.
    if d.getVar('DISTRO') != 'karo-custom-fet':
        raise_sanity_error("neil-image-minimal.bb: cannot build '%s' with DISTRO '%s'" % (d.getVar('BPN'), d.getVar('DISTRO')), d)
}
