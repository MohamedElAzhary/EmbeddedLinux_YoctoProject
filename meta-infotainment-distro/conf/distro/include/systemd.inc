# Add systemd as a feature
DISTRO_FEATURES:append = " systemd"

# Prevent sysvinit from being pulled into the build
DISTRO_FEATURES_BACKFILL_CONSIDERED += "sysvinit"

# Force the system to use systemd instead of default sysvinit
INIT_MANAGER = "systemd"
VIRTUAL-RUNTIME_init_manager = "systemd"
VIRTUAL-RUNTIME_initscripts = "systemd-compat-units"

