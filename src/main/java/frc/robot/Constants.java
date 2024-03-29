// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

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

        leftWingRetract = 3,
        leftWingExtend = 2,

        rightWingRetract = 4,
        rightWingExtend = 5,

        armConeRetract = 1,
        armConeExtend = 0,

        arm= 15   //make that motor number 5 in peonix tuner
    ;
    }
   
    //important values
    public static final double MIN_POWER = 0.15;
    public static final double MIN_TURN = 0.1;

    public static final double MIN_GYRO_MOVE = 0.05;
    public static final double MIN_BALANCE_MOVE = 0.15;

    public static final double ARM_SPEED = 0.15;

    // buttons numbers
    public static class buttons{
        public static final int 
        //liftPiston = 3,
        //lowerPiston = 1,
        EXIT_BALANCE_DRIVE = 5,
        FLAP_WINGS = 1,
        FLAP_RIGHT = 4,
        FLAP_LEFT = 3,
        ARM_IN = 8,
        ARM_LOW_SHOOT = 14,
        ARM_MID_SHOOT = 15,
        ARM_HIGH_SHOOT = 16
        ;
    }
}
