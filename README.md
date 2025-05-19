# AM62x
Am62x Project creation

#Compilation 

Link :- https://software-dl.ti.com/processor-sdk-linux/esd/AM62X/09_01_00_08/exports/docs/linux/Overview_Building_the_SDK.html
SDK :-09_01_00_08 
$ sudo apt-get update
$ # Install packages required for builds
$ sudo apt-get -f -y install \
    git build-essential diffstat texinfo gawk chrpath socat doxygen \
    dos2unix python3 bison flex libssl-dev u-boot-tools mono-devel \
    mono-complete curl python3-distutils repo pseudo python3-sphinx \
    g++-multilib libc6-dev-i386 jq git-lfs pigz zstd liblz4-tool \
    cpio file zstd lz4

$ sudo dpkg-reconfigure dash
=> Be sure to select “No” when you are asked to use dash as the default system shell.

#Build Steps
$ git clone https://git.ti.com/git/arago-project/oe-layersetup.git tisdk
$ cd tisdk
$ ./oe-layertool-setup.sh -f configs/processor-sdk/processor-sdk-09.01.00-config.txt
$ cd build
$ . conf/setenv

#Dependencies 
export LC_ALL="en_US.UTF-8"
export LC_CTYPE="en_US.UTF-8"
export LC_NUMERIC="en_US.UTF-8"
export LANG=en_US.UTF-8
export LANGUAGE=en_US.UTF-8
ulimit -n 4096


$ MACHINE=am62xx-evm bitbake -k tisdk-default-image

