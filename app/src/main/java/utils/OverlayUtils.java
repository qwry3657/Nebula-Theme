package com.sajjad.nebula.utils;

import com.sajjad.nebula.Nebula;
import com.sajjad.nebula.config.PrefConfig;
import com.topjohnwu.superuser.Shell;

import java.io.File;
import java.util.List;

public class OverlayUtils {

    public static List<String> getOverlayList() {
        return Shell.cmd("cmd overlay list |  grep -E '^....SaOverlays' | sed -E 's/^....//'").exec().getOut();
    }

    public static List<String> getEnabledOverlayList() {
        return Shell.cmd("cmd overlay list |  grep -E '^.x..SaOverlays' | sed -E 's/^.x..//'").exec().getOut();
    }

    public static List<String> getDisabledOverlayList() {
        return Shell.cmd("cmd overlay list |  grep -E '^. ..SaOverlays' | sed -E 's/^. ..//'").exec().getOut();
    }

    public static boolean isOverlayEnabled(List<String> overlays, String pkgName) {
        for (String overlay : overlays) {
            if (overlay.equals(pkgName))
                return true;
        }
        return false;
    }

    public static boolean isOverlayDisabled(List<String> overlays, String pkgName) {
        for (String overlay : overlays) {
            if (overlay.equals(pkgName))
                return false;
        }
        return true;
    }

    static boolean isOverlayInstalled(List<String> enabledOverlays, String pkgName) {
        for (String line : enabledOverlays) {
            if (line.equals(pkgName))
                return true;
        }
        return false;
    }

    public static void enableOverlay(String pkgName) {
        Shell.cmd("cmd overlay enable --user current " + pkgName, "cmd overlay set-priority " + pkgName + " highest").exec();
        PrefConfig.savePrefBool(Nebula.getAppContext(), pkgName, true);
    }

    public static void disableOverlay(String pkgName) {
        Shell.cmd("cmd overlay disable --user current " + pkgName).exec();
        PrefConfig.savePrefBool(Nebula.getAppContext(), pkgName, false);
    }

    public static boolean overlayExists() {
        File f = new File("/system/product/overlay/SaOverlaysFONTS1.apk");
        return (f.exists() && !f.isDirectory());
    }
}
