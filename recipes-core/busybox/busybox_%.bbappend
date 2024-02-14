FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://setuidgid.cfg \
			file://dnsd.cfg \
			file://inetd.cfg \
			file://history.cfg \
			file://archival.cfg \
			file://shell.cfg \
			file://tftp.cfg \
			file://logging.cfg \
			file://volumeid.cfg \
            		file://tr.cfg "
