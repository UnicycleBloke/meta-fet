FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

# SRC_URI:append:stm32mpcommon  
# SRC_URI:append:stm32mp1 
SRC_URI:append = " file://cfg/ksz9477.cfg"

# Copied this notion from the linux-karo recipe. This is not mentioned in the notes at: 
# https://docs.yoctoproject.org/kernel-dev/common.html#creating-and-preparing-a-layer
# But the variable is documented here:
# https://docs.yoctoproject.org/ref-manual/variables.html#term-KERNEL_FEATURES
KERNEL_FEATURES:append:stm32mp15 = " ksz9477.cfg"
