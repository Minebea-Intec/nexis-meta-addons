def run_svninfo(d):
    try:
        oeroot = d.getVar('COREBASE', True)
        return bb.process.run("svn info %s | grep ^Revision | cut -d' ' -f2" % oeroot)[0].strip('\n')
    except:
        return "undefined"

python() {
    svnbuild = run_svninfo(d)
    d.setVar('MI_SDK_SVNBUILD', svnbuild)
}

OS_RELEASE_FIELDS_append = " MI_SDK_SVNBUILD"

BB_DONT_CACHE = "1"
SYSROOT_DIRS_append = " ${sysconfdir}"

