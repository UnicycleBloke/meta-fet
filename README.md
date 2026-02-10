meta-fet
├── BUILD_INSTRUCTIONS.md
├── conf
│   ├── distro
│   │   └── karo-custom-fet.conf
│   └── layer.conf
├── COPYING.MIT
├── README
├── README.md
├── recipes-core
│   └── images
│       └── fet-image-minimal.bb
├── recipes-example
│   ├── example
│   │   ├── example_0.1.bb
│   │   └── hello-neil_0.1.bb
│   ├── hello-world
│   │   ├── files
│   │   │   └── hello_world.cpp
│   │   └── hello-world_1.2.bb
│   └── yagl
│       └── yagl_1.2.bb
└── recipes-kernel
    └── linux
        ├── linux-karo
        │   └── cfg
        │       └── ksz9477.cfg
        └── linux-karo_%.bbappend
