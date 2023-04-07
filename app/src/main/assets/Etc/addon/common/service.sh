MODDIR=${0%/*}

fonts_customization_mod="/data/system/fonts_customization.xml"
product_fonts_customization="/product/etc/fonts_customization.xml"
system_fonts_customization="/system/etc/fonts_customization.xml"
sa="/product/etc/sa.xml"

if [ -f /data/system/fonts_customization.xml ]; then
	rm -rf $fonts_customization_mod
fi

touch /data/system/fonts_customization.xml

if [ -f /system/etc/fonts_customization.xml ]; then
	cat $system_fonts_customization >> $fonts_customization_mod
	sed -i '/<\/fonts-modification>/d' $fonts_customization_mod
	cat $sa >> $fonts_customization_mod
	mount -o bind $fonts_customization_mod $system_fonts_customization || true

elif [ -f /product/etc/fonts_customization.xml ]; then
	cat $product_fonts_customization >> $fonts_customization_mod
	sed -i '/<\/fonts-modification>/d' $fonts_customization_mod
	cat $sa >> $fonts_customization_mod
	mount -o bind $fonts_customization_mod $product_fonts_customization || true
fi
