// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public final class Shooter{
        public static final int motor = 10;
        public static final int belt_front = 11;
        public static final int belt_back = 20;
        public static final double kP = 0.8;
        public static final double kI = 0.0;
        public static final double kD = 0.0;
        public static final double beltSpeed = 1;
        public static final int maxRPM = 1500;
        public static final int maxVoltage = 10;
    }

    public final class Drivetrain{
        public final static int leftFront = 24;
        public final static int leftBack = 13;
        public final static int rightFront = 23;
        public final static int rightBack = 15;
        public final static double kP = 1.0;
        public final static double kI = 0.5;
        public final static double kD = 0.0;
        public static final double leftSpeed = 3.0;
        public static final double rightSpeed = 3.0;
        public static final double kWheelRadius = 0.0762;
        public static final int kEncoderResolution = -2048;
        
    }
}
