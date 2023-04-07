package com.sajjad.nebula.common;

import com.topjohnwu.superuser.Shell;

public class References {
    public static boolean isNotificationServiceRunning = false;
    public static final int TOTAL_FONTS = Shell.cmd("cmd overlay list |  grep -E '^....SaOverlaysFONTS' | sed -E 's/^....//'").exec().getOut().size();
}
