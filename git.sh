#!/bin/bash

echo "start git add commit fetch merge push"
echo "git add -A"
git add -A

echo "git commit -m 'leetcode-louyuting'"
git commit -m 'leetcode-louyuting'

echo "git fetch origin master"
git fetch origin master

echo "git merge origin/master"
git merge origin/master

echo "git push origin master:master"
git push origin master:master
