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

python extend_recipe_sysroot:append() {
    # Hard-coded so that this image can only be built with karo-custom-neil distro. This was copies from 
    # the karo-minimal but I'm not sure it's really needed. Does no harm.
    if d.getVar('DISTRO') != 'karo-custom-neil':
        raise_sanity_error("cannot build '%s' with DISTRO '%s'" % (d.getVar('BPN'), d.getVar('DISTRO')), d)
}

