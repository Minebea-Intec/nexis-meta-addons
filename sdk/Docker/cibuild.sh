#!/bin/sh
cp -av sources/meta-addons-nexis/sdk/Docker/conf .
cp -av sources/meta-addons-nexis/sdk/local.conf conf
cp -av sources/meta-addons-nexis/sdk/Docker/dey-setup-environment .
. ./dey-setup-environment
bitbake dey-image-tiny && bitbake dey-image-tiny -c populate_sdk

