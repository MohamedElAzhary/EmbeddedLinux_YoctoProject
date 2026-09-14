# Add sysvinit as a feature
DISTRO_FEATURES:append = " sysvinit"

# Prevent systemd from being pulled into the build
DISTRO_FEATURES_BACKFILL_CONSIDERED += "systemd"

# Force the system to use sysvinit
INIT_MANAGER = "sysvinit"
VIRTUAL-RUNTIME_init_manager = "sysvinit"
VIRTUAL-RUNTIME_initscripts = "initscripts"

