# Place holder for build instructions for the distro

```bash
repo init -u git@github.com:UnicycleBloke/fet-bsp -b scarthgap
repo sync 

# For some reason I was entering qsbase4 - I think the KaRo site confused me.
# I think this has buggered up the booting on the board, so I don't know how I was able
# to test it before. Did I run it under qemu? I don't remember this.
KARO_BASEBOARD=qsbase1
DISTRO=karo-custom-fet MACHINE=qsmp-1570 source karo-setup-release.sh -b build-custom-fet
```

To connect to the board:
- Connect an FTDI cable to the board. This comes up as /dev/ttyUSB0.
- Use Putty or whatever to create a console on the board.

To flash the board:
- In the console, boot the board and stop it in uboot mode.
- enter `fastboot usb 0` - the board with now wait for commands.
- On the PC, `cd` to `tmp/deploy/images/qsmp-1570/fet-image-minimal`.
- Enter sudo `uuu -v` - the script is in `uuu.auto` (I think).
- The console shows the device being written with `bootfs` and `rootfs` (long).
- When it's done, type `reset` on the console to reboot the board.
- User name for now is `root` and password is blank.
  - TODO_AC How to change the default user name and password?