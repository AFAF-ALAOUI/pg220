#!/bin/bash
make release
cd build
jar -cfe puissance.jar main.Power4  game/player/*.class game/*.class main/Power4.class
cd ..
cp build/puissance.jar .
