#!/bin/bash

# simon-brook/gitpub
#
# Experimental code to publich git commits to ActivityPub
#
# Copyright (c) 2018 Simon Brooke
#
# Released under the MIT licence.

# I'm assuming the transmitter is either
# 1. on the path anyway; or
# 2. in /usr/local/bin
# Obvs this only works in a UN*X-style environment; I'm not sufficiently expert in
# Windows to know what to do there.
export PATH=/usr/local/bin:${PATH}

# Invoke the transmitter.
gitpub post-receive
