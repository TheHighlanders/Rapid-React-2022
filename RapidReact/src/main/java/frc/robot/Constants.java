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

    // Joysticks
    public static final int XBOX = 0;
    public static final int XBOXCLIMB = 1;
    
    // Drive Motors
    public static final int LEFT_ONE = 4;
    public static final int LEFT_TWO = 6;
    public static final int RIGHT_ONE = 5;
    public static final int RIGHT_TWO = 3;

    // Intake
    public static final int INTAKE = 8;

    // Door
    public static final int DOORMOTOR = 7;

    // Climb Motors
    public static final int CLIMBERMOTOR_ONE = 9;
    public static final int CLIMBERMOTOR_TWO = 10;
    public static final int CLIMBERMOTOR_THREE = 11;
}
