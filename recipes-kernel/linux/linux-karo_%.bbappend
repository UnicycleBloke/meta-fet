FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

# SRC_URI:append:stm32mpcommon  
# SRC_URI:append:stm32mp1 
SRC_URI:append = " file://cfg/ksz9477.cfg"
#SRC_URI:append = " file://dts/stm32mp15-qsmp-ksz9563.dts"

# Copied this notion from the linux-karo recipe. This is not mentioned in the notes at: 
# https://docs.yoctoproject.org/kernel-dev/common.html#creating-and-preparing-a-layer
# But the variable is documented here:
# https://docs.yoctoproject.org/ref-manual/variables.html#term-KERNEL_FEATURES
KERNEL_FEATURES:append:stm32mp15  = " ksz9477.cfg"

DTB_OVERLAYS_generic:append:qsmp  = " qsmp-ksz9563"

KARO_DTB_OVERLAYS[qsbase1] += "qsmp-ksz9563"

# KARO_BASEBOARDS:append:qsmp-1570 ?= "\
#         qsmp-ksz9563 \
# "
