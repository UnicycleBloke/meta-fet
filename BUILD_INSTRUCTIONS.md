# Place holder for build instructions for the distro


repo init -u git@github.com:UnicycleBloke/fet-bsp -b scarthgap
repo sync 

KARO_BASEBOARD=qsbase4
DISTRO=karo-custom-fet MACHINE=qsmp-1570 source karo-setup-release.sh -b build-custom-fet

