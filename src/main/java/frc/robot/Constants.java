// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    // USB ids

    // PWM ids
    

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

        rightWingRetract = 6,
        rightWingExtend = 7,

        armConeRetract = 1,
        armConeExtend = 0
    ;}
   
    //important values
    public static final  double LRdeadband = 0.1;
    public static final double minPower = 0.15;

    // buttons numbers
    public static class buttons{
        public static final int 
        //liftPiston = 3,
        //lowerPiston = 1,
        exitBalanceDrive = 5,
        flapWings = 1
        ;
    }
}
