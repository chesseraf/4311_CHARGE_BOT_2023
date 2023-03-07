// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.putCone;

public final class Constants {

    // PS4 Constants
    public static class PS4 {
        public static final int X = 2, 
        CIRCLE = 3, SQUARE = 1, TRIANGLE = 4, LB = 5, RB = 6, TOUCHPAD = 9, OPTIONS = 10, L3 = 11, R3 = 12,
                LEFT_TRIGGER = 3, RIGHT_TRGGER = 4, LEFT_X = 0, LEFT_Y = 1, RIGHT_X = 2, RIGHT_Y = 5;
    }


    public static final double turnDeadBand = 0.05;
    public static final double speedDeadBand = 0.05;
    // port numbers on pdp, computer, pcm...
    public static class ports{
        public static final int 
        frontLeft = 13,
        backLeft = 12,
        frontRight = 11,
        backRight = 14,

        thrusty = 0,
        Joy2 = 1,

        commpressor = 0,

        leftWingRetract = 2,
        leftWingExtend = 3,

        rightWingRetract = 7,
        rightWingExtend = 6,

        armConeRetract = 1,
        armConeExtend = 0,

        arm= 15   //make that motor number 5 in peonix tuner
    ;
    }
   
    //important values
    public static final double MIN_POWER = 0.15;
    public static final double MIN_TURN = 0.15;

    public static final double MIN_GYRO_MOVE = 0.05;
    public static final double MIN_BALANCE_MOVE = 0.15;

    // buttons numbers
    public static class buttons{
        public static final int 
        //liftPiston = 3,
        //lowerPiston = 1,
        exitBalanceDrive = 5,
        flapWings = 1,
        flapRight = 2,
        flapLeft = 3,
        armIn = 4,
        armOut =6
        ;
    }
}