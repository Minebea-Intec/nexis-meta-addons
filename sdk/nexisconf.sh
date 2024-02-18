#!/bin/sh

TOPDIR=$(pwd)
REPODIR=$TOPDIR

sed 's@{{REPODIR}}@'"$REPODIR"'@' $TOPDIR/sources/meta-addons-nexis/sdk/bblayers.conf.template > $REPODIR/conf/bblayers.conf
cp -a $TOPDIR/sources/meta-addons-nexis/sdk/local.conf $REPODIR/conf

