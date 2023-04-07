SKIPMOUNT=false
PROPFILE=false
POSTFSDATA=false
LATESTARTSERVICE=true

on_install() {

	if [ -f /system/etc/fonts_customization.xml ];then
		ui_print "- Continuing installation..."
		unzip -o "$ZIPFILE" 'system/*' -d $MODPATH >&2
		
	elif [ -f /product/etc/fonts_customization.xml ];then
		ui_print "- Continuing installation..."
		unzip -o "$ZIPFILE" 'system/*' -d $MODPATH >&2
	else
		cancel "- Not found fonts_customization.xml! This rom is not supported!"
	fi
	
}

set_permissions() {
  set_perm_recursive $MODPATH 0 0 0755 0644
  }

cancel() {
  imageless_magisk || unmount_magisk_image
  abort "$1"
}