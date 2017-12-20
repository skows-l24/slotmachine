#!/bin/bash

docker --version
pip install --user awscli
export PATH=$PATH:$HOME/.local/bin
eval $(aws ecr get-login --region us-east-1)
docker tag hackslot/slot-machine:greatest 758649603159.dkr.ecr.us-east-2.amazonaws.com/slotmachine
docker push 758649603159.dkr.ecr.us-east-2.amazonaws.com/slotmachine:greatest